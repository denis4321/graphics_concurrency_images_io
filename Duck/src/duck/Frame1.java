package duck;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Rectangle;
import java.util.Timer;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

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
public class Frame1 extends JFrame {
    JPanel contentPane;
    int mouseX,mouseY;
    Timer t=new Timer();
    BorderLayout borderLayout1 = new BorderLayout();
    DrawPanel jPanel1 = new DrawPanel();
    JButton jButton1 = new JButton();
    JButton jButton2 = new JButton();
    JButton jButton3 = new JButton();
    public Frame1() {
        try {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            jbInit();
           // new Units(t,this,jButton1);
           // new Units(t,this,jButton2);
            // new Units(t,this,jButton3);


        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    public float distance(JButton but){
        double x1=but.getWidth()/2+but.getBounds().getMinX();
        double y1=but.getHeight()/2+but.getBounds().getMinY();
        double a=Math.abs(x1-mouseX);
        double b=Math.abs(y1-mouseY);
        return (float)Math.sqrt(a*a+b*b);
    }





    /**
     * Component initialization.
     *
     * @throws java.lang.Exception
     */
    private void jbInit() throws Exception {
        contentPane = (JPanel) getContentPane();
        contentPane.setLayout(borderLayout1);
        setSize(new Dimension(400, 300));
        setTitle("Frame Title");
        this.addWindowListener(new Frame1_this_windowAdapter(this));
        contentPane.addMouseMotionListener(new
                Frame1_contentPane_mouseMotionAdapter(this));
        jButton1.addActionListener(new Frame1_jButton1_actionAdapter(this));
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new Frame1_jButton2_actionAdapter(this));
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new Frame1_jButton3_actionAdapter(this));
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        contentPane.add(jPanel1, java.awt.BorderLayout.CENTER);
        jPanel1.add(jButton1);
        jPanel1.add(jButton2);
        jPanel1.add(jButton3);
    }

    public void contentPane_mouseMoved(MouseEvent e) {
        mouseX=e.getX();
        mouseY=e.getY();
    }

    public void jButton1_actionPerformed(ActionEvent e) {
        jButton1.setActionCommand("1");
      //  jButton1.setIcon(new ImageIcon("2.png"));;
       // new Units(t,this,jButton1);
    }

    public void jButton2_actionPerformed(ActionEvent e) {
         jButton2.setActionCommand("1");
         //jButton2.setIcon(new ImageIcon("2.png"));;
         //new Units(t,this,jButton2);
    }

    public void jButton3_actionPerformed(ActionEvent e) {
         jButton3.setActionCommand("1");
         //jButton3.setIcon(new ImageIcon("2.png"));;
         //new Units(t,this,jButton3);
    }

    public void this_windowOpened(WindowEvent e) {
        new Units(t,this,jButton1);
           new Units(t,this,jButton2);
            new Units(t,this,jButton3);

    }
}


class Frame1_this_windowAdapter extends WindowAdapter {
    private Frame1 adaptee;
    Frame1_this_windowAdapter(Frame1 adaptee) {
        this.adaptee = adaptee;
    }

    public void windowOpened(WindowEvent e) {
        adaptee.this_windowOpened(e);
    }
}


class Frame1_jButton3_actionAdapter implements ActionListener {
    private Frame1 adaptee;
    Frame1_jButton3_actionAdapter(Frame1 adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButton3_actionPerformed(e);
    }
}


class Frame1_jButton2_actionAdapter implements ActionListener {
    private Frame1 adaptee;
    Frame1_jButton2_actionAdapter(Frame1 adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButton2_actionPerformed(e);
    }
}


class Frame1_jButton1_actionAdapter implements ActionListener {
    private Frame1 adaptee;
    Frame1_jButton1_actionAdapter(Frame1 adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButton1_actionPerformed(e);
    }
}


class Frame1_contentPane_mouseMotionAdapter extends MouseMotionAdapter {
    private Frame1 adaptee;
    Frame1_contentPane_mouseMotionAdapter(Frame1 adaptee) {
        this.adaptee = adaptee;
    }

    public void mouseMoved(MouseEvent e) {
        adaptee.contentPane_mouseMoved(e);
    }
}
