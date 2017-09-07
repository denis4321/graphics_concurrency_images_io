package threadex_.gui;

import java.awt.*;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class ProgressDialog extends JDialog {
    JPanel panel1 = new JPanel();
    JProgressBar Progress = new JProgressBar();
    GridBagLayout gridBagLayout1 = new GridBagLayout();

    public ProgressDialog(Frame owner) {
        super(owner, "��������...", true);
        try {
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            jbInit();
            //setUndecorated(true);//��������� ��������� ����
            pack();
            setLocationRelativeTo(owner);//������������� ���� �� ������ ������, ���� ���� - �� ������ ������
            //setLocationByPlatform(true);//��������� ���� ���������� �������
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public ProgressDialog() {
        this(new Frame());
    }

    private void jbInit() throws Exception {
        panel1.setLayout(gridBagLayout1);
        this.setResizable(false);
        Progress.setForeground(Color.red);
        Progress.setPreferredSize(new Dimension(250, 18));
        Progress.setString("");
        Progress.setStringPainted(true);
        getContentPane().add(panel1);
        panel1.add(Progress, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(10, 10, 10, 10), 0, 0));
    }

    public void setProgress(int val){
        //System.out.println("    "+val);
        Progress.setValue(val);//��������� ��������
        //Progress.setString(val+"%");//��������� ������
        //Progress.setIndeterminate(true);//��������������� ��������
        if (val>=100){
            dispose();
        }
    }

    public void setString(String str){
        Progress.setString(str);
    }
}
