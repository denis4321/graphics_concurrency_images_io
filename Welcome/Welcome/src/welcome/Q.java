package welcome;

import javax.swing.ImageIcon;

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
public class Q extends Thread{
  Frame2 frame;
  public Q(Frame2 f) {
  frame=f;
  }

public void run(){
  int i=1;
  while(true){
    if (i==7)i=1;
    try {
      Thread.sleep(120);
    }
    catch (InterruptedException ex) {
    }

    frame.jLabel1.setIcon(new ImageIcon("C:\\Documents and Settings\\Me\\������� ����\\JAVA-RARS\\ListProject\\ListProject\\ListProject\\"+i+".png"));
    i++;
  }
}

}
