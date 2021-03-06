package dd1.tt;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTaskEx {
    public TimerTaskEx() {
    }

    public static void main(String[] args) {
        Timer t = new Timer();
        t.schedule(new TimerTask(){
            private long lastRun = System.currentTimeMillis();

            public void run() {
                //���� - ������
                try {
                    System.out.println("������ - time="+(System.currentTimeMillis()-lastRun));
                    lastRun = System.currentTimeMillis();
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }, 1, 500);
        t.schedule(new TimerTask(){
            private long firstTime = System.currentTimeMillis();
            private long lastRun = System.currentTimeMillis();
            private int count = 0;

            public void run() {
                count++;
                long time = System.currentTimeMillis() - lastRun;
                System.out.println("\t����� ����� - time=" +
                                   time+", medium="+(System.currentTimeMillis()-firstTime)/count);
                lastRun = System.currentTimeMillis();
            }

        }, 1, 550);

    }
}
