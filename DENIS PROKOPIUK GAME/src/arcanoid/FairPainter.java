package arcanoid;

import java.util.Timer;
import javax.swing.JButton;
import java.util.TimerTask;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.Icon;

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
public class FairPainter {
    Timer t;
    final JButton but;
   private Image[] im = new Image[9];
    private Icon[] ic = new Icon[9];

    public FairPainter(Timer t, JButton but) {
        for (int i = 0; i < 9; i++) {
            im[i] = Toolkit.getDefaultToolkit().createImage(i + ".jpg");
            ic[i] = new ImageIcon(im[i].getScaledInstance(but.getWidth(),
                    but.getHeight(),
                    Image.SCALE_AREA_AVERAGING));
        }
        this.t = t;
        this.but = but;
        final JButton b = but;
        t.scheduleAtFixedRate(new TimerTask() {
            int i = -1;
            int f;
            boolean k = false;
            public void run() {
                b.setActionCommand(1 + "");
                f++;
                if (!k) {
                    i++;
                    if (i == 9) {
                        k = !k;
                    }
                }
                if (k) {
                    i--;
                    if (i == 0) {
                        k = !k;
                    }
                }
                b.setIcon(ic[i]);
                if (f > 35) {
                    b.setIcon(null);
                    if (f > 90) {
                        f = 0;
                    }
              b.setActionCommand("90");
                   cancel();
                }
            }
        }, 0, 105);
    }

}
