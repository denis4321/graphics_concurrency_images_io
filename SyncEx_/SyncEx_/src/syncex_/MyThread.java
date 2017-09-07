package syncex_;

public class MyThread extends Thread{
    private long delay;
    private SyncMain owner;

    public MyThread(long delay, SyncMain owner, String name) {
        super(name);
        this.delay = delay;
        this.owner = owner;
    }

    public void run(){
        for (int i=0; i<10; i++){
            owner.print(getName()+": "+i);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
