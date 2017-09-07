package advgraphics.buffered;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.MediaTracker;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.image.ImageProducer;
import java.awt.image.ImageConsumer;
import java.awt.image.ColorModel;
import java.awt.Color;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.io.File;
import java.io.*;
import java.awt.image.RGBImageFilter;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.JOptionPane;
import java.awt.GraphicsDevice;

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
public class biMainInt extends JFrame {
    JPanel contentPane;
    BorderLayout borderLayout1 = new BorderLayout();
    JScrollPane jScrollPane1 = new JScrollPane();
    JToolBar jToolBar1 = new JToolBar();
    JButton LoadBut = new JButton();
    DrawPanel Draw = new DrawPanel();
    public static final String IMG ="Skyper.jpg";
    JButton FilterBut = new JButton();
    JButton SaveBut = new JButton();

    public biMainInt() {
        try {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Component initialization.
     *
     * @throws java.lang.Exception
     */
    private void jbInit() throws Exception {
        contentPane = (JPanel) getContentPane();
        contentPane.setLayout(borderLayout1);
        setSize(new Dimension(800, 600));
        setTitle("BufferedImage processing");
        LoadBut.setText("���������");
        LoadBut.addActionListener(new biMainInt_LoadBut_actionAdapter(this));
        FilterBut.setText("������� ������");
        FilterBut.addActionListener(new biMainInt_FilterBut_actionAdapter(this));
        SaveBut.setText("���������");
        SaveBut.addActionListener(new biMainInt_SaveBut_actionAdapter(this));
        contentPane.add(jScrollPane1, java.awt.BorderLayout.CENTER);
        jScrollPane1.getViewport().add(Draw);
        contentPane.add(jToolBar1, java.awt.BorderLayout.NORTH);
        jToolBar1.add(LoadBut);
        jToolBar1.add(SaveBut);
        jToolBar1.add(FilterBut);
    }

    public void load() {
        //��������� �������������
        /*ImageProducer ip = new ImageProducer(){
            private ImageConsumer ic=null;
            final int w = 400;
            final int h = 300;

            public void addConsumer(ImageConsumer ic) {
                this.ic = ic;
            }

            public boolean isConsumer(ImageConsumer ic) {
                if (this.ic==null) return false;
                return this.ic.equals(ic);
            }

            public void removeConsumer(ImageConsumer ic) {
                this.ic = null;
            }

            public void startProduction(ImageConsumer ic) {
                addConsumer(ic);
                ic.setHints(ImageConsumer.TOPDOWNLEFTRIGHT|ImageConsumer.COMPLETESCANLINES);
                ic.setDimensions(w, h);
                //ic.setColorModel(ColorModel.getRGBdefault());
                for (int y=0; y<h; y++){
                    int[] scanline  = new int[w];
                    Color c = new Color((int)((h-y)*255.0/h), 0, 0);
                    Arrays.fill(scanline, c.getRGB());
                    ic.setPixels(0, y, scanline.length, 1, ColorModel.getRGBdefault(), scanline, 0, scanline.length);
                }
                ic.imageComplete(ImageConsumer.STATICIMAGEDONE);
            }

            public void requestTopDownLeftRightResend(ImageConsumer ic) {
            }
        };
        Image img = Toolkit.getDefaultToolkit().createImage(ip);*/
        BufferedImage bimg = null;
        //������ 1
        /*Image img = Toolkit.getDefaultToolkit().getImage(IMG);
        MediaTracker mt = new MediaTracker(Draw);
        mt.addImage(img, 1);
        try {
            mt.waitForAll();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        bimg = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = bimg.createGraphics();
        g2.drawImage(img, 0, 0, null);
        g2.dispose();*/
        //2 ������
        try {
            ImageReader r = ImageIO.getImageReadersBySuffix(IMG.substring(IMG.
                    lastIndexOf(".") + 1).toLowerCase()).next();
            ImageInputStream in = ImageIO.createImageInputStream(new File(IMG));
            r.setInput(in);
            bimg = r.read(0);
            in.close();
            //r.dispose();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Draw.setImage(bimg);
    }


    public void applyFilter() {
        RGBImageFilter filter = new RGBImageFilter(){
            public int filterRGB(int x, int y, int rgb) {

                Color c = new Color(rgb);
              //Color c =new Color(25,67,6);
                  return new Color(255-c.getRed(), 255-c.getGreen(), 255-c.getBlue()).getRGB();
                // return new Color(255-c.getRed(), 255-c.getGreen(),255-c.getBlue()).getRGB();
           }
        };
        Draw.applyFilter(filter);
    }

    public void save() {
          try {
            if (Draw.getImage()!=null){
                ImageWriter w = ImageIO.getImageWritersBySuffix(IMG.substring(
                        IMG.
                        lastIndexOf(".") + 1).toLowerCase()).next();
                File f = new File(IMG.substring(0, IMG.lastIndexOf(".")) +
                                  " copy" + IMG.substring(IMG.lastIndexOf(".")));
                ImageOutputStream out = ImageIO.createImageOutputStream(f);
                w.setOutput(out);
                w.write(Draw.getImage());
                out.close();
                //r.dispose();
                JOptionPane.showMessageDialog(this,
                                              "����������� " + f.getName() + " ���������",
                                              "����������",
                                              JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}


class biMainInt_SaveBut_actionAdapter implements ActionListener {
    private biMainInt adaptee;
    biMainInt_SaveBut_actionAdapter(biMainInt adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.save();
    }
}


class biMainInt_FilterBut_actionAdapter implements ActionListener {
    private biMainInt adaptee;
    biMainInt_FilterBut_actionAdapter(biMainInt adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.applyFilter();
    }
}


class biMainInt_LoadBut_actionAdapter implements ActionListener {
    private biMainInt adaptee;
    biMainInt_LoadBut_actionAdapter(biMainInt adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.load();
    }
}
