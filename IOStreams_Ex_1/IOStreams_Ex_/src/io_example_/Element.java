package io_example_;

public class Element {
    private long num;
    private String text;

    public Element(String text) {
        setName(text);
        num = System.currentTimeMillis();
    }

    public String toString(){
        return text+" #"+num;
    }

    public void setName(String name){
        text = name;
    }

    public void setTime(long time){
        this.num = time;
    }

    public long getTime(){
        return num;
    }

    public String getName(){
        return text;
    }
}
