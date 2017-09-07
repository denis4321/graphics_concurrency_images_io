package potoky;

import javax.swing.ImageIcon;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2009</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class Animation extends Thread{
   Engine en;
   private boolean b=true;
    public Animation(Engine en) {
    this.en=en;
    }


    public void setStopThread(boolean a){
        b=a;
    }

    public boolean getStopThread(){
        return b;
    }

    public void run(){
        int number=1;
        while (b==true){
            en.returnLabel(en.potokNumber).setIcon(new ImageIcon(1 + "" +(1 + number % 6) + ".png"));
            try {
                Thread.sleep(120);
            }
            catch (InterruptedException ex) {
            }
            number++;
        }
    }
}
