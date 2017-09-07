package networkex_gwain.homework;

import java.io.*;

/**
 * Интерфейс сообщения.
 */
public interface Message extends Serializable{
    public static final int TEXT = 1;
    public static final int CLOSE = 2;
    public static final int FILE = 3;

    /**
     * Возвращает ник
     */
    public String getNick();

    /**
     * Тип сообщения
     */
    public int getType();

    /**
     * Возвращает содержимое
     */
    public Object getContent();

    /**
     * Отправляет сообщение в приват. Если нулл, расслыка всем
     */
    public String getTo();
}
