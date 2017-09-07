package myPackage;

import javax.swing.JLabel;
import java.util.ArrayList;
import javax.swing.AbstractListModel;

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
public class TreeObserverModel extends AbstractListModel  {
    ArrayList grandfatherList = new ArrayList();
    ArrayList fatherList = new ArrayList();
    ArrayList sunList = new ArrayList();


    public TreeObserverModel() {
        this.grandfatherList.add(Potok1.grandfather.getName());
        this.fatherList.add(Potok1.father.getName());
        this.sunList.add(Potok1.sun.getName());
    }

    public void addGrandfatherData(String s){
        grandfatherList.add(s);
        System.out.println("www");
        this.fireIntervalAdded(this,this.getSize(),this.getSize());
    }

    public void addFatherData(String s){
       fatherList.add(s);
        System.out.println("ddd");
        this.fireIntervalAdded(this,this.getSize()-1,this.getSize()-1);
   }

   public void addSunData(String s){
       sunList.add(s);
        System.out.println("zzz");
        this.fireIntervalAdded(this,this.getSize()-1,this.getSize()-1);
   }

   public void delGrandfatherData(int index){
       this.grandfatherList.remove(index);
       this.fireIntervalRemoved(this,index,index);
   }

   public void delFatherData(int index){
       this.fatherList.remove(index);
       this.fireIntervalRemoved(this,index,index);
   }

   public void delSunData(int index){
       this.grandfatherList.remove(index);
       this.fireIntervalRemoved(this,index,index);
   }

   public void delAllGrandfatherData(){
       this.grandfatherList.clear();
       this.fireIntervalRemoved(this,1,grandfatherList.size());
   }

   public void delAllFatherData(){
      this.fatherList.clear();
      this.fireIntervalRemoved(this,1,fatherList.size());
  }

  public void delAllSunData(){
      this.sunList.clear();
      this.fireIntervalRemoved(this,1,sunList.size());
  }

  public void delAllData(){
      this.grandfatherList.clear();
      this.fatherList.clear();
      this.sunList.clear();
      this.fireIntervalRemoved(this,0,this.getSize());
  }




    public int getSize() {
        return this.grandfatherList.size()+this.fatherList.size()+this.sunList.size();
    }

    public Object getElementAt(int index) {
       // if (this.grandfatherList.size()<index)return fatherList.get(index-grandfatherList.size());
        //else if ((this.fatherList.size()<index))return sunList.get(index-fatherList.size()-grandfatherList.size());
        //else return this.grandfatherList.get(index);
        return null;
    }
}
