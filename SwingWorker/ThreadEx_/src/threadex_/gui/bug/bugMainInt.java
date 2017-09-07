package threadex_.gui.bug;

import java.awt.*;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.*;

public class bugMainInt extends JFrame {
    JPanel contentPane;
    BorderLayout borderLayout1 = new BorderLayout();
    JButton StartBut = new JButton();
    JScrollPane jScrollPane1 = new JScrollPane();
    JList DataList = new JList();
    DefaultListModel model = new DefaultListModel();

    public bugMainInt() {
        try {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            jbInit();
            DataList.setModel(model);
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
        contentPane.setLayout(borderLayout1);
        setSize(new Dimension(400, 300));
        setTitle("Вызывает баг из-за параллеьного изменения данных");
        StartBut.setText("Старт");
        StartBut.addActionListener(new bugMainInt_StartBut_actionAdapter(this));
        contentPane.add(StartBut, java.awt.BorderLayout.SOUTH);
        contentPane.add(jScrollPane1, java.awt.BorderLayout.CENTER);
        jScrollPane1.getViewport().add(DataList);
    }

    public void startThreadBug(ActionEvent e) {
        Thread t = new Thread(){
            public void run(){
                int i = 0;
                while (true) {
                    final String val = "Element #"+i;
                    //model.add(0, val);//bug
                    try {
                        SwingUtilities.invokeAndWait(new Runnable() { //Correct
                            public void run() {
                                model.add(0, val);
                            }
                        });
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    i++;
                }
            }
        };
        t.setPriority(Thread.NORM_PRIORITY-2);
        t.start();
    }
}


class bugMainInt_StartBut_actionAdapter implements ActionListener {
    private bugMainInt adaptee;
    bugMainInt_StartBut_actionAdapter(bugMainInt adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.startThreadBug(e);
    }
}
