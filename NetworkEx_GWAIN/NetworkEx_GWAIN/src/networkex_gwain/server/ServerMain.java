package networkex_gwain.server;

import java.net.*;
import networkex_gwain.common.*;
import java.util.*;
import networkex_gwain.homework.Message;

public class ServerMain implements ConnectionListener{
    private Set<Connection> conns = new LinkedHashSet<Connection>();

    public ServerMain() {
        try{
            ServerSocket ss = new ServerSocket(Connection.PORT);
            System.out.println("Server started jhjhh");
            while (true) {
                Socket s = ss.accept();
                Connection c = new Connection(s, this);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ServerMain();
    }

    public synchronized void connectionCreated(Connection conn) {
        conns.add(conn);
        System.out.println(conn.getName()+" created");
    }

    public synchronized void connectionClosed(Connection conn) {
        conns.remove(conn);
        System.out.println(conn.getName()+" closed");
    }

    public synchronized void connectionError(Connection conn, Exception ex) {
        System.out.println(conn.getName()+" error : ");
        ex.printStackTrace();
    }

    public synchronized void messageReceived(Connection conn, Message mess) {
        System.out.println(conn.getName()+" : message received");
        switch (mess.getType()){
        case Message.CLOSE:
            conn.close();
            break;
        case Message.TEXT:
            for (Connection c : conns) {
                if (c != conn) {
                    try {
                        c.send(mess);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        c.close();
                    }
                }
            }
            break;
       case Message.FILE:
           break;
        }
    }
}
