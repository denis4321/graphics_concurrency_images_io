package tr;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.*;
import javax.swing.JProgressBar;

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
public class ProgressDialog extends JDialog {
    Frame2 owner;
    public ProgressDialog(Frame2 owner) {
        //this.owner=owner;
        super(owner,"TITLE",true);
    this.owner=owner;
        //ProgressDialog();
   this.setLocationRelativeTo(owner);

        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        this.pack();
    }

/*    public ProgressDialog(Frame1 owner) {
    super(owner,"TITLE",true);
    //ProgressDialog();
    this.setLocationRelativeTo(owner);
} */

    private void jbInit() throws Exception {
     //this.setLocationRelativeTo();
        jProgressBar1.setStringPainted(true);
        this.setDefaultCloseOperation(3);
        this.getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
        jPanel1.add(jProgressBar1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));
        jPanel1.setLayout(gridBagLayout1);
    }

    JPanel jPanel1 = new JPanel();
    GridBagLayout gridBagLayout1 = new GridBagLayout();
    JProgressBar jProgressBar1 = new JProgressBar();

    public void setProgress(int i){
        //jProgressBar1.stringPainted(true);
        jProgressBar1.setValue(i);
        jProgressBar1.setString(i+"%");
        try {
            Thread.sleep(120);
        } catch (InterruptedException ex) {
        }
        if (i>100){
            this.dispose();
        }
    }

}
