package listproject;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import com.sun.org.apache.xerces.internal.xs.StringList;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.GridBagLayout;
import java.awt.*;
import com.borland.jbcl.layout.XYLayout;
import com.borland.jbcl.layout.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Random;
import java.util.Vector;
import javax.swing.ListCellRenderer;
import javax.swing.Icon;
import javax.swing.ListModel;
import javax.swing.JOptionPane;
import javax.swing.DefaultListCellRenderer;
import javax.swing.border.TitledBorder;
import java.io.File;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.*;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.Box;
import javax.swing.BorderFactory;
import java.awt.Color;
import javax.swing.DebugGraphics;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

//import com.sun.org.apache.xerces.internal.impl.xpath.regex.Op;

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
public class Frame1 extends JFrame {
    DataModelClass model = new DataModelClass();
    JPanel contentPane;
    JButton jButton1 = new JButton();
    JButton jButton2 = new JButton();
    JButton jButton3 = new JButton();
    JList jList1 = new JList();
    JTextField jTextField1 = new JTextField();
    JTextField jTextField2 = new JTextField();
    JScrollPane jScrollPane1 = new JScrollPane();
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JLabel jLabel3 = new JLabel();
    JPanel jPanel1 = new JPanel();
    JTextField jTextField3 = new JTextField();
    GridBagLayout gridBagLayout1 = new GridBagLayout();
    GridBagLayout gridBagLayout2 = new GridBagLayout();
    private Random rnd = new Random();
    TitledBorder titledBorder1 = new TitledBorder("");
    JButton saveButton = new JButton();
    JButton loadButton = new JButton();
    ButtonGroup buttonGroup1 = new ButtonGroup();
    JRadioButton jRadioButton1 = new JRadioButton();
    JRadioButton jRadioButton2 = new JRadioButton();
    JRadioButton jRadioButton3 = new JRadioButton();
    JPanel jPanel2 = new JPanel();
    GridBagLayout gridBagLayout3 = new GridBagLayout();
    Box hbox1 = Box.createHorizontalBox();
    TitledBorder titledBorder2 = new TitledBorder("");
    TitledBorder titledBorder3 = new TitledBorder("");
    Border border1 = BorderFactory.createLineBorder(Color.blue, 2);
    Border border2 = new TitledBorder(border1, "Выберите способ сохранения");
    JRadioButton jRadioButton4 = new JRadioButton();
    JPanel jPanel3 = new JPanel();


