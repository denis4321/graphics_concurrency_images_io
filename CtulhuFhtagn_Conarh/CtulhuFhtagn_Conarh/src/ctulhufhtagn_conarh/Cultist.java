package ctulhufhtagn_conarh;

import javax.swing.JLabel;
import java.util.*;

public class Cultist extends Mob{

    public Cultist(Timer t) {
        super(t, "cult.GIF", 35, 35);
    }

    public int moveSpeed() {
        return 32;
    }
}
