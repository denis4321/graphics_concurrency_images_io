package enumexample_;

import java.io.*;
import java.awt.event.*;

public enum Month /*implements ActionListener*/{//Может реализовать интерфейс
    JAN("Январь"){
        public String getSeason(){
            return "Зима";
        }
    },
    FEB("Февраль"){
        public String getSeason() {
            return "Зима";
        }
    },
    MAR("Март"){
         public String getSeason(){
             return "Весна";
         }
     };

    private String title;

    private Month(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public String toString(){
        return "На дворе месяц "+title;
    }

    public abstract String getSeason();

    /*public void actionPerformed(ActionEvent e){

    }*/

}
