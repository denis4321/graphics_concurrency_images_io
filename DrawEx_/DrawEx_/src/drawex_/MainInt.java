package drawex_;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.*;
import javax.swing.JSlider;
import javax.swing.BorderFactory;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

public class MainInt extends JFrame {
    JPanel contentPane;
    GridBagLayout gridBagLayout1 = new GridBagLayout();
    DrawPanel Draw = new DrawPanel();
    JSlider DrawSlider = new JSlider();
    JButton RepaintBut = new JButton();
    public MainInt() {
        try {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            jbInit();
            DrawSlider.setSnapToTicks(true);//���������� ������� ������������ ����� �� ���
            //������� ����� �������
            Hashtable<Integer, Component> labs = new Hashtable<Integer, Component>();
            for (int x=DrawSlider.getMinimum(); x<=DrawSlider.getMaximum(); x+=DrawSlider.getMinorTickSpacing()){
                JLabel lab = new JLabel(Integer.toString(x));
                lab.setFont(new Font("SansSerif",Font.PLAIN, x%DrawSlider.getMajorTickSpacing()==0 ? 12 : 10));
                labs.put(x, lab);
            }
            DrawSlider.setLabelTable(labs);
            DrawSlider.addChangeListener(new ChangeListener(){

                public void stateChanged(ChangeEvent e) {
                    if (!DrawSlider.getValueIsAdjusting()){
                        doRepaint();
                    }
                }
            });
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
        setTitle("Draw example");
        Draw.setBorder(BorderFactory.createLineBorder(Color.black));
        RepaintBut.setText("Repaint");
        RepaintBut.addActionListener(new MainInt_RepaintBut_actionAdapter(this));
        DrawSlider.setMajorTickSpacing(10);
        DrawSlider.setMinimum(10);
        DrawSlider.setMinorTickSpacing(5);
        DrawSlider.setPaintLabels(true);
        DrawSlider.setPaintTicks(true);
        contentPane.add(DrawSlider, new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(5, 5, 5, 5), 0, 0));
        contentPane.add(Draw, new GridBagConstraints(0, 0, 3, 1, 1.0, 1.0
                , GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(5, 5, 5, 5), 0, 0));
        contentPane.add(RepaintBut, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(5, 5, 5, 5), 0, 0));
    }

    public void doRepaint() {
        int val = DrawSlider.getValue();
        Draw.setPos(val, val);
        Draw.repaint();
    }
}


class MainInt_RepaintBut_actionAdapter implements ActionListener {
    private MainInt adaptee;
    MainInt_RepaintBut_actionAdapter(MainInt adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.doRepaint();
    }
}
