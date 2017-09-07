package networksex_.server;

import java.net.ServerSocket;
import java.net.Socket;
import networksex_.common.Connection;
import java.io.IOException;

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
public class ServerConnection implements Runnable{
    private servMainInt owner;
    private ServerSocket ss;

    public ServerConnection(servMainInt owner) {
        this.owner = owner;
        Thread t = new Thread(this);
        t.setPriority(Thread.NORM_PRIORITY);
        t.start();
    }

    public void run(){
        try{
            ss = new ServerSocket(3334);
            while (true){
                Socket s = ss.accept();
                new Connection(s, owner);
            }
        } catch (Exception ex){
            if (!ss.isClosed()){
                owner.println("ERROR: "+ex);
                ex.printStackTrace();
            } /*else {
                ex.printStackTrace();
            }*/
        }
    }

    public void close() throws IOException {
        ss.close();
    }

}
