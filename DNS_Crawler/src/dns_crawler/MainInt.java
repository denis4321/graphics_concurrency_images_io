package dns_crawler;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.*;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.Proxy;
import java.net.InetSocketAddress;
import java.io.InputStream;

public class MainInt extends JFrame {
    JPanel contentPane;
    GridBagLayout gridBagLayout1 = new GridBagLayout();
    JTextField AddressField = new JTextField();
    JButton GetPageBut = new JButton();
    JScrollPane jScrollPane1 = new JScrollPane();
    JTextField ProxyIPField = new JTextField();
    JTextField ProxyPortField = new JTextField();
    JCheckBox ProxyCheck = new JCheckBox();
    JTextArea LinkArea = new JTextArea();

    public MainInt() {
        try {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            jbInit();
            ProxyIPField.setText("127.0.0.1");
            ProxyPortField.setText("80");
            ProxyCheck.setSelected(true);
            AddressField.setText("www.yandex.ru");
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
        setTitle("������������ ������������");
        GetPageBut.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
        GetPageBut.setForeground(Color.blue);
        GetPageBut.setText("?");
        GetPageBut.addActionListener(new MainInt_GetPageBut_actionAdapter(this));
        ProxyIPField.setPreferredSize(new Dimension(100, 19));
        ProxyPortField.setPreferredSize(new Dimension(50, 19));
        ProxyCheck.setFont(new java.awt.Font("Tahoma", Font.BOLD, 11));
        ProxyCheck.setText("������");
        LinkArea.setFont(new java.awt.Font("SansSerif", Font.PLAIN, 11));
        contentPane.add(GetPageBut, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(5, 5, 5, 5), 0, 0));
        contentPane.add(AddressField,
                        new GridBagConstraints(0, 0, 3, 1, 1.0, 0.0
                                               , GridBagConstraints.CENTER,
                                               GridBagConstraints.HORIZONTAL,
                                               new Insets(5, 5, 5, 5), 0, 0));
        contentPane.add(ProxyPortField,
                        new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0
                                               , GridBagConstraints.CENTER,
                                               GridBagConstraints.NONE,
                                               new Insets(5, 5, 5, 5), 0, 0));
        contentPane.add(ProxyCheck, new GridBagConstraints(1, 1, 1, 1, 1.0, 0.0
                , GridBagConstraints.EAST, GridBagConstraints.NONE,
                new Insets(5, 5, 5, 5), 0, 0));
        contentPane.add(ProxyIPField,
                        new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0
                                               , GridBagConstraints.EAST,
                                               GridBagConstraints.NONE,
                                               new Insets(5, 5, 5, 5), 0, 0));
        contentPane.add(jScrollPane1,
                        new GridBagConstraints(0, 2, 4, 1, 1.0, 1.0
                                               , GridBagConstraints.CENTER,
                                               GridBagConstraints.BOTH,
                                               new Insets(5, 5, 5, 5), 0, 0));
        jScrollPane1.getViewport().add(LinkArea);
    }

    public void getPage() {
        try{
            URL url = new URL(AddressField.getText());
            HttpURLConnection conn = null;
            if (ProxyCheck.isSelected()){
                Proxy prox = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ProxyIPField.getText(), Integer.parseInt(ProxyPortField.getText())));
                conn = (HttpURLConnection) url.openConnection(prox);
            } else {
                conn = (HttpURLConnection) url.openConnection();
            }
            conn.connect();
            InputStream in = conn.getInputStream();
            StringBuilder sb = new StringBuilder();
            int val = -1;
            while ((val=in.read())>=0){
                sb.append((char)val);
            }
            getUrls(sb.toString());
            conn.disconnect();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void getUrls(String content){
        LinkArea.setText(content);
    }
}


class MainInt_GetPageBut_actionAdapter implements ActionListener {
    private MainInt adaptee;
    MainInt_GetPageBut_actionAdapter(MainInt adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.getPage();
    }
}
