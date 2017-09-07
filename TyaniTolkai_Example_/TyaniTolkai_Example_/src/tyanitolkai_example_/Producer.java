package tyanitolkai_example_;

public class Producer extends Thread{
    private long delay;
    private int number = 0;
    private boolean isConsumed = false;

    public Producer(long delay) {
        this.delay = delay;
    }

    public void run(){
        while (number<100){

           synchronized (this){
                number++;
                System.out.println(number + " produced");
                isConsumed = false;
                synchronized (TTMain.c){
                    System.out.println("Producer starts notifying consumer");
                    TTMain.c.notify();
                    System.out.println("Producer stops notifying consumer");
                }
            }

            try {
                Thread.sleep(0);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            synchronized(this){
                if (isConsumed==false){
                    try {
                        wait();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }

        }
    }

    public synchronized int consume(){
        isConsumed = true;
        return number;
    }

    public synchronized boolean isProduced(){
        return !isConsumed;
    }

}
