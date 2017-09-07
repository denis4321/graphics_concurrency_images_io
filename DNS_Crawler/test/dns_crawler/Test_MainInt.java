package dns_crawler;

import junit.framework.*;
import java.io.InputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.io.ByteArrayInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListDataEvent;
import java.awt.Event;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class Test_MainInt extends TestCase {
    private MainInt mainInt = null;
   // private Event lastEvent=null;
     private ListDataEvent lastEvent = null;
     private HashSet<String> links = new LinkedHashSet<String>();

    public Test_MainInt(String name) {
        super(name);
    }





    protected void setUp() throws Exception {
        super.setUp();
        mainInt = new MainInt(){
            public void addLink(String ref){
                links.add(ref);
            }
        };
        mainInt.model.addListDataListener(new ListDataListener(){
            public void intervalAdded(ListDataEvent e) {
                lastEvent=e;

            }

            public void intervalRemoved(ListDataEvent e) {
                throw new UnsupportedOperationException(":(");
            }

            public void contentsChanged(ListDataEvent e) {
                throw new UnsupportedOperationException(":(");
            }

        }
            );


        /*{
          //  protected void closeConnection() {
                //do nothing
            }

            protected InputStream getConnectionInputStream() throws IOException,
                    NumberFormatException, MalformedURLException {
                String html = "wasw wsaw";
                return new ByteArrayInputStream(html.getBytes("cp1251"));
            }

        };*/
    }

    protected void tearDown() throws Exception {
        mainInt = null;
        super.tearDown();
    }

    public void testHrefs(){
        StringBuilder content = new StringBuilder("<br>���������� <a href='http://www.spr.ua/donetsk/'>������</a><br>"+
                                 "<br>������ <a href=\"http://www.spr.ua\"></a><br>"+
                                 "<td><noindex><a rel='nofollow' href='http://www.spr.ua/donetsk/turizm-i-otdih/' title='������ � ����� � ������'>������ � �����</a></noindex></td>");
        assertEquals("Links not empty", 0, links.size());
        mainInt.getHrefs(content);
        //System.out.println(links);
        for (String s : links){
            System.out.println(s);
        }
        System.out.println(links.size()+" links found");
        assertTrue("Ref not found: http://www.spr.ua/donetsk/", links.contains("http://www.spr.ua/donetsk/"));
        assertTrue("Ref not found: http://www.spr.ua", links.contains("http://www.spr.ua"));
        assertTrue("Ref not found: http://www.spr.ua/donetsk/turizm-i-otdih/", links.contains("http://www.spr.ua/donetsk/turizm-i-otdih/"));
    }



    public void testAdding(){
        //DataModelClass mod = new DataModelClass();
        for (int i=0;i<99;i++){
            mainInt.model.addData(i+"");
           // mainInt.model.addData("123");
            this.assertEquals(i+1,mainInt.model.getSize());

            this.assertEquals(lastEvent.getType(),ListDataEvent.INTERVAL_ADDED);

            //     assertEquals(mod.getElementAt(i-1).getClass(),mainInt.model.getElementAt(i-1).getClass());
        }

    }



}
