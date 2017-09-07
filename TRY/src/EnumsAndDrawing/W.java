package EnumsAndDrawing;

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
public class W extends Thread{
    public W() {
    }

    public void run(){
        for (int i=0;i<20;++i){
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        W w = new W();
        w.start();
        try {
            w.join();
            System.out.println("====================");
        }
        catch (Exception ex) {
        }
    }
}
