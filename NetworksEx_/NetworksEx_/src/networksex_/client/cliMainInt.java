package networksex_.client;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.*;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import networksex_.common.Connection;
import java.io.IOException;
import java.net.Socket;
import java.net.InetAddress;
import networksex_.common.ConnectionListener;
import java.text.DateFormat;
import java.util.Date;

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
public class cliMainInt extends JFrame implements ConnectionListener{
    JPanel contentPane;
    GridBagLayout gridBagLayout1 = new GridBagLayout();
    JScrollPane jScrollPane1 = new JScrollPane();
    JTextField AddrField = new JTextField();
    JButton ConnectBut = new JButton();
    JTextField InputField = new JTextField();
    JButton DisconnectBut = new JButton();
    JButton SendBut = new JButton();
    JTextArea OutArea = new JTextArea();
    Connection conn = null;
    private DateFormat dateF = DateFormat.getTimeInstance(DateFormat.MEDIUM);

    public cliMainInt() {
        try {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            jbInit();
            AddrField.setText("127.0.0.1");
            setState(false);
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
        setTitle("Client");
        AddrField.setPreferredSize(new Dimension(100, 19));
        ConnectBut.setText("Соединить");
        ConnectBut.addActionListener(new cliMainInt_ConnectBut_actionAdapter(this));
        DisconnectBut.setText("Разорвать");
        DisconnectBut.addActionListener(new
                                        cliMainInt_DisconnectBut_actionAdapter(this));
        SendBut.setForeground(Color.blue);
        SendBut.setText(">>>");
        SendBut.addActionListener(new cliMainInt_SendBut_actionAdapter(this));
        OutArea.setBackground(Color.black);
        OutArea.setForeground(Color.cyan);
        OutArea.setEditable(false);
        contentPane.add(AddrField, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(5, 5, 5, 5), 0, 0));
        contentPane.add(ConnectBut, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE,
                new Insets(5, 5, 5, 5), 0, 0));
        contentPane.add(DisconnectBut, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE,
                new Insets(5, 5, 5, 5), 0, 0));
        contentPane.add(InputField,
                        new GridBagConstraints(0, 2, 4, 1, 1.0, 0.0
                                               , GridBagConstraints.CENTER,
                                               GridBagConstraints.HORIZONTAL,
                                               new Insets(5, 5, 5, 4), 0, 0));
        contentPane.add(jScrollPane1,
                        new GridBagConstraints(0, 1, 5, 1, 1.0, 1.0
                                               , GridBagConstraints.CENTER,
                                               GridBagConstraints.BOTH,
                                               new Insets(0, 5, 0, 5), 0, 0));
        jScrollPane1.getViewport().add(OutArea);
        contentPane.add(SendBut, new GridBagConstraints(4, 2, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(5, 5, 5, 5), 0, 0));
    }

    public void setState(boolean isConnected){
        AddrField.setEditable(!isConnected);
        ConnectBut.setEnabled(!isConnected);
        DisconnectBut.setEnabled(isConnected);
        InputField.setEditable(isConnected);
        SendBut.setEnabled(isConnected);
        if (isConnected){
            InputField.setText("");
            OutArea.setText("");
        }
    }

    public void connect(){
        try{
            InetAddress addr = null;
            Socket s = new Socket(AddrField.getText(), 3334);
            conn = new Connection(s, this);
            ConnectBut.setEnabled(false);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void disconnect() {
        if (conn!=null){
            DisconnectBut.setEnabled(false);
            conn.close();
        }
    }

    public void connectionCreated(Connection c) {
        setState(true);
    }

    public void connectionClosed(Connection c) {
        setState(false);
    }

    public void messageReceived(Connection c, String mess) {
        println(">>>"+mess);
    }

    public void connectionError(Connection c, Exception ex) {
        println("ERROR: "+ex);
        ex.printStackTrace();
    }

    public void println(String mess){
        OutArea.append(dateF.format(new Date())+" "+mess+"\n");
    }

    public void send() {
        if (conn!=null){
            String mess = InputField.getText().trim();
            if (mess.length()>0){
                println(mess);
                try{
                    conn.send(mess);
                    InputField.setText("");
                } catch (Exception ex){
                    connectionError(conn, ex);
                }
            }
        }
    }

}


class cliMainInt_SendBut_actionAdapter implements ActionListener {
    private cliMainInt adaptee;
    cliMainInt_SendBut_actionAdapter(cliMainInt adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.send();
    }
}


class cliMainInt_DisconnectBut_actionAdapter implements ActionListener {
    private cliMainInt adaptee;
    cliMainInt_DisconnectBut_actionAdapter(cliMainInt adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.disconnect();
    }
}


class cliMainInt_ConnectBut_actionAdapter implements ActionListener {
    private cliMainInt adaptee;
    cliMainInt_ConnectBut_actionAdapter(cliMainInt adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.connect();
    }
}