    public Frame1() {
        try {
            //buttonGroup1.
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            jbInit();
            jList1.setModel(model);
            jList1.setCellRenderer(new DefaultListCellRenderer() {
                private Vector imageIconList = new Vector();

                {
                    for (int i = 0; i < 8; i++) {
                        imageIconList.add(new ImageIcon(i + ".gif"));
                    }

                }

                public Component getListCellRendererComponent(JList list,
                        Object value, int index, boolean isSelected,
                        boolean cellHasFocus) {
                    Person p = (Person)value;
                    JLabel lab = (JLabel)super.getListCellRendererComponent(list, p.getName()+" "+p.getPatronymic()+" "+p.getSurname(), index, isSelected, cellHasFocus);
                    lab.setIcon((Icon) imageIconList.get(p.getIcon()));
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
        titledBorder1 = new TitledBorder(BorderFactory.createLineBorder(
                SystemColor.windowBorder, 2), "Данные");
        contentPane = (JPanel) getContentPane();
        contentPane.setLayout(gridBagLayout2);
        setSize(new Dimension(531, 482));
        setTitle("Frame Title");
        for (int i=0;i<8;i++){
            Person p = new Person();
            p.setName("Василий");
            p.setSurname("Пупкин");
            p.setPatronymic("Василиевич");
            p.setIcon(i);
            model.addData(p);
        }
        jButton1.setForeground(Color.red);
        jButton1.setText("Удалить все");
        jButton1.addActionListener(new Frame1_jButton1_actionAdapter(this));
        jButton2.setFont(new java.awt.Font("Times New Roman",
                                           Font.BOLD | Font.ITALIC, 20));
        jButton2.setText("Удалить выбранный");
        jButton2.addActionListener(new Frame1_jButton2_actionAdapter(this));
        jButton3.setFont(new java.awt.Font("Book Antiqua", Font.BOLD, 20));
        jButton3.setText("Добавить");
        jButton3.addActionListener(new Frame1_jButton3_actionAdapter(this));
        jLabel1.setText("ИМЯ");
        jLabel2.setText("ФАМИЛИЯ");
        jLabel3.setText("ГОД РОЖДЕНИЯ");
        jPanel1.setLayout(gridBagLayout1);
        jPanel1.setBorder(titledBorder1);
        saveButton.setText("save");
        saveButton.addActionListener(new Frame1_saveButton_actionAdapter(this));
        loadButton.setText("LOAD");
        loadButton.addActionListener(new Frame1_loadButton_actionAdapter(this));
        jRadioButton1.setBackground(Color.white);
        jRadioButton1.setSelected(false);
        jRadioButton1.setText("DataOutputStream");
        jRadioButton2.setBackground(Color.white);
        jRadioButton2.setText("Serializable по 1 объекту");
        jRadioButton3.setBackground(Color.white);
        jRadioButton3.setSelected(false);
        jRadioButton3.setText("Serializable целиком");
        jPanel2.setLayout(gridBagLayout3);
        contentPane.setBorder(null);
        jPanel2.setBackground(Color.blue);
        jPanel2.setBorder(border2);
        jPanel2.setDebugGraphicsOptions(0);
        jRadioButton4.setBackground(Color.white);
        jRadioButton4.setSelected(true);
        jRadioButton4.setText("PROPERTIES");
        jPanel1.add(jLabel1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE,
                new Insets(5, 5, 5, 5), 0, 0));
        jPanel1.add(jLabel2, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE,
                new Insets(5, 5, 5, 5), 0, 0));
        jPanel1.add(jTextField2, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(5, 5, 5, 5), 0, 0));
        jPanel1.add(jLabel3, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE,
                new Insets(5, 5, 5, 5), 0, 0));
        jPanel1.add(jTextField3, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(5, 5, 5, 5), 0, 0));
        jPanel1.add(jTextField1, new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0
                , GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(5, 5, 5, 5), 0, 0));
        buttonGroup1.add(jRadioButton1);
        jScrollPane1.getViewport().add(jList1);
        buttonGroup1.add(jRadioButton2);
        buttonGroup1.add(jRadioButton3);
        buttonGroup1.add(jRadioButton4);
        jPanel2.add(jRadioButton3, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(5, 5, 5, 5), 0, 0));
        jPanel2.add(jRadioButton2, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(5, 5, 5, 5), 0, 0));
        jPanel2.add(jRadioButton1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(5, 5, 5, 5), 0, 0));
        jPanel2.add(jRadioButton4, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.SOUTH, GridBagConstraints.BOTH,
                new Insets(5, 5, 5, 5), 0, 0));
        contentPane.add(hbox1, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));
        contentPane.add(jButton3, new GridBagConstraints(2, 0, 2, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(5, 5, 5, 5), 0, 0));
        contentPane.add(jButton2, new GridBagConstraints(2, 1, 2, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(5, 5, 5, 5), 0, 0));
        contentPane.add(jButton1, new GridBagConstraints(2, 2, 2, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(5, 5, 5, 5), 0, 4));
        contentPane.add(jPanel1, new GridBagConstraints(2, 3, 2, 1, 0.0, 0.0
                , GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(5, 5, 0, 5), 0, 0));
        contentPane.add(jScrollPane1,
                        new GridBagConstraints(1, 0, 1, 6, 1.0, 1.0
                                               , GridBagConstraints.CENTER,
                                               GridBagConstraints.BOTH,
                                               new Insets(0, 0, 10, 9), 0, 0));
        contentPane.add(jPanel2, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        contentPane.add(jPanel3, new GridBagConstraints(3, 4, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));
        jPanel3.add(saveButton);
        jPanel3.add(loadButton);
    }




    public void jButton3_actionPerformed(ActionEvent e) {
        try{
            String name = jTextField1.getText().trim();
            if (name.length()==0) throw new IllegalArgumentException("Введите имя!");
            String surname = jTextField2.getText().trim();
            if (surname.length()==0) throw new IllegalArgumentException("Введите фамилию!");
            String patname = jTextField3.getText().trim();
            if (patname.length()==0) throw new IllegalArgumentException("Введите отчество!");
            Person p = new Person();
            p.setName(name);
            p.setSurname(surname);
            p.setPatronymic(patname);
            p.setIcon(rnd.nextInt(8));
            model.addData(p);
        } catch (Exception ex){
            JOptionPane.showMessageDialog(this, ex.getMessage(),"ОШИБКА",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void jButton2_actionPerformed(ActionEvent e) {
       int selected = jList1.getSelectedIndex();
       if (selected!=-1) {
          model.delSelectedData(selected);
       }
       if (selected<model.getSize()) jList1.setSelectedIndex(selected);

    }

       public void jButton1_actionPerformed(ActionEvent e) {
           model.delAllData();
       }

       public void saveButton_actionPerformed(ActionEvent e) {
           try {
               if (jRadioButton1.isSelected()){ model.save1(); this.setTitle("data");}
               else if (jRadioButton2.isSelected()) {model.save2(); this.setTitle("serial 1 by 1");}
               else if (jRadioButton3.isSelected()) {model.save3();  this.setTitle("serial all");}
               else if (jRadioButton4.isSelected()){model.save4();this.setTitle("PROPERTIES");}
               else throw new IllegalArgumentException("Invalid save type");
           } catch (FileNotFoundException ex) {
           } catch (IOException ex) {
           }
       }

       public void loadButton_actionPerformed(ActionEvent e)  {
           try {
               FileInputStream in=new FileInputStream(DataModelClass.DATA);
               int value=in.read();
               switch(value){
               case '1':
                   model.load1(in);
                   break;
               case '2':
                   model.load2(in);
                   break;
               case '3':
                   model=model.load3(in);
                   jList1.setModel(model);
                   break;
               case '4':
                   model.load4();
                   break;
               default:
                   throw new IllegalArgumentException("Invalid file version");
               }
                }
                catch (EOFException ex) {
                }

                catch (Exception ex) {
                    ex.printStackTrace();
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


class Frame1_loadButton_actionAdapter implements ActionListener {
    private Frame1 adaptee;
    Frame1_loadButton_actionAdapter(Frame1 adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.loadButton_actionPerformed(e);
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
