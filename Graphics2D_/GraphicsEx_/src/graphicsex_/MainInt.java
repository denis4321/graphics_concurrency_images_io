package graphicsex_;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import javax.swing.Timer;

public class MainInt extends JFrame {
    JPanel contentPane;
    DrawPanel Draw = new DrawPanel();
    JButton IncXBut = new JButton();
    GridBagLayout gridBagLayout1 = new GridBagLayout();

    public MainInt() {
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
        this.addWindowListener(new MainInt_this_windowAdapter(this));
        IncXBut.setText("��������� �");
        IncXBut.addActionListener(new MainInt_IncXBut_actionAdapter(this));
        contentPane.add(Draw, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0
                , GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 390, 267));
        contentPane.add(IncXBut, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 303, 0));
    }

    public void IncXBut_actionPerformed(ActionEvent e) {
        Draw.incx();
    }

    public void this_windowOpened(WindowEvent e) {
        //������ ������������ �������
        /*Timer t = new Timer(100, new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Draw.incPos();
            }
        });
        t.start();*/
    }
}


class MainInt_this_windowAdapter extends WindowAdapter {
    private MainInt adaptee;
    MainInt_this_windowAdapter(MainInt adaptee) {
        this.adaptee = adaptee;
    }

    public void windowOpened(WindowEvent e) {
        adaptee.this_windowOpened(e);
    }
}


class MainInt_IncXBut_actionAdapter implements ActionListener {
    private MainInt adaptee;
    MainInt_IncXBut_actionAdapter(MainInt adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.IncXBut_actionPerformed(e);
    }
}
