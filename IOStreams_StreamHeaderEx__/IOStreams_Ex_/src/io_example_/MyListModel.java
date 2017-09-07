package io_example_;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.*;
import javax.swing.event.*;
import java.io.*;

public class MyListModel implements ListModel, Serializable{
    Vector<Element> data = new Vector<Element>();
    transient Vector<ListDataListener> listeners;//����������, �� ����������� � ������������
    //Vector<ListDataListener> listeners;
    public static final File DATA = new File("mydata.txt");
    //public String text = "sometext";
    public static final long serialVersionUID = 1L;//���, ������������ ������ �������
    public static String text = "Sometext";

    public MyListModel() {
        listeners = new Vector<ListDataListener>();
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

    private void fireIntervalAdded(MyListModel model, int i, int i2) {
        ListDataEvent e = new ListDataEvent(this, ListDataEvent.INTERVAL_ADDED, i, i2);
        for (ListDataListener l : listeners){
            l.intervalAdded(e);
        }
    }

    private void fireIntervalRemoved(MyListModel model, int i, int i2) {
        ListDataEvent e = new ListDataEvent(this, ListDataEvent.INTERVAL_REMOVED, i, i2);
        for (ListDataListener l : listeners){
            l.intervalRemoved(e);
        }
    }

    private void fireContentsChanged(MyListModel model, int i, int i2) {
        ListDataEvent e = new ListDataEvent(this, ListDataEvent.CONTENTS_CHANGED, i, i2);
        for (ListDataListener l : listeners){
            l.contentsChanged(e);
        }
    }


    public void removeElement(int index){
        data.remove(index);
        this.fireIntervalRemoved(this, index, index);
    }

    public void save1() throws FileNotFoundException, IOException {
        FileOutputStream fOut = new FileOutputStream(DATA);//�����-��������
        DataOutputStream out = new DataOutputStream(fOut);//��������� �����
        out.write((int)'1');
        for (Element e : data){
            out.writeLong(e.getTime());
            out.writeUTF(e.getName());
        }
        out.close();
    }

    public void save2() throws IOException {//������������
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(DATA));
        for (Element e : data){
            out.writeObject(e);
        }
        out.close();
    }

    public void save3() throws IOException {
        /*MyListModel.text = "Some text";//��� �������� ������������ ����������� ����������
        System.out.println(MyListModel.text);*/
        final OutputStream fOut = new FileOutputStream(DATA);
        /*System.out.println("opening stream");//������������ ��������� �������������������
        ObjectOutputStream out = new ObjectOutputStream(new OutputStream(){
            public void write(int b) throws IOException {
                System.out.print(new String(new byte[]{(byte)b}));
                fOut.write(b);
            }

            public void close() throws IOException {
                fOut.close();
            }
        });
        System.out.println("\ngoing to write object");
        out.writeObject(this);
        System.out.println("\ndone writing object");
        out.close();
        System.out.println("\nclosing stream");*/
        ByteArrayOutputStream buf = new ByteArrayOutputStream();//����� � ������: �����-��������
        ObjectOutputStream out = new ObjectOutputStream(buf);
        out.writeObject(this);
        out.close();
        fOut.write((int)'2');
        fOut.write(buf.toByteArray());
        fOut.close();
    }

    public void load1(InputStream fin) throws FileNotFoundException, IOException {
        DataInputStream in = new DataInputStream(fin);
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
        this.fireContentsChanged(this, 0, Math.max(old, data.size()));//������ ������� ��������� ������
    }

    public void load2() throws IOException, ClassNotFoundException {//������������
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(DATA));
        int old = data.size();
        data.clear();
        try{
            while (true){
                Element elem = (Element) in.readObject();
                data.add(elem);
            }
        } catch (EOFException ex){
            //��������� ������....
            ex.printStackTrace();
        }
        in.close();
        this.fireContentsChanged(this, 0, Math.max(old, data.size()));
    }

    public static MyListModel load3(InputStream fin) throws ClassNotFoundException, IOException {
        /*MyListModel.text = "Other text before read";
        System.out.println(MyListModel.text);*/
        ObjectInputStream in = new ObjectInputStream(fin);
        MyListModel reply = (MyListModel) in.readObject();
        in.close();
        //System.out.println(reply.text+"after read");
        return reply;
    }

    public void addListDataListener(ListDataListener l) {
        if (listeners==null){
            listeners = new Vector<ListDataListener>();
        }
        listeners.add(l);
    }

    public void removeListDataListener(ListDataListener l) {
        listeners.remove(l);
    }

    /**
     * ������ ����������/�������� ������ ��� ������������
     */
    /*private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeObject(data);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        data = (Vector<Element>) in.readObject();
    }*/

    //--------------------------------------------------------

    /**
     * ������� ������ ������� ��� ������������ ������
     */
    /*public Object writeReplace() throws ObjectStreamException{//������ ������ ������� ������, ������� � ����� �����������������
        return new MyListModelTransferable(data);
    }*/
}
