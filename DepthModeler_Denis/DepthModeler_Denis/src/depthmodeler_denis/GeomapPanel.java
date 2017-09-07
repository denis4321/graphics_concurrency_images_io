package depthmodeler_denis;


import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImageFilter;
import javax.imageio.ImageReader;
import java.io.File;
import javax.imageio.stream.ImageInputStream;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.Color;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.Point;
import java.util.Arrays;

public class GeomapPanel extends JPanel {
    BufferedImage im;
    MainInt main;
    File f = new File("geo_earth_map.jpg");
    Point p1, p2;
    int [] xPoints;
    int x1,x2,y1,y2;
   int count;

    public GeomapPanel(MainInt main) {
        this.main = main;
        try {
            String suf = f.getName().substring(f.getName().lastIndexOf(".") + 1);
            ImageReader r = ImageIO.getImageReadersBySuffix(suf).next();
            ImageInputStream in = ImageIO.createImageInputStream(f);
            r.setInput(in);
            im = r.read(0);
            r.dispose();
            in.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        this.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                howDeepByColor();
                ddd();

            }


            public void mousePressed(MouseEvent e) {
                p1 = new Point(e.getX(), e.getY());
                p2 = null;
                repaint();
            }
        }
        );

        this.addMouseMotionListener(new MouseMotionAdapter() {


            public void mouseDragged(MouseEvent e) {
                p2 = new Point(e.getX(), e.getY());
                repaint();

            }

        });
    }


    public void ddd(){
        main.Relief.setColorMap();
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setPreferredSize(new Dimension(im.getWidth(), im.getHeight()));
        main.Split.revalidate();
        g.drawImage(im, 0, 0, null);
        g.setColor(Color.red);
        if (p1 != null && p2 != null) {
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
    }


    public int[] giveCordinats() {
        int n = (int) (Math.abs(p2.getX() - p1.getX()));
        //случай прямой вида х=const;
        if (n == 0) {
            int m = (int) Math.min(p1.getY(), p2.getY());
            int min = (int) Math.min(p1.getX(), p2.getX());
            int[] yPoints = new int[(int) Math.abs(p1.getY() - p2.getY())];
             xPoints=new int[yPoints.length];
            for (int i = 0; i < yPoints.length; i++) {
                yPoints[i] = m + i;
                xPoints[i]=min;
            }
            return yPoints;
        }
        //случай прямой вида y=const;
        //или y=f(x);
        else {
            int[] yPoints = new int[n];
             xPoints = new int[n];
            int a = (int) (p2.getX() - p1.getX());
            int b = (int) (p2.getY() - p1.getY());

            int x = (int) Math.max(p1.getX(), p2.getX());
            int min = (int) Math.min(p1.getX(), p2.getX());
            for (int i = 0; i < yPoints.length; i++) {
                //2 случая напрвления прямой:

                //слева-направо
                if (p1.getX() < p2.getX()) {
                    yPoints[i] = (int) ((p1.getX() + i - p1.getX()) * b / a +
                                        p1.getY());
                    xPoints[i]=min+i;
                }
                //справо-налево
                else {
                    yPoints[i] = (int) ((p2.getX() + i - p2.getX()) * b / a +
                                        p2.getY());
                    xPoints[i]=x-i;
                }
            }
            return yPoints;
        }
    }

    public Color[] howDeepByColor(){
       Color [] colors =new Color[giveCordinats().length];
        if (im!=null){
           for (int i=0; i<giveCordinats().length;i++) {
               int c = im.getRGB(xPoints[i],giveCordinats()[i]);
               colors[i]=new Color(c);
               //System.out.println(colors[i]);
           }
       }
       return colors;
   }

}
