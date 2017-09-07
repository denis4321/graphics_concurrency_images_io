package imageloading_;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MainInt extends JFrame {
    JPanel contentPane;
    BorderLayout borderLayout1 = new BorderLayout();
    JTabbedPane Tabs = new JTabbedPane();
    JPanel SimpleLoad = new SimpleLoadPanel();

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
        contentPane.setLayout(borderLayout1);
        setSize(new Dimension(800, 600));
        setTitle("Image load example");
        contentPane.add(Tabs, java.awt.BorderLayout.CENTER);
        Tabs.add(SimpleLoad, "Простая загрузка изображения");
    }
}
