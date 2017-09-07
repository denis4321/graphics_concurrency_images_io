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
        //r.run();//Это НЕ запуск процесса, а просто вызов метода ран
        final Thread t = new Thread(r);
        //Процесс-наблюдатель. Демон
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
                    //this.yield();//Классическая кооперативная мнгозадачность
                    try {
                        Thread.sleep(1);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        };
        observer.start();
        t.start();//Запуск процесса
        Thread t2 = new Thread(){
            public void run(){
                System.out.println("Thread2 started");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                //t.interrupt();//Прерывание сна процесса т
                doRun = false;
                System.out.println("Thread2 finished");
            }
        };
        t2.start();
        try {
            t.join();//Приостанавливает вызвавший процесс до того момента, пока не закончится процесс на которм вызван джоин
            //t.start();//Вызовет ошибку, так как процесс можно запустить только один раз
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        long time = System.currentTimeMillis()-start;
        System.out.println("main finised, execution time = "+time+" ms");
    }
}
