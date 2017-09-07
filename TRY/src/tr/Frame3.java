package tr;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
public class Frame3 extends JFrame {
    JPanel contentPane;
    JButton jButton1 = new JButton();
    JButton jButton2 = new JButton();
    JLabel jLabel1 = new JLabel();
    JButton jButton3 = new JButton();
    public Frame3() {
        try {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Component initialization.
     *
     * @throws java.lang.Exception
     */
    private void jbInit() throws Exception {
        contentPane = (JPanel) getContentPane();
        contentPane.setLayout(null);
        setSize(new Dimension(400, 300));
        setTitle("Frame Title");
        jButton1.setBounds(new Rectangle(239, 46, 75, 23));
        jButton1.setText("start");
        jButton1.addActionListener(new Frame3_jButton1_actionAdapter(this));
        jButton2.setBounds(new Rectangle(245, 112, 75, 23));
        jButton2.setText("jButton2");
        jButton2.addActionListener(new Frame3_jButton2_actionAdapter(this));
        jLabel1.setText("jLabel1");
        jLabel1.setBounds(new Rectangle(84, 176, 213, 14));
        jButton3.setBounds(new Rectangle(83, 48, 75, 23));
        jButton3.setText("jButton3");
        jButton3.addActionListener(new Frame3_jButton3_actionAdapter(this));
        contentPane.add(jButton1);
        contentPane.add(jButton2);
        contentPane.add(jLabel1);
        contentPane.add(jButton3);
    }

    public void jButton1_actionPerformed(ActionEvent e) {
        Untitled2 un=new Untitled2(this);
    Untitled2.toDestroy=!Untitled2.toDestroy;
        un.setPriority(Thread.NORM_PRIORITY);
    un.start();
    }

    public void jButton2_actionPerformed(ActionEvent e) {
       Untitled2.toPause=!Untitled2.toPause;


    }

    public void jButton3_actionPerformed(ActionEvent e) {
Untitled2.toDestroy=!Untitled2.toDestroy;
    }
}


class Frame3_jButton3_actionAdapter implements ActionListener {
    private Frame3 adaptee;
    Frame3_jButton3_actionAdapter(Frame3 adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButton3_actionPerformed(e);
    }
}


class Frame3_jButton2_actionAdapter implements ActionListener {
    private Frame3 adaptee;
    Frame3_jButton2_actionAdapter(Frame3 adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButton2_actionPerformed(e);
    }
}


class Frame3_jButton1_actionAdapter implements ActionListener {
    private Frame3 adaptee;
    Frame3_jButton1_actionAdapter(Frame3 adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButton1_actionPerformed(e);
    }
}
