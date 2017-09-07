package streamsadvancedexample_;

import java.io.*;

public class Person implements Serializable {
    private String name;
    private int age;
    private boolean sex;

    public Person() {
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    public String toString(){
        return super.toString()+": "+name+" age="+age+" sex="+sex;
    }

    public static Person[] generate(int size){
        Person[] reply = new Person[size];
        for (int i=0; i<reply.length; i++){
            reply[i] = new Person();
            reply[i].setName("Chel #"+(i+1));
            reply[i].setAge(i+10);
            reply[i].setSex(i%2==0);
        }
        return reply;
    }

    public boolean getSex(){
        return sex;
    }

    public void setSex(boolean sex){
        this.sex = sex;
    }
}
