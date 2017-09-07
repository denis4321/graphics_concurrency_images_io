package threadex_.priority;

public class ConcurrentThread extends Thread{

    public ConcurrentThread(String name, int priority) {
        setName(name);
        setPriority(priority);
    }

    public void run(){
        for (int i=0; i<1000; i++){
            //PriorityMain.sb.append(getName()+" : "+i+"\n");
            System.out.println(getName()+" : "+i);
            for (long j=0; j<1000000; j++){}
        }
    }
}
