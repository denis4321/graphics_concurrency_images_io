package tr;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.*;
import javax.swing.JScrollPane;
import java.awt.Rectangle;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;
import javax.swing.ListCellRenderer;
import javax.swing.DefaultListCellRenderer;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileInputStream;

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
    Random rnd = new Random();
    DataModelClass model = new DataModelClass();
    GridBagLayout gridBagLayout1 = new GridBagLayout();
    JLabel jLabel1 = new JLabel();
    JTextField jTextField1 = new JTextField();
    JLabel jLabel2 = new JLabel();
    JTextField jTextField2 = new JTextField();
    JLabel jLabel3 = new JLabel();
    JTextField jTextField3 = new JTextField();
    JPanel jPanel1 = new JPanel();
    ButtonGroup buttonGroup1 = new ButtonGroup();
    JRadioButton jRadioButton1 = new JRadioButton();
    JRadioButton jRadioButton2 = new JRadioButton();
    JRadioButton jRadioButton3 = new JRadioButton();
    JRadioButton jRadioButton4 = new JRadioButton();
    GridBagLayout gridBagLayout2 = new GridBagLayout();
    JPanel jPanel2 = new JPanel();
    GridBagLayout gridBagLayout3 = new GridBagLayout();
    JButton clearButton = new JButton();
    JButton saveButton = new JButton();
    JButton delButton = new JButton();
    JButton loadButton = new JButton();
    JButton addButton = new JButton();
    TitledBorder titledBorder1 = new TitledBorder("");
    JScrollPane jScrollPane1 = new JScrollPane();
    JList jList1 = new JList();
    public Frame1() {
        try {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            jbInit();
            jList1.setModel(model);
            jList1.setCellRenderer(new DefaultListCellRenderer(){
                JLabel lab=new JLabel();
                Vector imagesList = new Vector();
                {
                   for (int i=0;i<8;i++){
                       imagesList.add(new ImageIcon(i+".gif"));
                   }}
                public Component getListCellRendererComponent(JList list,
                        Object value, int index, boolean isSelected,
                        boolean cellHasFocus) {
                    Person p =(Person)value;
             lab=(JLabel) super.getListCellRendererComponent(list,p.getName()+" "+p.getPatronymic()+" "+p.getSurname(),index,isSelected,cellHasFocus);
             lab.setIcon((Icon)imagesList.get(p.getImage()));
             return lab;
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
        titledBorder1 = new TitledBorder(BorderFactory.createLineBorder(Color.
                black, 2), "��� ����������");
        contentPane = (JPanel) getContentPane();
        contentPane.setLayout(gridBagLayout1);
        setSize(new Dimension(490, 355));
        setTitle("Frame Title");
        jLabel1.setText("jLabel1");
        jTextField1.setText("jTextField1");
        jLabel2.setText("jLabel2");
        jTextField2.setText("jTextField2");
        jLabel3.setText("jLabel3");
        jTextField3.setText("jTextField3");
        jRadioButton1.setBackground(Color.black);
        jRadioButton1.setForeground(Color.red);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("jRadioButton1");
        jRadioButton2.setBackground(Color.black);
        jRadioButton2.setForeground(Color.red);
        jRadioButton2.setText("jRadioButton2");
        jRadioButton3.setBackground(Color.black);
        jRadioButton3.setForeground(Color.red);
        jRadioButton3.setText("jRadioButton3");
        jRadioButton4.setBackground(Color.black);
        jRadioButton4.setForeground(Color.red);
        jRadioButton4.setText("jRadioButton4");
        jPanel1.setLayout(gridBagLayout2);
        jPanel2.setLayout(gridBagLayout3);
        clearButton.setText("clear");
        clearButton.addActionListener(new Frame1_clearButton_actionAdapter(this));
        saveButton.setText("save");
        saveButton.addActionListener(new Frame1_saveButton_actionAdapter(this));
        delButton.setText("delSelected");
        delButton.addActionListener(new Frame1_delButton_actionAdapter(this));
        loadButton.setText("LOAD");
        loadButton.addActionListener(new Frame1_loadButton_actionAdapter(this));
        addButton.setText("AddButton");
        addButton.addActionListener(new Frame1_addButton_actionAdapter(this));
        jPanel1.setBackground(Color.red);
        jPanel1.setBorder(titledBorder1);
        jPanel1.add(jRadioButton1, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));
        jPanel1.add(jRadioButton3, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(5, 5, 5, 5), 0, 0));
        jPanel1.add(jRadioButton4, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(5, 5, 5, 5), 0, 0));
        jPanel1.add(jRadioButton2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(5, 5, 5, 5), 0, 0));
        jPanel2.add(addButton, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(5, 5, 5, 5), 0, 0));
        jPanel2.add(loadButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(0, 5, 0, 5), 0, 0));
        jPanel2.add(delButton, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(0, 5, 0, 5), 0, 0));
        jPanel2.add(saveButton, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(0, 5, 0, 5), 0, 0));
        jScrollPane1.getViewport().add(jList1);
        buttonGroup1.add(jRadioButton4);
        buttonGroup1.add(jRadioButton3);
        buttonGroup1.add(jRadioButton1);
        buttonGroup1.add(jRadioButton2);
        contentPane.add(jLabel1, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE,
                new Insets(5, 5, 0, 5), 0, 0));
        contentPane.add(jLabel2, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE,
                new Insets(5, 5, 0, 0), 0, 0));
        contentPane.add(jLabel3, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE,
                new Insets(5, 5, 0, 0), 0, 0));
        contentPane.add(jTextField3,
                        new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0
                                               , GridBagConstraints.CENTER,
                                               GridBagConstraints.HORIZONTAL,
                                               new Insets(0, 5, 5, 5), 0, 0));
        contentPane.add(jPanel1, new GridBagConstraints(1, 8, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.BOTH,
                new Insets(5, 5, 5, 5), 0, 0));
        contentPane.add(jTextField1,
                        new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0
                                               , GridBagConstraints.CENTER,
                                               GridBagConstraints.HORIZONTAL,
                                               new Insets(0, 5, 5, 5), 0, 0));
        contentPane.add(jTextField2,
                        new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0
                                               , GridBagConstraints.CENTER,
                                               GridBagConstraints.HORIZONTAL,
                                               new Insets(0, 5, 5, 5), 0, 0));
        jPanel2.add(clearButton, new GridBagConstraints(0, 2, 2, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(5, 5, 5, 5), 0, 0));
        contentPane.add(jPanel2, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                new Insets(6, 6, 6, 6), 0, 0));
        contentPane.add(jScrollPane1,
                        new GridBagConstraints(2, 0, 5, 9, 1.0, 1.0
                                               , GridBagConstraints.CENTER,
                                               GridBagConstraints.BOTH,
                                               new Insets(5, 5, 5, 5), 0, 0));
    }

    public void clearButton_actionPerformed(ActionEvent e) {
        model.delAllData();
    }

    public void delButton_actionPerformed(ActionEvent e) {
        int i=jList1.getSelectedIndex();
        if (i!=-1) model.delData(i);
        if (i<model.getSize()){

        }
    }

    public void addButton_actionPerformed(ActionEvent e) {
        Person p =new Person();
        p.setName(jTextField1.getText());
        p.setPatronymic(jTextField2.getText());
        p.setSurname(jTextField3.getText());
        p.setImage(rnd.nextInt(7));
        model.addData(p);
    }

    public void saveButton_actionPerformed(ActionEvent e) {
        try {
            if (jRadioButton1.isSelected()) model.save1();
             if (jRadioButton2.isSelected()) model.save2();
             if (jRadioButton3.isSelected()) model.save3();
           if (jRadioButton4.isSelected()) model.save4();
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
    }

    public void loadButton_actionPerformed(ActionEvent e) throws
            ClassNotFoundException {
        try {
            FileInputStream fIn = new FileInputStream(DataModelClass.DATA);
            int p = fIn.read();
            switch (p) {
            case '1':
                //{System.out.println(1);
                model.load1(fIn);
                //System.out.println(11);
                break;
            case '2':
                model.load2(fIn);
                break;
            case '3':
                model=model.load3(fIn);
                jList1.setModel(model);
                break;
            case '4':
                model.load4(fIn);
                break;

    }

    }
    catch (IOException ex2) {
    }
     //catch (FileNotFoundException ex) {
      //  }

  /*      try {
                model=model.load3();
                jList1.setModel(model);
            } catch (ClassNotFoundException ex1) {
            } catch (FileNotFoundException ex1) {
            } catch (IOException ex1) {
    */
        }
}


class Frame1_loadButton_actionAdapter implements ActionListener {
    private Frame1 adaptee;
    Frame1_loadButton_actionAdapter(Frame1 adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        try {
            adaptee.loadButton_actionPerformed(e);
        } catch (ClassNotFoundException ex) {
        }
    }
}


class Frame1_saveButton_actionAdapter implements ActionListener {
    private Frame1 adaptee;
    Frame1_saveButton_actionAdapter(Frame1 adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.saveButton_actionPerformed(e);
    }
}


class Frame1_addButton_actionAdapter implements ActionListener {
    private Frame1 adaptee;
    Frame1_addButton_actionAdapter(Frame1 adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.addButton_actionPerformed(e);
    }
}


class Frame1_delButton_actionAdapter implements ActionListener {
    private Frame1 adaptee;
    Frame1_delButton_actionAdapter(Frame1 adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.delButton_actionPerformed(e);
    }
}


class Frame1_clearButton_actionAdapter implements ActionListener {
    private Frame1 adaptee;
    Frame1_clearButton_actionAdapter(Frame1 adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.clearButton_actionPerformed(e);
    }
}
