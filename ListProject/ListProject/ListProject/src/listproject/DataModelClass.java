package listproject;

import javax.swing.AbstractListModel;
import java.util.ArrayList;
import java.util.Vector;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.DataInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.io.EOFException;
import java.io.ByteArrayOutputStream;
import java.util.Properties;
//import io_example_.Element;

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
public class DataModelClass extends AbstractListModel implements Serializable {
    private Vector<Person> data = new Vector<Person>();
    public static File  DATA= new File("data.txt");

    public void addData(Person obj){
        data.add(obj);
        this.fireIntervalAdded(this,data.size()-1,data.size()-1);
    }

    public void delAllData(){
        int n = getSize();
       data.clear();
        this.fireIntervalRemoved(this, 0, Math.max(0, n-1));
    }

    public void delSelectedData(int index){
        data.remove(index);
        this.fireIntervalRemoved(this,index,index);
    }

    public int getSize() {
        return data.size();
    }

    public Person getElementAt(int index) {
        return (Person)data.get(index);
    }

   public void save1() throws FileNotFoundException, IOException {
       FileOutputStream fOut=new FileOutputStream(DATA);
       DataOutputStream out = new DataOutputStream(fOut);
       out.write((int)'1');
       for (Person p:data){
           out.writeInt(p.getIcon());
           out.writeUTF(p.getName());
           out.writeUTF(p.getPatronymic());
           out.writeUTF(p.getSurname());
       }
       out.close();
   }

   public void load1(FileInputStream fIn) throws FileNotFoundException, IOException {
       DataInputStream in = new DataInputStream(fIn);
       int old=data.size();
       data.clear();
       while(in.available()>0){
           int image=in.readInt();
           String name=in.readUTF();
           String patronymic=in.readUTF();
           String surname=in.readUTF();
           Person p = new Person();
           p.setIcon(image);
           p.setName(name);
           p.setPatronymic(patronymic);
           p.setSurname(surname);
           data.add(p);
       }
       in.close();
       this.fireContentsChanged(this,0,Math.max(data.size(),old));
   }

   public void save2() throws FileNotFoundException, IOException {
       ByteArrayOutputStream buf = new ByteArrayOutputStream();//Буфер в памяти: поток-приемник
       ObjectOutputStream out = new ObjectOutputStream(buf);
       FileOutputStream fOut=new FileOutputStream(DATA);
       for (Person p:data){
           out.writeObject(p);
       }
       out.close();
       fOut.write((int)'2');
       fOut.write(buf.toByteArray());
       fOut.close();
   }

   public void load2(FileInputStream fIn) throws FileNotFoundException, IOException,
           ClassNotFoundException {
       ObjectInputStream in = new ObjectInputStream(fIn);
       int old=data.size();
       data.clear();
      try{
           while (true) {
               Person p = (Person) in.readObject();
               data.add(p);
           }
       }
       catch (EOFException e){
           //e.printStackTrace();
       }
       in.close();
       this.fireContentsChanged(this,0,Math.max(data.size(),old));
   }

   public void save3() throws FileNotFoundException, IOException {
       FileOutputStream fOut=new FileOutputStream(DATA);
       ByteArrayOutputStream buf = new ByteArrayOutputStream();//Буфер в памяти: поток-приемник
       ObjectOutputStream out = new ObjectOutputStream(buf);
       out.writeObject(this);
       out.close();
       fOut.write((int)'3');
       fOut.write(buf.toByteArray());
       fOut.close();
   }

   public DataModelClass load3(FileInputStream fIn) throws FileNotFoundException, IOException,
            ClassNotFoundException {
       ObjectInputStream in = new ObjectInputStream(fIn);
       return (DataModelClass) in.readObject();
   }

   public void save4() throws FileNotFoundException, IOException {
       FileOutputStream out = new FileOutputStream(DATA);
       Properties pr = new Properties();
       out.write('4');
       int i=0;
       for (Person p:data){
           pr.setProperty("name"+i,p.getName());
           pr.setProperty("surname"+i,p.getSurname());
           pr.setProperty("patronymic"+i,p.getPatronymic());
           pr.setProperty("icon"+i,p.getIcon()+"");
           pr.store(out,"");
           i++;
       }
   }

   public void load4() throws FileNotFoundException, IOException {
       FileInputStream in =new FileInputStream(DATA);
       Properties props = new Properties();
       int old=data.size();
       data.clear();
       props.load(in);
       int i=0;
       String str=null;
       while((str=props.getProperty("name"+i))!=null) {
           Person p = new Person();
           p.setName(props.getProperty("name"+i, "piter"));
           p.setSurname(props.getProperty("surname"+i, "pen"));
           p.setPatronymic(props.getProperty("patronymic"+i, "nicolaevich"));
           p.setIcon(Integer.parseInt(props.getProperty("icon"+i, "1")));
           data.add(p);
           i++;
       }
       in.close();
       this.fireContentsChanged(this,0,Math.max(data.size(),old));
   }
}
