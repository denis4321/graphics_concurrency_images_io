package cards;

import javax.swing.ImageIcon;

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
public class Compiuters extends Thread {
    int compScore;
    Frame1 frame;
    private int id;

    public Compiuters(Frame1 frame,int id) {
        this.frame=frame;
        this.id=id;
    }

    //public void setIndex(int index){
      //  this.index=index;
    //}

           public void run(){
               int dx=10;
               int dy=10;
               int x=0;
               int y=0;
               if (id==1){x=112-dx;y=163;}
                if (id==2){x=287-dx;y=206;}
                 if (id==3){x=459-dx;y=179;}
               while(compScore<=11&&frame.jPanel1.index!=id){
                   try {
                       frame.jPanel1.count++;
                       Thread.sleep(900);
                       int i=frame.generator.getKoloda()[frame.jPanel1.count];
                       int score=frame.jPanel1.getScoreByInteger().get(i);
                       compScore+=score;


                       frame.jPanel1.getGraphics().drawImage(new ImageIcon("111.PNG").getImage(),x,y,x+=dx,y+=dy,null);
                   } catch (InterruptedException ex) {
                       ex.printStackTrace();
                   }
           }


       }


}
