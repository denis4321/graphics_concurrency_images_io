package welcome;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2010</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class Untitled1 extends Thread {
 public static  Object ob2 = new Object();
 public static  Object ob1 = new Object();
  int i;

  public Untitled1(int i) {
    this.i=i;
  }

  public void mot1() throws InterruptedException {
    synchronized(ob1){
        sleep(10);
      System.out.println("I am in mot1");
      mot2();
    }
  }

  public void mot2() throws InterruptedException {
    synchronized(ob2){
          sleep(10);
      System.out.println("\tI AM IN MOT2");
      mot1();
    }
    }


  public void run(){
  try{  switch (i){
      case 1:
        mot1();
        break;
        case 2:
          mot2();
          break;}
    }
    catch (InterruptedException ex){
            ex.printStackTrace();
        }

  }



  public static void main(String[] args) {
    Untitled1 untitled1 = new Untitled1(1);
     Untitled1 untitled2 = new Untitled1(2);
     untitled1.start();
         untitled2.start();

  }
}
