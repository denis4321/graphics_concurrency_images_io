package enumexample_;

import java.util.*;

public class EnumEx {
    public EnumEx() {
    }

    public static void main(String[] args) {
        for (Month m : Month.values()){
            /*switch (m){
            case JAN:
                System.out.println("������");
                break;
            case FEB:
                System.out.println("�������");
                break;
            case MAR:
                System.out.println("����");
                break;
            }*/
            System.out.println(m.getTitle());
        }
        //System.out.println(Month.JAN.getTitle());
        String name = Month.JAN.name();//��� �����
        System.out.println(name);
        Month m = Month.valueOf(name);//���� �� �����
        int number = m.ordinal();
        System.out.println(m+" , ordinal="+number);
    }
}
