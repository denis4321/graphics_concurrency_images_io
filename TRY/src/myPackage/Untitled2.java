package myPackage;

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
public class Untitled2 extends Thread {
  static  ThreadGroup t = new ThreadGroup("wwwww");
  static  ThreadGroup t1 = new ThreadGroup(t,"xzczxc");

    public Untitled2(ThreadGroup g) {
    super(g,"sd");

    }


    public static void main(String[] args) {
        Untitled2 untitled2 = new Untitled2(t);

        t.list();
    }
}
