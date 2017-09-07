package io_example_;

import java.io.*;

public class Element implements Serializable{
    private long num;
    private String text;
    //private boolean isNew;

    public Element(String text) {
        setName(text);
        num = System.currentTimeMillis();
        //isNew = true;
    }

    public String toString(){
        return text+" #"+num;
    }

    public void setName(String name){
        text = name;
    }

    public void setTime(long time){
        this.num = time;
        //isNew = false;
    }

    public long getTime(){
        return num;
    }

    public String getName(){
        return text;
    }

    /*public boolean isNew(){
        return isNew;
    }*/
}
