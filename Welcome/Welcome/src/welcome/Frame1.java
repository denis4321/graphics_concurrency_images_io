package welcome;

import java.awt.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
public class Frame1
    extends JFrame {
  JPanel contentPane;
  JComboBox jComboBox1 = new JComboBox();
  JButton jButton1 = new JButton();
  JComboBox jComboBox2 = new JComboBox();
  public Frame1() {
    try {
      jComboBox1.addItem("wwwwwwwww");
       jComboBox1.addItem("zzzzzzzzzz");
        jComboBox1.addItem("xxxxxxxxxx");
        jComboBox2.addItem("wwwwwwwww");
        jComboBox2.addItem("zzzzzzzzzz");
         jComboBox2.addItem("xxxxxxxxxx");



      setDefaultCloseOperation(EXIT_ON_CLOSE);
      jbInit();
    }
    catch (Exception exception) {
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
    jComboBox1.setBounds(new Rectangle(67, 70, 228, 23));
    jButton1.setBounds(new Rectangle(127, 178, 75, 23));
    jButton1.setText("jButton1");
    jButton1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton1_actionPerformed(e);
      }
    });
    jComboBox2.setBounds(new Rectangle(67, 112, 226, 22));
    contentPane.add(jComboBox1);
    contentPane.add(jButton1);
    contentPane.add(jComboBox2);
  }

  public void jButton1_actionPerformed(ActionEvent e) {
   new P(this).g();
   //ne jButton1.setText(i+""+j);
  }
}
