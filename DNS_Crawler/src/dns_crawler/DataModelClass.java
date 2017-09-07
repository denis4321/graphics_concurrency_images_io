package dns_crawler;

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
public class DataModelClass extends AbstractListModel {
    ArrayList ar =new ArrayList();

    public DataModelClass() {
    }


    public void addData(String str){
        if (!ar.contains(str)) {
            ar.add(str);
            this.fireIntervalAdded(str, ar.size() - 1, ar.size() - 1);
        }
    }


    public int getSize() {
        return ar.size();
    }

    public Object getElementAt(int index) {
        return ar.get(index);
    }

    public void clear(){
        int old = Math.max(ar.size()-1, 0);
        ar.clear();
        this.fireIntervalRemoved(this, 0, old);
    }
}
