package enumexample_;

import java.util.*;

public class EnumEx {
    public EnumEx() {
    }

    public static void main(String[] args) {
        for (Month m : Month.values()){
            /*switch (m){
            case JAN:
                System.out.println("январь");
                break;
            case FEB:
                System.out.println("‘евраль");
                break;
            case MAR:
                System.out.println("ћарт");
                break;
            }*/
            System.out.println(m.getTitle());
        }
        //System.out.println(Month.JAN.getTitle());
        String name = Month.JAN.name();//»м€ энама
        System.out.println(name);
        Month m = Month.valueOf(name);//Ёнам по имени
        int number = m.ordinal();
        System.out.println(m+" , ordinal="+number);
    }
}
