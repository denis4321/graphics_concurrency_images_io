package cards;

import java.util.Arrays;
import java.util.Random;

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
public class Generator {
    private int [] koloda;
    private Random rnd;
    private Frame1 frame;

    public Generator(Frame1 frame) {
        this.frame=frame;
        rnd = new Random();
        koloda = new int[36];
        for (int i=0;i<36;i++){
           koloda[i] = i+1;
       }
       this.setNewRandomKoloda();
    }

    public int[] setNewRandomKoloda(){
        int p=0;
        int place=0;
        for (int i=0;i<36;i++){
           p = rnd.nextInt(35);
           place=koloda[i];
           koloda[i]=koloda[p];
           koloda[p]=place;
       }
        return koloda;
    }


    public  int[] getKoloda(){
        return koloda;
    }
}
