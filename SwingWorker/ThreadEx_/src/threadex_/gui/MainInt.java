package threadex_.gui;

import java.awt.*;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.lang.reflect.*;
import java.beans.*;
import java.util.List;

public class MainInt extends JFrame {
    JPanel contentPane;
    JButton StartDialogBut = new JButton();
    JButton StartMonitorBut = new JButton();
    GridBagLayout gridBagLayout1 = new GridBagLayout();
    JButton StartSwingWorker = new JButton();

    public MainInt() {
        try {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            jbInit();
            /*Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener(){
                public void eventDispatched(AWTEvent event) {
                    System.out.println(event);
                }
           }, Long.MAX_VALUE);*/
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
        setTitle("Threads and GUI");
        StartDialogBut.setText("Прогресс диалог");
        StartDialogBut.addActionListener(new MainInt_StartBut_actionAdapter(this));
        StartMonitorBut.setText("Прогресс монитор");
        StartMonitorBut.addActionListener(new
                                          MainInt_StartMonitorBut_actionAdapter(this));
        StartSwingWorker.setText("СвингВоркер (JRE 1.6)");
        StartSwingWorker.addActionListener(new
                MainInt_StartSwingWorker_actionAdapter(this));
        contentPane.add(StartMonitorBut,
                        new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
                                               , GridBagConstraints.CENTER,
                                               GridBagConstraints.HORIZONTAL,
                                               new Insets(5, 5, 5, 5), 0, 0));
        contentPane.add(StartDialogBut,
                        new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
                                               , GridBagConstraints.CENTER,
                                               GridBagConstraints.HORIZONTAL,
                                               new Insets(5, 5, 5, 5), 0, 0));
        contentPane.add(StartSwingWorker, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(5, 5, 5, 5), 0, 0));
    }

    public void startProgressDialog(ActionEvent e) {
        final ProgressDialog diag = new ProgressDialog(this);
        Thread t = new Thread(){
            public void run(){
                for (int i=0; i<=100; i++){
                    try {
                        final int val = i;
                        //SwingUtilities.invokeAndWait(new Runnable() {//Вызывает модификацию интерфейса из ЕДТ и ждет выполнения события
                        SwingUtilities.invokeLater(new Runnable() {//Вызывает модификацию интерфейса из ЕДТ
                            public void run() {
                                diag.setProgress(val);
                                diag.setString(val+"%");
                            }
                        });
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    System.out.println(i);
                    try {
                        //Thread.sleep(50);
                        for (long l = 0; l<10000000; l++){}
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        };
        t.setPriority(Thread.NORM_PRIORITY);//Приоритет НУЖНО ставить ОБЯЗАТЕЛЬНО
        t.start();
        diag.setVisible(true);
    }

    public void startMonitorDialog(ActionEvent e) {
        final ProgressMonitor mon = new ProgressMonitor(this, "Подождите", "", 0, 100);
        mon.setMillisToDecideToPopup(100);//Задержка перед всплытием
        mon.setMillisToPopup(2000);//Если время выполнения процесса (предполагаемое) больше чем указанное, то диалог всплывет
        Thread t = new Thread(){
            public void run(){
                for (int i=0; i<=100&&!mon.isCanceled(); i++){
                    mon.setProgress(i);
                    if (i%10==0) mon.setNote(i+"%");
                    try {
                        //Thread.sleep(50);
                        for (long l = 0; l<10000000; l++){}
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                System.out.println("Process finished");
            }
        };
        t.setPriority(Thread.NORM_PRIORITY);//Приоритет НУЖНО ставить ОБЯЗАТЕЛЬНО
        t.start();
    }

    public void startSwingWorker(ActionEvent e) {
        final ProgressDialog diag = new ProgressDialog(this);
        SwingWorker<Void, String> sw = new SwingWorker<Void, String>(){//Класс для взаимодействия с интерфейсом

            protected Void doInBackground() throws Exception {
                for (int i=0; i<=99; i++){
                     setProgress(i);
                     //System.out.println(Thread.currentThread()+", progress="+i);
                     if (i%10==0) publish(i+"%");
                     try {
                         for (long l = 0; l<10000000; l++){}
                     } catch (Exception ex) {
                         ex.printStackTrace();
                     }
                 }
                 return null;
            }

            protected void done() {
                System.out.println("Process finished");
                diag.dispose();
            }

            protected void process(List<String> chunks) {
                String mess = chunks.get(chunks.size()-1);
                diag.setString(mess);
            }

        };
        sw.addPropertyChangeListener(new PropertyChangeListener(){
            public void propertyChange(PropertyChangeEvent e) {
                System.out.println(e.getPropertyName()+"="+e.getNewValue());
                if (e.getPropertyName().equals("progress")){
                    int val = (Integer)e.getNewValue();
                    //System.out.println("\t"+Thread.currentThread()+", progress="+val);
                    diag.setProgress(val);
                }
            }
        });
        sw.execute();
        diag.setVisible(true);
    }
}


class MainInt_StartSwingWorker_actionAdapter implements ActionListener {
    private MainInt adaptee;
    MainInt_StartSwingWorker_actionAdapter(MainInt adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.startSwingWorker(e);
    }
}


class MainInt_StartBut_actionAdapter implements ActionListener {
    private MainInt adaptee;
    MainInt_StartBut_actionAdapter(MainInt adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.startProgressDialog(e);
    }
}


class MainInt_StartMonitorBut_actionAdapter implements ActionListener {
    private MainInt adaptee;
    MainInt_StartMonitorBut_actionAdapter(MainInt adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.startMonitorDialog(e);
    }
}
