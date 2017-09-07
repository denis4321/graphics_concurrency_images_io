package enumexample_;

import java.io.*;
import java.awt.event.*;

public enum Month /*implements ActionListener*/{//����� ����������� ���������
    JAN("������"){
        public String getSeason(){
            return "����";
        }
    },
    FEB("�������"){
        public String getSeason() {
            return "����";
        }
    },
    MAR("����"){
         public String getSeason(){
             return "�����";
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
        return "�� ����� ����� "+title;
    }

    public abstract String getSeason();

    /*public void actionPerformed(ActionEvent e){

    }*/

}
