package networkex_gwain.common;

import networkex_gwain.homework.Message;

public interface ConnectionListener {
    public void connectionCreated(Connection conn);
    public void connectionClosed(Connection conn);
    public void connectionError(Connection conn, Exception ex);
    public void messageReceived(Connection conn, Message mess);
}
