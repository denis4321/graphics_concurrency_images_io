package networksex_.common;

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
public interface ConnectionListener {
    public void connectionCreated(Connection c);
    public void connectionClosed(Connection c);
    public void messageReceived(Connection c, String mess);
    public void connectionError(Connection c, Exception ex);
}
