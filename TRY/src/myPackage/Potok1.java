package myPackage;

import java.util.Random;
import java.io.PrintStream;
import java.io.FileOutputStream;
import java.io.*;
import javax.swing.JOptionPane;

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
public class Potok1 extends Thread {

    static int number;
   boolean toDestroy=false;
   boolean toPause=false;
   Frame4 frame;
   static ThreadGroup
           grandfather = new ThreadGroup("GRANDFATHER"),
   father = new ThreadGroup(grandfather,"FATHER"),
   sun = new ThreadGroup(father,"SUN");
   static Random rnd = new Random();

   public Potok1(){
       super(Potok1.definitionOfThreadGroup(),"thread #"+number);
       number++;
   }


   public void myMon(ThreadGroup tg){
       ThreadGroup myGroup=tg.getParent();
       if (myGroup!=null)myMon(myGroup);
       else tg.list();

       //while(myGroup!=null){
         //  myMon(myGroup);
       //}
       //tg.list();

   }

   public static void myMonitoring(){
       grandfather.list();
   }


    public void setToPause(){
       toPause=!toPause;
   }


    public void setToDestroy(){
        toDestroy=!toDestroy;
        toPause=true;
    }

    public static ThreadGroup definitionOfThreadGroup(){
       int kindOfGroup=rnd.nextInt(3);
       switch (kindOfGroup){
       case 0:
         return grandfather;
       case 1:
         return father;
         default:
             return sun;
       }
   }



    public void run(){
      // int i=0;
       while (toDestroy == false) {
           while (toPause == false) {
               try {
                   Thread.sleep(0);
               } catch (InterruptedException ex) {
               }
               //   ++i;
           }
       }
   }
}
