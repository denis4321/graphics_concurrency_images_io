package welcome;

import java.util.ArrayList;
import java.util.List;
import java.io.File;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2009</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class ToFindClass {

  public static void main(String[] args) throws Exception {
    FileFinder f = new FileFinder();
    List d = f.findFile("D:\\", ".txt");
    System.out.println("����� ������� "+d.size());
    System.out.println(d.toString());
}
}
