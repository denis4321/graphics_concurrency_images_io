package networksex_.server;

import javax.swing.AbstractListModel;
//import networksex_.client.DataModelServer;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JLabel;

//import networksex_.client.Person1;

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
public class DataModelServer extends AbstractListModel {
    public ArrayList<Person1> shopList = new ArrayList<Person1>();

    public DataModelServer() {
        Person1 p = new Person1();
        p.setName("BMW");
        p.setAmount(11);
        addData(p);

        Person1 p1 = new Person1();
        p1.setName("Audi");
        p1.setAmount(7);
        addData(p1);

        Person1 p2 = new Person1();
        p2.setName("VW");
        p2.setAmount(11);
        addData(p2);

        Person1 p3 = new Person1();
        p3.setName("Opel");
        p3.setAmount(7);
        addData(p3);
        Person1 p4 = new Person1();
        p4.setName("JAGUAR");
        p4.setAmount(11);
        addData(p4);
        Person1 p5 = new Person1();
        p5.setName("MERCEDES");
        p5.setAmount(7);
        addData(p5);
    }


    public int getIndexOfName(String nameW) {
        int i = -1;
        if (nameW.trim().toLowerCase().equals("bmw")) {
            i = 0;
        } else if (nameW.trim().toLowerCase().equals("audi")) {
            i = 1;
        } else if (nameW.trim().toLowerCase().equals("vw")) {
            i = 2;
        } else if (nameW.trim().toLowerCase().equals("opel")) {
            i = 3;
        } else if (nameW.trim().toLowerCase().equals("jaguar")) {
            i = 4;
        } else if (nameW.trim().toLowerCase().equals("mercedes")) {
            i = 5;
        }
        return i;
    }


    public void addData(Person1 obj) {
        shopList.add(obj);
        this.fireIntervalAdded(obj, shopList.size() - 1, shopList.size() - 1);
    }

    public Person1 consumeAuto(int index) throws Exception {
        if (index != -1) {
            Person1 p = shopList.get(index);
                p.setOder();
            this.fireContentsChanged(this, index, index);
            return p;
        } else {
            return null;
        }
    }

    public int getSize() {
        return shopList.size();
    }

    public Person1 getElementAt(int index) {
        return (Person1) shopList.get(index);
    }

}

