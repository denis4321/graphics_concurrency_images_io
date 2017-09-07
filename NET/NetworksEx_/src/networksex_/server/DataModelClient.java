package networksex_.server;

import javax.swing.AbstractListModel;
import java.util.ArrayList;

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
public class DataModelClient extends AbstractListModel {
    ArrayList<Person1> ar = new ArrayList<Person1>();
    boolean b = true;
    boolean flag;

    public void addData(Person1 p) {
        flag = false;
        Person1 p1 = new Person1();
        p1.setName(p.getName());
        p1.setAmount(1);
        int index = 0;
        if (b) {
            ar.add(p1);
            this.fireIntervalAdded(p1, ar.size() - 1, ar.size() - 1);
            b = false;
        } else {
            for (int i = 0; i < this.ar.size(); i++) {
                if (p.getName().toLowerCase().equals(ar.get(i).getName().
                        toLowerCase())) {
                    index = i;
                    flag = true;
                    break;
                }
            }

            if (flag) {
                int t = ar.get(index).getAmount() + 1;
                ar.get(index).setAmount(t);
                this.fireContentsChanged(this, 0, getSize() - 1);
            } else {
                ar.add(p1);
                this.fireIntervalAdded(p1, getSize() - 1, getSize() - 1);
            }
        }
    }

    public int getSize() {
        return ar.size();
    }

    public Person1 getElementAt(int index) {
        return ar.get(index);
    }
}
