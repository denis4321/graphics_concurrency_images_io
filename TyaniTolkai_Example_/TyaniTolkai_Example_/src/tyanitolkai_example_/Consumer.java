package tyanitolkai_example_;

public class Consumer extends Thread{
    private long delay;

    public Consumer(long delay) {
        this.delay = delay;
    }

    public void run(){
        int num = 0;
        while (num<100){
            num = TTMain.p.consume();
            System.out.println("\t"+num+" consumed");
            synchronized (TTMain.p){
                TTMain.p.notify();
            }
            try {
                Thread.sleep(delay);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            synchronized (this){
                try {
                    if (!TTMain.p.isProduced()) {
                        System.out.println("Consumer starts waiting");
                        wait();
                        System.out.println("Consumer stops waiting");
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
