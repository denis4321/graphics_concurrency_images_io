package myPackage;

import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.io.PipedInputStream;
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
    public Untitled1() {
    }

    public static void main(String[] args) {
      //  Untitled1 untitled1 = new
      try{
      PipedOutputStream pOut = new PipedOutputStream();
      PipedInputStream pIn = new PipedInputStream(pOut);
//        PrintStream p = new PrintStream(pOut);
        PrintStream old =System.out;
        System.setOut(new PrintStream(pOut));
        for (int i=0;i<80;i++){
            System.out.println(i+"zxc");
        }

                 BufferedInputStream in = new BufferedInputStream(pIn);
                 System.setOut(old);
                // System.out.println(pIn.available());
                 while (in.available()>0)
                     System.out.write((char)in.read());

                // in.reset();
                 //in.close();
                 //pOut.close();
             }
             catch (EOFException e){

             }
            catch (Exception ex) {

            }

    }
}
