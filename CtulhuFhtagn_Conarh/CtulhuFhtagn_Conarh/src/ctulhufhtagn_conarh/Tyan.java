package ctulhufhtagn_conarh;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;
import java.awt.Container;
import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JOptionPane;

public class Tyan extends Mob{
     public static Random rnd = new Random();
     private Ctulhu ctulhu;
     private JPanel panel;
     private Cultist cultist;
     public static final double viewDist = 150;
     private TimerTask runTask = new TimerTask() {
         public void run() {
             if (getX() + getWidth() < panel.getWidth() - 1) {
                 moveMob(1, 0);
             } else {
                 beEaten(true);
             }
         }
     };
     private TimerTask awayTask = new TimerTask() {
             public void run() {
                 synchronized (mon) {
                     double dist = getDistance(Tyan.this, cultist);
                     if (dist<viewDist){
                         escape(cultist);
                         return;
                     }
                     dist = getDistance(Tyan.this, ctulhu);
                     if (dist<viewDist){
                         escape(ctulhu);
                         return;
                     }
                 }
            }
        };


     public Tyan(Timer t, Ctulhu ch, Cultist pl, JPanel p) {
         super(t, "tyan.GIF", 35, 35);
         ctulhu = ch;
         panel = p;
         cultist = pl;
         t.scheduleAtFixedRate(runTask, 1, 20);
         t.scheduleAtFixedRate(awayTask, 1, 20);
    }

    public void escape(Mob m){
        moveMob(1, m.getY()<getY() ? 1 : -1);
    }

    public int moveSpeed() {
        return 6;
    }

    public void beEaten(boolean escape){
        runTask.cancel();
        ctulhu.removeVictim(this);
        panel.remove(this);
        panel.revalidate();
        panel.repaint();
        createNew(getTimer(), panel, ctulhu, cultist);
    }

    public static void createNew(final Timer t, final JPanel scene, final Ctulhu ch, final Cultist pl){
        t.schedule(new TimerTask(){
            public void run(){
                Tyan zhertva = new Tyan(t, ch, pl, scene);
                zhertva.setLocation(0, rnd.nextInt(scene.getHeight()-zhertva.getHeight()-100));
                scene.add(zhertva);
                scene.revalidate();
                ch.addVictim(zhertva);
            }
        }, 2000+rnd.nextInt(2000));
    }
}
