package duck;

import javax.swing.JPanel;
import java.awt.Graphics;
import javax.swing.ImageIcon;

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
        g.drawImage(new ImageIcon("1.png").getImage(),0,0,getWidth(),getHeight(),null);
    }
}
