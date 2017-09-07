package EnumsAndDrawing;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;

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
    GridBagLayout gridBagLayout1 = new GridBagLayout();
    JButton jButton1 = new JButton();
    JComboBox jComboBox1 = new JComboBox();
    ForDrawingClass forDrawingClass1 = new ForDrawingClass();
    JButton jButton2 = new JButton();
    public Frame1() {
        try {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            jbInit();
            jComboBox1.addItem("Прямая");
            jComboBox1.addItem("Парабола");
            jComboBox1.addItem("Другая прямая");

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
        jButton1.setText("start");
        jButton1.addActionListener(new Frame1_jButton1_actionAdapter(this));
        jButton2.setText("stop");
        jButton2.addActionListener(new Frame1_jButton2_actionAdapter(this));
        contentPane.add(jComboBox1, new GridBagConstraints(1, 1, 2, 1, 0.5, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(5, 5, 5, 5), 0, 0));
        contentPane.add(forDrawingClass1,
                        new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0
                                               , GridBagConstraints.SOUTH,
                                               GridBagConstraints.BOTH,
                                               new Insets(0, 0, 0, 0), 0, 0));
        contentPane.add(jButton1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.EAST, GridBagConstraints.NONE,
                new Insets(7, 7, 7, 7), 0, 0));
        contentPane.add(jButton2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE,
                new Insets(7, 7, 7, 7), 0, 0));
    }

    public void jButton1_actionPerformed(ActionEvent e) {
        int index = jComboBox1.getSelectedIndex();
       // if (this.jCheckBox1.isSelected()){
            Thread t = new Thread(forDrawingClass1);
            t.setPriority(3);
            switch (index) {
            case (0):
                forDrawingClass1.setEnum(ForEnumsClass.LINE);
                break;
            case (1):
                forDrawingClass1.setEnum(ForEnumsClass.PARAB);
                break;
            case (2):
                forDrawingClass1.setEnum(ForEnumsClass.CUBE);
                break;
            }
            t.start();
            for (ForEnumsClass p : ForEnumsClass.values()) {
            System.out.println(p.getFunctionTitle());
        }
        try {
           t.join();
             System.out.println("5555555555555555555555555555555555");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void ddd(Thread t){
        try {
            t.join(120);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


    public void jButton2_actionPerformed(ActionEvent actionEvent) {

    }


class Frame1_jButton2_actionAdapter implements ActionListener {
    private Frame1 adaptee;
    Frame1_jButton2_actionAdapter(Frame1 adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        adaptee.jButton2_actionPerformed(actionEvent);
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
}}
