package tr;

import javax.swing.AbstractListModel;
import java.util.Vector;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.EOFException;
import java.io.ByteArrayOutputStream;
import java.util.Properties;
//import listproject.Person;

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
public class DataModelClass extends AbstractListModel {
    Vector data =new Vector();
    static File DATA = new File("data.txt");
    public DataModelClass() {
    }

    public void addData(Person p){
        //int i=data.size();
        data.add(p);
        this.fireIntervalAdded(this,data.size()-1,data.size()-1);
    }

    public void delData(int i){
        data.remove(i);
        this.fireIntervalRemoved(this,i,i);
    }

    public void delAllData(){
        int n=data.size();
        data.clear();
        this.fireIntervalRemoved(this,0,Math.max(0,n-1));
    }

    public int getSize() {
        return data.size();
    }

    public Object getElementAt(int index) {
        return data.get(index);
    }

    public void save1() throws FileNotFoundException, IOException {
        FileOutputStream fOut = new FileOutputStream(DATA);
        DataOutputStream out = new DataOutputStream(fOut);
        out.write((int)'1');
        for (Object p : data){
            out.writeUTF(((Person)p).getName());
            out.writeUTF(((Person)p).getPatronymic());
            out.writeUTF(((Person)p).getSurname());
            out.writeInt(((Person)p).getImage());
        }
        out.close();
    }

    public void load1(FileInputStream fIn) throws FileNotFoundException, IOException {
    //FileInputStream fOut = new FileInputStream(DATA);
        DataInputStream in = new DataInputStream(fIn);
        int old=data.size();
        //data.clear();
        while(in.available()>0){
            Person p =new Person();
            String name=in.readUTF();
            String sur=in.readUTF();
            String pat=in.readUTF();
            p.setName(name);
            p.setPatronymic(sur);
            p.setSurname(pat);
            p.setImage( in.readInt());
            data.add(p);
            //System.out.println(234);
        }
        in.close();
        this.fireContentsChanged(this,0,Math.max(data.size(),old));
    }

    public void save2() throws FileNotFoundException, IOException {
          FileOutputStream fOut = new FileOutputStream(DATA);
          //ObjectOutputStream out = new ObjectOutputStream(fOut);
          ByteArrayOutputStream buf = new ByteArrayOutputStream();
          ObjectOutputStream out = new ObjectOutputStream(buf);
          fOut.write('2');
          for (Object p:data){
          out.writeObject(p);
          }
      //    out.close();
          fOut.write(buf.toByteArray());
        out.close();
    }

    public void load2(FileInputStream fOut) throws FileNotFoundException, IOException,
            ClassNotFoundException {
       // FileInputStream fOut = new FileInputStream(DATA);
        ObjectInputStream out = new ObjectInputStream(fOut);
        int old=data.size();
        data.clear();
        try{while(true){
            Person p = new Person();
                p=(Person) out.readObject();
                data.add(p);

        }}
    catch (EOFException e){
        //e.printStackTrace();
    }
    this.fireContentsChanged(this,0,Math.max(old,data.size()));
    }

    public void save3() throws FileNotFoundException, IOException {
        FileOutputStream fOut = new FileOutputStream(DATA);
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        ObjectOutputStream out= new ObjectOutputStream(buf);
        fOut.write('3');
// ByteArrayOutputStream buf = new ByteArrayOutputStream();
        out.writeObject(this);
        fOut.write(buf.toByteArray());
        //return this;
    }

    public DataModelClass load3( FileInputStream fIn) throws FileNotFoundException, IOException,
            ClassNotFoundException {
       // FileInputStream fIn = new FileInputStream(DATA);
        ObjectInputStream in = new ObjectInputStream(fIn);
        int old=data.size();
        data.clear();

        this.fireContentsChanged(this,0,Math.max(old,data.size()));
        return  (DataModelClass) in.readObject();
    }

    public void save4() throws FileNotFoundException, IOException {
        Properties props = new Properties();
       FileOutputStream fOut =new FileOutputStream(DATA);
       fOut.write('4');
       int index=0;
        //props.store(fOut,"");
        for (Object p: data){
            //p=(Person)p;
            props.setProperty("name"+index,((Person)p).getName());
             props.setProperty("patronymic"+index,((Person)p).getPatronymic());
             props.setProperty("surname"+index,((Person)p).getSurname());
             String t=((Person)p).getImage()+"";
             props.setProperty("image"+index,t);
             props.store(fOut,"");
             index++;
         }
    fOut.close();
    }

    public void load4(FileInputStream fIn) throws FileNotFoundException, IOException {
        Properties props = new Properties();
       //FileInputStream fIn =new FileInputStream(DATA);
       int old=data.size();
       data.clear();
       props.load(fIn);
       String str=null;
       int i=0;

       while((str=props.getProperty("name"+i))!=null){
           Person p = new Person();
           String h=props.getProperty("image"+i);
            String f=props.getProperty("surname"+i);
            String v=props.getProperty("patronymic"+i,"dfs");
            String s=props.getProperty("name"+i);
           p.setImage(Integer.parseInt(h));
           p.setName(s);
           p.setPatronymic(v);
           p.setSurname(f);
           data.add(p);
           i++;
       }
       fIn.close();
       this.fireContentsChanged(this,0,Math.max(old,data.size()));
    }

}
