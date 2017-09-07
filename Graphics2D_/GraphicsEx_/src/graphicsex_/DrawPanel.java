package graphicsex_;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Point;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.BasicStroke;
import java.awt.GradientPaint;
import java.awt.RenderingHints;

public class DrawPanel extends JPanel {
    int x = 200;
    private Point pos = new Point(0, 100);
    private int direction = 1;
    private int DIM = 75;

    public DrawPanel() {
       setBackground(Color.white);
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        /*g.setColor(Color.red);*/
    //    g.setClip(50, 50, 50, 100);
        /*g.drawLine(0, 0, x, 200);
        g.setColor(Color.BLUE);
        g.setFont(new Font("SansSerif", Font.BOLD, 14));
        g.drawLine(0, 210, getWidth(), 210);
        g.drawString("just Some text", 50, 210);
        FontMetrics fm = g.getFontMetrics();*/
        //g.setXORMode(Color.black);
        //g.setPaintMode();
        /*g.fillRect(0, 0, 75 , getHeight());
        g.setColor(Color.red);
        g.fillOval(pos.x, pos.y, DIM, DIM);*/

    Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.blue);
        //Stroke s = new BasicStroke(30, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
        //Stroke s = new BasicStroke(30, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        //Stroke s = new BasicStroke(30, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER, 1.5f);
        Stroke s = new BasicStroke(5, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER, 1.5f, new float[]{25, 10, 10, 10}, 0);
        g2.setStroke(s);
        g2.drawRect(50, 50, 100, 100);
        g2.setColor(Color.red);
        g2.drawLine(200, 200, 350, 100);
        g2.setPaint(new GradientPaint(200, 30, Color.black, 200, 67, Color.lightGray, true));
        g2.fillOval(200, 30, 100, 75);
        g2.setColor(Color.red);
        g2.setStroke(new BasicStroke(7));
        g2.drawOval(200, 30, 100, 75);
        g2.setStroke(new BasicStroke(7));
        g2.drawOval(200, 30, 100, 75);
        g2.setStroke(new BasicStroke());
        g2.setColor(Color.green);
        g2.drawRect(50, 50, 100, 100);
        g2.drawLine(200, 200, 350, 100);
        g2.drawOval(200, 30, 100, 75);
    }

    public void incx(){
        x+=5;
        repaint();
    }

    public void incPos(){
        int nx = pos.x+direction;
        if (nx<0||nx+DIM>=getWidth()){
            direction = -direction;
        }
        pos.move(pos.x+direction, pos.y);
        repaint();
    }
}
