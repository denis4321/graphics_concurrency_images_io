package networkex_gwain.common;

import networkex_gwain.homework.Message;
import java.io.Serializable;

public class MessageImpl implements Message{
    private String nick;
    private int type;
    private Serializable content;

    public MessageImpl(String nick, int type, Serializable content) {
        this.nick = nick;
        this.type = type;
        this.content = content;
    }

    public String getNick() {
        return nick;
    }

    public int getType() {
        return type;
    }

    public Object getContent() {
        return content;
    }

    public String getTo() {
        throw new UnsupportedOperationException(":(");
    }
}
