package dd1.random_access;

public class Element {
    private long num;

    public Element() {
        this(System.currentTimeMillis());
    }

    public Element(long num){
        this.num = num;
    }

    public String toString(){
        return "Element #"+num;
    }

    public long getNum(){
        return num;
    }

}
