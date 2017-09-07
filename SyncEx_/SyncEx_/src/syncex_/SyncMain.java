package syncex_;

public class SyncMain {
    StringBuilder sb = new StringBuilder();

    public SyncMain() {
        MyThread t1 = new MyThread(500, this, "Thread1");
        MyThread t2 = new MyThread(700, this, "tHREAD2");
        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        new SyncMain();
    }

    public /*synchronized*/ void print(String mess){
        synchronized (this){//Равносильно декларации сунхронайзед выше
        //synchronized(new Object()){//По сути бессмысленная конструкцмя, так как каждый раз создается новый объект
            for (char c : mess.toCharArray()) {
                sb.append(c);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            System.out.println(sb);
            sb.setLength(0);
        }
    }
}
