package filechooserex_;

import java.awt.Toolkit;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.Dimension;

public class starter {
    boolean packFrame = false;

    /**
     * Construct and show the application.
     */
    public starter() {
        MainInt frame = new MainInt();
        // Validate frames that have preset sizes
        // Pack frames that have useful preferred size info, e.g. from their layout
        if (packFrame) {
            frame.pack();
        } else {
            frame.validate();
        }

        // Center the window
        frame.setLocation(100, 100);
        frame.setVisible(true);
    }

    /**
     * Application entry point.
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.
                                             getSystemLookAndFeelClassName());
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

                new starter();
            }
        });
    }
}
