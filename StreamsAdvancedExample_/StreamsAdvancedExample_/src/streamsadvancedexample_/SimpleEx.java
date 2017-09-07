package streamsadvancedexample_;

import java.io.*;
import java.util.*;

public class SimpleEx {
    private static final File F = new File("sample.txt");

    public SimpleEx() {
    }

    public static void main(String[] args) {
        try{
            byte[] buf = new byte[1024];
            Random rnd = new Random();
            rnd.nextBytes(buf);
            InputStream in = null;
            //in = new ByteArrayInputStream(buf);//1
            in = new BufferedInputStream(new FileInputStream(F));
            int size = in.available();
            System.out.println(size);
            OutputStream out = null;
            out = System.out;
            //out = new FileOutputStream(F);//1
            /*for (int i=0; i<size; i++){
                int b = in.read();
                out.write(b);
            }*/
            /*while (in.available()>0){//Первый вариант
                int b = in.read();
                out.write(b);
            }*/
            /*int b = -1;//Способ 2
            while ((b=in.read())>=0){
                out.write(b);
            }*/
            byte[] data = new byte[150];//Способ 3
            while (in.available()>0){
                int len = in.read(data);
                out.write(data, 0, len);
            }
            in.close();
            out.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
