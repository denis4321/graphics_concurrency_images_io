package tr;

import java.io.PrintStream;
import java.io.File;
import java.io.*;

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
public class Untitled1 {

    public static void main(String[] args) throws FileNotFoundException,
            IOException {
        ///try {



        FileInputStream fIn = new FileInputStream("1.txt");
  //DataInputStream da =new DataInputStream(fIn);
     //   PrintReader f = new PrintReader(new File("1.txt"));
        // System.out.println(f.read());

        //DataInputStream in = new DataInputStream(in1);
        //ByteArray ar = new ByteArray(in);

        BufferedInputStream in = new BufferedInputStream(fIn);

  while(in.available()>0){
      System.out.print((char)in.read());


  }

    }
}

      /*  PrintStream p = null;
      try {
            p = new PrintStream(new FileOutputStream("1.txt"), true);

        } catch (FileNotFoundException ex) {
        }
            System.setOut(p);
            for (int g=0;g<8;g++)
                System.out.print(g+1+"asdad"+System.getProperty("line.separator"));
        */












            //PrintStream p = new PrintStream(new FileOutputStream("w.txt"),true);
            //System.setOut(p);
            //for (int i=0;i<9;i++)
            //System.out.print(34+System.getProperty("line.separator"));
        //} catch (FileNotFoundException ex) {
       // }


  //  }
//}
