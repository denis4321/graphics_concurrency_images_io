package udp_example_.tcp;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.*;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramPacket;
import java.net.SocketAddress;
import java.net.InetAddress;
import java.net.*;
import java.util.Enumeration;
import java.util.Collections;

public class MainInt extends JFrame {
    JPanel contentPane;
    GridBagLayout gridBagLayout1 = new GridBagLayout();
    JSplitPane MainSplit = new JSplitPane();
    JScrollPane jScrollPane1 = new JScrollPane();
    JTextArea OutArea = new JTextArea();
    JScrollPane jScrollPane2 = new JScrollPane();
    JList ClientsList = new JList();
    JButton PingBut = new JButton();
    public static final int PORT = 4444;

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
        setSize(new Dimension(500, 300));
        setTitle("UDP Pinger");
        this.addWindowListener(new MainInt_this_windowAdapter(this));
        OutArea.setBackground(Color.black);
        OutArea.setForeground(Color.green);
        OutArea.setEditable(false);
        PingBut.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
        PingBut.setForeground(Color.blue);
        PingBut.setText("Ping");
        PingBut.addActionListener(new MainInt_PingBut_actionAdapter(this));
        MainSplit.setOneTouchExpandable(true);
        MainSplit.add(jScrollPane1, JSplitPane.LEFT);
        MainSplit.add(jScrollPane2, JSplitPane.RIGHT);
        jScrollPane2.getViewport().add(ClientsList);
        jScrollPane1.getViewport().add(OutArea);
        contentPane.add(MainSplit, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0
                , GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(5, 5, 0, 5), 0, 0));
        contentPane.add(PingBut, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(5, 5, 5, 5), 0, 0));
        MainSplit.setDividerLocation(100);
    }

    public void windowOpened() {
        MainSplit.setDividerLocation(0.5);
        Thread t = new Thread(){
            public void run(){
                DatagramSocket sock = null;
                try{
                    DatagramPacket data = new DatagramPacket(new byte[100], 100);
                    sock = new DatagramSocket(PORT);
                    while (true){
                        sock.receive(data);
                        String info = new String(data.getData(), 0, data.getLength());
                        InetAddress addr = data.getAddress();
                        println(addr+": "+info);
                    }
                } catch (Exception ex){
                    ex.printStackTrace();
                    println(ex.toString());
                } finally {
                    if (sock!=null){
                        sock.close();
                    }
                }
            }
        };
        t.setPriority(Thread.NORM_PRIORITY);
        t.setDaemon(true);
        t.start();
    }

    public void ping() {
        try {
            //InetSocketAddress addr = new InetSocketAddress("10.1.2.255", PORT);
            InetAddress local = InetAddress.getLocalHost();
            String info = local.getHostAddress()+" "+System.currentTimeMillis();
            DatagramPacket data = new DatagramPacket(info.getBytes(), info.length());
            //������ 1: ������ �������������� �������
            byte[] addrB = local.getAddress();
            addrB[3] = (byte)255;
            //������ 2: ����� ����������
            /*for (Enumeration en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();){
                NetworkInterface ne  =(NetworkInterface) en.nextElement();
                System.out.println(ne.getName()+" "+ne.getDisplayName()+" "+Collections.list(ne.getInetAddresses()));
            }*/
            //System.out.println(local.getHostName());
            data.setSocketAddress(new InetSocketAddress(InetAddress.getByAddress(addrB), PORT));
            println("Broadcasting ping request: "+info);
            MulticastSocket sock = new MulticastSocket();
            //sock.joinGroup(local);
            sock.send(data);
            sock.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            println("ERROR: "+ex);
        }
    }

    private void println(String str){
        OutArea.append(str+"\n");
    }
}


class MainInt_this_windowAdapter extends WindowAdapter {
    private MainInt adaptee;
    MainInt_this_windowAdapter(MainInt adaptee) {
        this.adaptee = adaptee;
    }

    public void windowOpened(WindowEvent e) {
        adaptee.windowOpened();
    }
}


class MainInt_PingBut_actionAdapter implements ActionListener {
    private MainInt adaptee;
    MainInt_PingBut_actionAdapter(MainInt adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.ping();
    }
}
