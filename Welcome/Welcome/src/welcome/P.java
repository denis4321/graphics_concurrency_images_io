package welcome;

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
public class P {
  Frame1 f ;
  public P(Frame1 f) {
  this.f=f;
  }
  public void g(){
   // Frame1 f =new Frame1();
    int i=1+f.jComboBox1.getSelectedIndex();
     int j=1+f.jComboBox2.getSelectedIndex();
  f.jButton1.setText(i+" "+j);
   }
}
