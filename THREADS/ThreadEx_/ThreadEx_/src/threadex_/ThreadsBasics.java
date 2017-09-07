package threadex_;

public class ThreadsBasics {
    private static boolean doRun = true;

    public ThreadsBasics() {
    }

    public static void main(String[] args){
        long start = System.currentTimeMillis();
        Runnable r = new Runnable(){
            public void run() {
                System.out.println("Thread started");
                try {
                    int count = 0;
                    while (doRun && count <= 1000) {
                        Thread.sleep(10);
                        count += 10;
                        for (long i=0; i<1000000; i++){
                        }
                    }
                    System.out.println("Thread finished");
                } catch (InterruptedException ex) {
                    ex.printStackTrace(System.out);
                }
            }
        };
        //r.run();//��� �� ������ ��������, � ������ ����� ������ ���
        final Thread t = new Thread(r);
        //�������-�����������. �����
        Thread observer = new Thread(){
            {
                this.setDaemon(true);
                this.setPriority(Thread.MAX_PRIORITY);
            }

            public void run(){
                Thread.State old = null;
                while (true){
                    if (t.getState()!=old){
                        old = t.getState();
                        System.out.println("t state is "+old);
                    }
                    //this.yield();//������������ ������������� ��������������
                    try {
                        Thread.sleep(1);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        };
        observer.start();
        t.start();//������ ��������
        Thread t2 = new Thread(){
            public void run(){
                System.out.println("Thread2 started");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                //t.interrupt();//���������� ��� �������� �
                doRun = false;
                System.out.println("Thread2 finished");
            }
        };
        t2.start();
        try {
            t.join();//���������������� ��������� ������� �� ���� �������, ���� �� ���������� ������� �� ������ ������ �����
            //t.start();//������� ������, ��� ��� ������� ����� ��������� ������ ���� ���
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        long time = System.currentTimeMillis()-start;
        System.out.println("main finised, execution time = "+time+" ms");
    }
}
