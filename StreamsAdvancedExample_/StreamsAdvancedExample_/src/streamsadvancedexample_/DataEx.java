package streamsadvancedexample_;

import java.io.File;
import java.io.*;
import java.util.*;

public class DataEx {
    private static final File F = new File("data.txt");

    public DataEx() {

    }

    public static void main(String[] args) {
        try{
            Person[] data = Person.generate(10);
            DataOutputStream out = new DataOutputStream(new FileOutputStream(F));
            System.out.println(Arrays.toString(data));
            for (Person p : data){
                out.writeUTF(p.getName());
                out.writeInt(p.getAge());
            }
            out.close();
            System.out.println("-----------------------------------------------");
            DataInputStream in = new DataInputStream(new FileInputStream(F));
            while (in.available()>0){
                String name = in.readUTF();
                int age = in.readInt();
                Person p = new Person();
                p.setName(name);
                p.setAge(age);
                System.out.print(p+", ");
            }
            System.out.println();
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
