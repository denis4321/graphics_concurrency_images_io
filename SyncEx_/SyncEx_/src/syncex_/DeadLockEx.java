package syncex_;

public class DeadLockEx extends Thread{
    private static final Object mon1 = new Object();
    private static final Object mon2 = new Object();
    private int mode;

    public DeadLockEx(int mode) {
        this.mode = mode;
        //setPriority(Thread.MAX_PRIORITY);
    }

    public void run(){
        try{
            switch (mode) {
            case 1:
                met1();
                break;
            case 2:
                met1();
                break;
            }
        } catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }

    public void met1() throws InterruptedException {
        synchronized(mon1){
            System.out.println(getName()+": Entring mon1");
            Thread.sleep(10);
            met2();
            System.out.println(getName()+": Leaving mon1");
        }
    }

    public void met2() throws InterruptedException {
        synchronized (mon2) {
            System.out.println(getName()+": Entring mon2");
            Thread.sleep(10);
            met1();
            System.out.println(getName()+": Leaving mon2");
        }
    }


    public static void main(String[] args) {
        DeadLockEx t1 = new DeadLockEx(1);
        DeadLockEx t2 = new DeadLockEx(2);
        t1.start();
        t2.start();
    }
}
