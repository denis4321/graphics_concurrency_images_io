package EnumsAndDrawing;

import javax.swing.JPanel;
import java.awt.Graphics;

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
public class DrawPanel extends JPanel {
    public DrawPanel() {
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawLine(10,10,40,40);
    }

}
