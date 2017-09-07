package ctulhufhtagn_conarh;

import java.awt.Rectangle;
import java.util.*;
import java.util.Timer;

import javax.swing.JOptionPane;

public class Ctulhu extends Mob{
    private HashSet<Mob> victims = new HashSet<Mob>();
    private long lastAte = 1;
    private int speed = 2;

    public Ctulhu(Timer t) {
        super(t, "ctulhu.GIF", 70, 70);
        t.scheduleAtFixedRate(new TimerTask(){
            public void run() {
                synchronized (mon){
                    Mob nearest = null;
                    double minDist = Integer.MAX_VALUE;
                    for (Iterator<Mob> itr = victims.iterator(); itr.hasNext();){
                        Mob v = itr.next();
                        double dist = Mob.getDistance(v, Ctulhu.this);
                        if (dist<minDist){
                            minDist = dist;
                            nearest = v;
                        }
                    }
                    if (nearest != null) {
                        Rectangle nr = nearest.getBounds();
                        Rectangle cr = getBounds();
                        if (nr.intersects(cr)) {
                            if (nearest instanceof Cultist) {
                                die();
                            } else
                            if (nearest instanceof Tyan) {
                                ((Tyan) nearest).beEaten(false);
                                lastAte = System.currentTimeMillis();
                                speed = 6;
                            }
                        }
                        if (System.currentTimeMillis()-lastAte>2000){
                            speed++;
                            speed = speed+3;

                            lastAte = System.currentTimeMillis();
                        }
                        moveMob(nearest.getX() - getX() < 0 ? -1 : 1,
                                nearest.getY() - getY() < 0 ? -1 : 1);
                    }
                }
            }
        }, 1, 20);
    }

    public int moveSpeed() {
        return speed;
    }

    public void addVictim(Mob m){
        synchronized (mon){
            victims.add(m);
        }
    }

    public void removeVictim(Mob m) {
        synchronized (mon){
            victims.remove(m);
        }
    }

    protected void die(){
        JOptionPane.showMessageDialog(Ctulhu.this.
                                      getParent(), "��� �������� :(",
                                      "������!", JOptionPane.WARNING_MESSAGE);
        System.exit(0);
    }


}