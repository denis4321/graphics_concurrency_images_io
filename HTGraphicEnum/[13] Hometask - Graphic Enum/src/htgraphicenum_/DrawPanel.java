package htgraphicenum_;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.*;
import java.awt.geom.*;
import javax.swing.JSlider;

public class DrawPanel extends JPanel {
    FuncType func;
    float maxX;
    int numDiv = 400;
    int gaps = 16;
    public DrawPanel() {
        setBackground(Color.WHITE);
        func = FuncType.values()[0];
        maxX = 100;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        //��� �������� ������
        GradientPaint a = new GradientPaint(0,0,Color.WHITE,getWidth(),getHeight(), new Color(23,128,255));
        g2d.setPaint(a);
        g2d.fill(new Rectangle(0,0,getWidth(),getHeight()));
        //

        int gapWidth = getWidth()-2*gaps;
        int gapHeight = getHeight()-2*gaps;
       // int gapWidth=this.getWidth();
        //int gapHeight = getHeight();

        float maxY = func.maxY(maxX);
        float minY = func.minY(maxX);
        float midY = (minY+maxY)/2;
        float fX = maxX/gapWidth;
        float fY = (maxY-minY)/gapHeight;

        int posY = (int)(getHeight()/2+midY/fY);
        g.setColor(new Color(100,100,100));
        g.drawLine(gaps,0,gaps,getHeight());
        g.drawLine(0,posY,getWidth(),posY);
        g.drawLine(gaps-3,6,gaps,0);
        g.drawLine(gaps+3,6,gaps,0);
        g.drawLine(getWidth()-6,posY-3,getWidth(),posY);
        g.drawLine(getWidth()-6,posY+3,getWidth(),posY);
        g.drawString("0000",gaps,posY);

        int prevX, prevY;
        int currX = 0, currY = (int)(gapHeight/2-(func.getY(0)-midY)/fY);
        prevX = currX; prevY = currY;
        g.setColor(Color.RED);
        for (int i=1; i<=numDiv; i++){
            currX = i*gapWidth/numDiv;
            float currFY = func.getY(currX*fX);
            currY = (int)(gapHeight/2-(currFY-midY)/fY);
            g.drawLine(gaps+prevX,gaps+prevY,gaps+currX,gaps+currY);
      //g.drawLine(i,i,i+1,i+1);
        prevX = currX; prevY = currY;
        }
    }

    public void setFunc(FuncType func){
        this.func = func;
    }

    public void setMaxX(float maxX){
        this.maxX = maxX;
    }

    public void setDivs(int num){
        this.numDiv = num;
    }
}
