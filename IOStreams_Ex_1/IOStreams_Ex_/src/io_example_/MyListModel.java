package io_example_;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.*;
import javax.swing.event.*;
import java.io.*;

public class MyListModel extends AbstractListModel{
    Vector<Element> data = new Vector<Element>();
    //Vector listeners = new Vector();
    public static final File DATA = new File("mydata.txt");

    public MyListModel() {
    }

    public int getSize() {
        return data.size();
    }

    public Element getElementAt(int index) {
        return data.get(index);
    }

    public void addElement(Element e){
        data.add(e);
        this.fireIntervalAdded(this, getSize()-1, getSize()-1);
    }

    public void removeElement(int index){
        data.remove(index);
        this.fireIntervalRemoved(this, index, index);
    }

    public void save1() throws FileNotFoundException, IOException {
        FileOutputStream fOut = new FileOutputStream(DATA);//Поток-приемник
        DataOutputStream out = new DataOutputStream(fOut);//Сервисный поток
        for (Element e : data){
            out.writeLong(e.getTime());
            out.writeUTF(e.getName());
        }
        out.close();
    }

    public void load1() throws FileNotFoundException, IOException {
        DataInputStream in = new DataInputStream(new FileInputStream(DATA));
        int old = data.size();
        data.clear();
        while (in.available()>0){
            long time = in.readLong();
            String name = in.readUTF();
            Element elem = new Element(name);
            elem.setTime(time);
            data.add(elem);
        }
        in.close();
        this.fireContentsChanged(this, 0, Math.max(old, data.size()));//кидает событие изменения данных
    }

}
