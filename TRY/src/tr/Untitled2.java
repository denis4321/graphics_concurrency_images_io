package tr;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2010</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class Untitled2 extends Thread{

    static boolean toPause=false;//  ��������� � ������ 2 ��� �����
     static boolean toDestroy=true;// � ������ 3 ��� ����������� �������� ������
     Frame3 f;

     public Untitled2(Frame3 f) {
        this.f=f;
    }



    public void run(){
              int i=0;
        while (toDestroy==false) {
                    if (toPause==false) {
                try {
                    Thread.sleep(120);
                } catch (InterruptedException ex) {
                }
                f.jLabel1.setText(i + "");
                i++;
            }
        }
    }
}


