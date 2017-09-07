package io_example_;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.*;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;
import javax.swing.event.*;
import java.text.*;
import java.io.*;
import java.io.*;

public class MainInt extends JFrame {
    JPanel contentPane;
    GridBagLayout gridBagLayout1 = new GridBagLayout();
    JScrollPane jScrollPane1 = new JScrollPane();
    JList MyList = new JList();
    JButton AddBut = new JButton();
    JButton RemoveBut = new JButton();
    MyListModel model = new MyListModel();
    JButton LoadBut = new JButton();
    JButton SaveBut = new JButton();
    /*java.util.Timer timer = new java.util.Timer(true);
    TimerTask tt = null;*/

    public MainInt() {
        try {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            jbInit();
            MyList.setModel(model);
            MyList.setCellRenderer(new DefaultListCellRenderer(){
                DateFormat format = new SimpleDateFormat("'created' HH:mm:ss.SSS");

                public Component getListCellRendererComponent(JList list,
                        Object value, int index, boolean isSelected,
                        boolean cellHasFocus) {
                    Element elem = (Element)value;
                    JLabel lab = (JLabel) super.getListCellRendererComponent(list, elem.getName()+" "+format.format(new Date(elem.getTime())), index, isSelected, cellHasFocus);
                    if (!isSelected){
                        lab.setBackground(index%2==0 ? Color.white : Color.gray);
                        lab.setForeground(index%2==0 ? Color.black : Color.white);
                    }
                    return lab;
                }
            });
            MyList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        AddBut.setFont(new java.awt.Font("Tahoma", Font.BOLD, 11));
        AddBut.setForeground(Color.blue);
        AddBut.setText("��������");
        AddBut.addActionListener(new MainInt_AddBut_actionAdapter(this));
        RemoveBut.setFont(new java.awt.Font("Tahoma", Font.BOLD, 11));
        RemoveBut.setForeground(Color.red);
        RemoveBut.setText("�������");
        RemoveBut.addActionListener(new MainInt_RemoveBut_actionAdapter(this));
        LoadBut.setFont(new java.awt.Font("Tahoma", Font.BOLD, 11));
        LoadBut.setText("���������");
        LoadBut.addActionListener(new MainInt_LoadBut_actionAdapter(this));
        SaveBut.setFont(new java.awt.Font("Tahoma", Font.BOLD, 11));
        SaveBut.setText("���������");
        SaveBut.addActionListener(new MainInt_SaveBut_actionAdapter(this));
        jScrollPane1.getViewport().add(MyList);
        contentPane.add(jScrollPane1,
                        new GridBagConstraints(0, 0, 4, 1, 1.0, 1.0
                                               , GridBagConstraints.CENTER,
                                               GridBagConstraints.BOTH,
                                               new Insets(5, 5, 0, 5), 0, 0));
        contentPane.add(AddBut, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE,
                new Insets(5, 5, 5, 5), 0, 0));
        contentPane.add(SaveBut, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(5, 5, 5, 5), 0, 0));
        contentPane.add(LoadBut, new GridBagConstraints(2, 1, 1, 1, 1.0, 0.0
                , GridBagConstraints.EAST, GridBagConstraints.NONE,
                new Insets(5, 5, 5, 0), 0, 0));
        contentPane.add(RemoveBut, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE,
                new Insets(5, 0, 5, 0), 0, 0));
    }

    public void addElement() {
        model.addElement(new Element("������� "));
    }

    public void removeElement() {
        int index = MyList.getSelectedIndex();
        if (index>=0){
            model.removeElement(index);
            if (index<model.getSize()){
                MyList.setSelectedIndex(index);
            }
        }
    }

    public void save() {
        try {
            String result = (String)JOptionPane.showInputDialog(this, "�������� ��� ����������", "����������", JOptionPane.QUESTION_MESSAGE, null, new String[]{"Data", "Serialize", "Properties"}, null);
            //System.out.println(result);
            if ("Data".equals(result)){
                model.save1();
            } else
            if ("Serialize".equals(result)){
                model.save3();
            } else
            if ("Properties".equals(result)){
                model.save4();
            } else throw new IllegalArgumentException("Invalid save type");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void load() {
        try {
            FileInputStream in = new FileInputStream(MyListModel.DATA);
            int version = in.read();
            switch (version){
            case '1':
                //���������
                model.load1(in);
                break;
            case '2':
                //������������
                model = MyListModel.load3(in);
                MyList.setModel(model);
                break;
            case '3':
                model.load4(in);
                break;
            default:
                throw new IllegalArgumentException("Invalid file version");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}


class MainInt_LoadBut_actionAdapter implements ActionListener {
    private MainInt adaptee;
    MainInt_LoadBut_actionAdapter(MainInt adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.load();
    }
}


class MainInt_SaveBut_actionAdapter implements ActionListener {
    private MainInt adaptee;
    MainInt_SaveBut_actionAdapter(MainInt adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.save();
    }
}


class MainInt_RemoveBut_actionAdapter implements ActionListener {
    private MainInt adaptee;
    MainInt_RemoveBut_actionAdapter(MainInt adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.removeElement();
    }
}


class MainInt_AddBut_actionAdapter implements ActionListener {
    private MainInt adaptee;
    MainInt_AddBut_actionAdapter(MainInt adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.addElement();
    }
}
