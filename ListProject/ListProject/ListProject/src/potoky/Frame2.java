package potoky;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import java.awt.Rectangle;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import java.util.Random;
import java.awt.GridBagLayout;
import java.awt.*;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2009</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class Frame2 extends JFrame {
    Random rnd = new Random();
    JPanel contentPane;
    JButton jButton1 = new JButton();
    JProgressBar jProgressBar1 = new JProgressBar();
    JProgressBar jProgressBar2 = new JProgressBar();
    JProgressBar jProgressBar3 = new JProgressBar();
    JProgressBar jProgressBar4 = new JProgressBar();
    JProgressBar jProgressBar5 = new JProgressBar();
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JLabel jLabel3 = new JLabel();
    JLabel jLabel4 = new JLabel();
    JLabel jLabel5 = new JLabel();
    GridBagLayout gridBagLayout1 = new GridBagLayout();
    public Frame2() {

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
        contentPane.setLayout(gridBagLayout1);
        setSize(new Dimension(400, 300));
        setTitle("Frame Title");
        jButton1.setText("jButton1");
        jButton1.addActionListener(new Frame2_jButton1_actionAdapter(this));
        jProgressBar1.setMaximum(10000);
        jProgressBar1.setStringPainted(true);
        jProgressBar2.setMaximum(10000);
        jProgressBar2.setStringPainted(true);
        jProgressBar3.setMaximum(10000);
        jProgressBar3.setStringPainted(true);
        jProgressBar4.setMaximum(10000);
        jProgressBar4.setStringPainted(true);
        jProgressBar5.setMaximum(10000);
        jProgressBar5.setStringPainted(true);
        contentPane.add(jLabel1, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(7, 7, 7, 7), 0, 0));
        contentPane.add(jLabel2, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(7, 7, 7, 7), 0, 0));
        contentPane.add(jLabel3, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(7, 7, 7, 7), 0, 0));
        contentPane.add(jLabel4, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(7, 7, 7, 7), 0, 0));
        contentPane.add(jLabel5, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(7, 7, 7, 7), 0, 0));
        contentPane.add(jProgressBar1,
                        new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
                                               , GridBagConstraints.CENTER,
                                               GridBagConstraints.HORIZONTAL,
                                               new Insets(5, 5, 5, 5), 0, 0));
        contentPane.add(jProgressBar2,
                        new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
                                               , GridBagConstraints.CENTER,
                                               GridBagConstraints.HORIZONTAL,
                                               new Insets(5, 5, 5, 5), 0, 0));
        contentPane.add(jProgressBar3,
                        new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0
                                               , GridBagConstraints.CENTER,
                                               GridBagConstraints.HORIZONTAL,
                                               new Insets(5, 5, 5, 5), 0, 0));
        contentPane.add(jProgressBar4,
                        new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0
                                               , GridBagConstraints.CENTER,
                                               GridBagConstraints.HORIZONTAL,
                                               new Insets(5, 5, 5, 5), 0, 0));
        contentPane.add(jProgressBar5,
                        new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0
                                               , GridBagConstraints.CENTER,
                                               GridBagConstraints.HORIZONTAL,
                                               new Insets(5, 5, 5, 5), 0, 0));
        contentPane.add(jButton1, new GridBagConstraints(0, 0, 2, 1, 1.0, 0.0
                , GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                new Insets(6, 6, 20, 6), 0, 0));
    }

    public void jButton1_actionPerformed(ActionEvent e) {
        this.jButton1.setEnabled(false);
        for (int i=0;i<5;i++){
            Engine en =new Engine("THREAD # "+i,this);
            int k=rnd.nextInt(2);
            en.setPriority(Thread.NORM_PRIORITY-k);
            //new Animation(en).start();
            en.start();

        }

    }
}


class Frame2_jButton1_actionAdapter implements ActionListener {
    private Frame2 adaptee;
    Frame2_jButton1_actionAdapter(Frame2 adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButton1_actionPerformed(e);
    }
}
