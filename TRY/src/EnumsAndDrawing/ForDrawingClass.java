package EnumsAndDrawing;

import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Color;

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
public class ForDrawingClass extends JPanel implements Runnable {
    private int x1,y1,i;
    private boolean b=true;
    public boolean b1=true;
    private ForEnumsClass m;
    public ForDrawingClass() {
    }

    public void setX1(int i) {
        x1 = i;
    }

    public void setY1(int i) {
        y1 = i;
    }

    public void setEnum(ForEnumsClass i) {
        m = i;
    }

    public int getX1() {
        return x1;
    }

    public void getSMT() {
        switch (m) {
        case CUBE:
            setY1(-getX1()+180);// - 5) * (getX1() - 10) * (getX1() - 15));
            break;
        case LINE:
            setY1(getX1());
            break;
        case PARAB:
            setY1((getX1() - 20) * (getX1() - 10));
        }
    }

    public int getY1() {
        return y1;
    }

    public void paintComponent(Graphics g) {
           System.out.println("I AM IN PAINT()");
        super.paintComponent(g);
        //g.drawLine(9,9,12,12);
        if (b==false)  g.drawString("�������", this.getHeight()/2, getWidth()/2);
        else {

            if (i == 7) {
                i = 1;
            }
            ImageIcon im = new ImageIcon("C:\\Documents and Settings\\Me\\������� ����\\JAVA-RARS\\ListProject\\ListProject\\ListProject\\1" +
                                         i + ".PNG");

            g.drawImage(im.getImage(), getX1(), getY1(), 20, 20, null);
            i++;
        }
    }

    public void run() {
        int i = 0;
        y1 = 0;
        x1 = 0;
        b=true;
            while ((getX1() < getWidth() - 20) && (getY1() < getHeight() - 20)) {
               System.out.println(i+"======================================");
                try {
                    Thread.sleep(40);
                    this.setX1(i);
               this.getSMT();
               repaint();
                } catch (InterruptedException ex) {
                }
                i++;
            }
           b = false;
    }
}
