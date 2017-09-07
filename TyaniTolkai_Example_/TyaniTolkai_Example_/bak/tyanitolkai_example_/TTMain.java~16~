package tyanitolkai_example_;

/**
 * Создать систему продюсер-траспортер-конзюмер. Продюсер производит число, транспортер его передает, конзюмер потребляет
 * Все элементы системы должны быть синхронинзированы и работать последовательно
 */
public class TTMain {
    public static Producer p = null;
    public static Consumer c = null;

    public TTMain() {
    }

    public static void main(String[] args) {
        p = new Producer(1200);
        c = new Consumer(200);
        p.start();
        c.start();
    }
}
