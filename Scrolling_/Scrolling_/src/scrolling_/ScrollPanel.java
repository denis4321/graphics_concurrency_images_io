package scrolling_;

import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.lang.Thread.*;

/**
 * <p>Title: ScrollPanel</p>
 *
 * <p>Description: Scrolling Panel</p>
 *
 * <p>Copyright: Copyright (c) 2010</p>
 *
 * <p>Company: LightFire</p>
 *
 * @author Raziel Redstone
 * @version 1.0
 */
public class ScrollPanel extends JPanel implements Scrollable {
    File currDir;
    Image[] imgs;

    public ScrollPanel() {
        currDir = null;
        imgs = null;
        setPreferredSize(new Dimension(0,0));
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }

    public void setCurrentDir(File dir){
        this.currDir = dir;
        refreshDir();
    }

    private void refreshDir(){
        final File[] arr = currDir.listFiles(new FileFilter(){
            public boolean accept(File pathname) {
                if (pathname.getPath().toLowerCase().endsWith(".jpg"))
                    return true;
                else
                    return false;
            }
        });
      final   ProgressMonitor mon = new javax.swing.ProgressMonitor(null,"Loading pics..","",0,100);
      final MediaTracker mt = new MediaTracker(this);
      Thread t = new Thread(new Runnable(){
            public void run() {
//                ProgressMonitor mon = new javax.swing.ProgressMonitor(ScrollPanel.this,"Loading pics..","",0,100);
                mon.setMillisToPopup(100);
                mon.setMillisToDecideToPopup(200);
//                MediaTracker mt = new MediaTracker(ScrollPanel.this);
                imgs = new Image[arr.length];
                int pw = 0;
                for (int i = 0; i < arr.length; i++) {
                    imgs[i] = Toolkit.getDefaultToolkit().getImage(arr[i].
                            getPath());
                    mt.addImage(imgs[i], 0);
                    try{
                        mt.waitForID(0);
                    } catch (InterruptedException ex){
                        ex.printStackTrace();
                    }
                    Icon ic = new ImageIcon(imgs[i].getScaledInstance(getHeight(),
                    getHeight(), Image.SCALE_AREA_AVERAGING));
                    JLabel lbl = new JLabel(ic);
                    ScrollPanel.this.add(lbl, new GridBagConstraints(i, 0, 1, 1, 0, 0
                                                 , GridBagConstraints.CENTER,
                                                 GridBagConstraints.NONE,
                                                 new Insets(0, 0, 0, 0), 0, 0));
                    pw += lbl.getIcon().getIconWidth();
                    int pval = (int)(i*100.0/arr.length);
                    mon.setProgress(pval);
                    mon.setNote(pval+" %");
                }

                mon.setProgress(mon.getMaximum());
                mon.setNote("Ready");
                System.out.println();
                System.out.println(pw+" "+getHeight());
                ScrollPanel.this.setPreferredSize(new Dimension(pw,getHeight()));
                revalidate();
            }
        });
        t.setPriority(Thread.NORM_PRIORITY);
        t.start();
    }


    public Dimension getPreferredScrollableViewportSize() {
        return getPreferredSize();
    }

    public int getScrollableUnitIncrement(Rectangle visibleRect,
                                          int orientation, int direction) {
        return 10;
    }

    public int getScrollableBlockIncrement(Rectangle visibleRect,
                                           int orientation, int direction) {
        return 100;
    }

    public boolean getScrollableTracksViewportWidth() {
        return false;
    }

    public boolean getScrollableTracksViewportHeight() {
        return true;
    }
}
