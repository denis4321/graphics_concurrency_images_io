package dd1.random_access;

import java.io.*;
import java.util.Vector;

import javax.swing.AbstractListModel;

public class MyListModel /*implements ListModel*/extends AbstractListModel{
    public static final File DATA_FILE = new File("data.txt");
    RandomAccessFile dataFile = null;

    public MyListModel() throws IOException {
        openDataFile();
    }

    private void openDataFile() throws IOException {
        try {
            dataFile = new RandomAccessFile(DATA_FILE, "rw");
        } catch (FileNotFoundException ex){
            DATA_FILE.createNewFile();
            openDataFile();
        }
    }

    public int getSize() {
        try{
            return (int)(dataFile.length()/8);
        } catch (Exception ex){
            throw new IllegalStateException(ex);
        }
    }

    public Object getElementAt(int index) {
        try{
            dataFile.seek(index*8);
            Element elem = new Element(dataFile.readLong());
            return elem;
        } catch (Exception ex){
            throw new IllegalStateException(ex);
        }
    }

    public void addElement(Element e) throws IOException {
        dataFile.seek(dataFile.length());
        dataFile.writeLong(e.getNum());
        this.fireIntervalAdded(this, getSize()-1, getSize()-1);
    }

    public void removeElement(int index) throws IOException {
        if (dataFile.length()>8){
            dataFile.seek(dataFile.length()-8);
            long tmp = dataFile.readLong();
            dataFile.seek(index*8);
            dataFile.writeLong(tmp);
        }
        dataFile.setLength(dataFile.length()-8);
        //data.remove(index);
        this.fireIntervalRemoved(this, index, getSize()-1);
    }

}
