package streamsadvancedexample_;

import java.io.File;
import java.util.Arrays;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.util.*;
import java.io.*;

public class PropertiesEx {
    private static final File F = new File("11.txt");

    public PropertiesEx() {
    }

    public static void main(String[] args) {
        try{
            Person[] data = Person.generate(10);
            Properties props = new Properties();
            int index = 0;
            OutputStream out = new FileOutputStream(F);
            System.out.println(Arrays.toString(data));
            for (Person p : data){
                props.setProperty("p."+index+".name", p.getName());
                props.setProperty("p."+index+".age", Integer.toString(p.getAge()));
               // props.setProperty("p."+index+".sex", Boolean.toString(p.getSex()));
                index++;
            }
            props.store(out, "");
            out.close();
            System.out.println("-----------------------------------------------");
            InputStream in = new FileInputStream(F);
            props = new Properties();
            props.load(in);
            index = 0;
            String name = null;
            while ((name=props.getProperty("p."+index+".name"))!=null){
                int age = Integer.parseInt(props.getProperty("p."+index+".age"));
                Person p = new Person();
                p.setName(name);
                p.setAge(age);
                p.setSex(Boolean.parseBoolean(props.getProperty("p."+index+".sex", "true")));
                System.out.print(p+", ");
                index++;
            }
            System.out.println();
        } catch (IOException ex){
            ex.printStackTrace();
        }

    }
}
