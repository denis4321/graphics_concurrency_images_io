package listproject;

import javax.swing.Icon;
import java.io.Serializable;

public class Person implements Serializable{
    private String name;
 // transient boolean b;
    private String surname;
    private String patronymic;
    private int ic;
    public static final long serialVersionUID = -1885396323724352296L;//���, ������������ ������ �������


    public Person() {
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getSurname(){
        return surname;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public String getPatronymic(){
        return patronymic;
    }

    public void setPatronymic(String patronymic){
        this.patronymic = patronymic;
    }

    public int getIcon(){
        return ic;
    }

    public void setIcon(int icon){
        this.ic = icon;
    }

}
