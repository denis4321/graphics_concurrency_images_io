package drawex_;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import java.awt.*;

public class DrawPanel extends JPanel {
    BorderLayout borderLayout1 = new BorderLayout();
    int x = 10;
    int y = 10;

    public DrawPanel() {
        setBackground(Color.white);
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        //g.drawLine(10, 10, 10, 10);
        g.fillRect(x, y, 10, 10);
    }

    public void setPos(int x, int y){
        this.x = x;
        this.y = y;
    }

}
