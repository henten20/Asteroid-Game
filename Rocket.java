package asteroidgame;

/*
 * University of Central Florida
 * COP 3330 Spring 2017
 * Author: <Henry_Ton>
 */

import blobz.BlobUtils;
import blobz.PolyBlob;
import blobz.SandBox;
import blobz.BlobAction;
import java.awt.Point;
import java.awt.event.KeyEvent; 
import blobz.BlobProximity;
import static java.awt.Color.red;

public class Rocket extends PolyBlob implements BlobAction, BlobProximity
{
    private double angle = 0.0;
    private final double delta = 0.15;
    private final double speed = 5.0;
    private Point[] p = {new Point(10,0), new Point(-10,-7), new Point(-5,0), new Point(-10,7)};
    private SandBox sb; 
    
    public Rocket(int x, int y, SandBox sb)
    {
        super(0,0,0);
        setLoc(x,y);   
        setPolygon(p);
        this.sb = sb; 
        setColor(red);
    }
       
    public void keyAction(KeyEvent e)
     { 
        int key = e.getKeyCode();
        
        if(key == 32)
        {
            launch(this.sb);
        }
        
        if(key == 37)
        {
            this.angle -= delta;
            
            if(this.angle > 2*Math.PI)
                this.angle -= 2*Math.PI;
            else if(this.angle < 0)
                this.angle += 2*Math.PI;
            setAngle(this.angle);
        }
        else if(key == 39)
        {
            this.angle += delta;
            
            if(this.angle > 2*Math.PI)
                this.angle -= 2*Math.PI;
            else if(this.angle < 0)
                this.angle += 2*Math.PI;
            setAngle(this.angle);
        }
        else if(key == 38)
        {
            Point current = getLoc();
            
            int xloc = (int)current.getX();
            int yloc = (int)current.getY();
  
            xloc = xloc + (int)Math.round(speed*Math.cos(this.angle));
            yloc = yloc + (int)Math.round(speed*Math.sin(this.angle));
            
            setLoc(xloc, yloc);
        }
     }

    public void launch(SandBox sb) 
    {
       BlobUtils.playSound();
       Point current = getLoc();
       int xloc = (int)current.getX();
       int yloc = (int)current.getY();
       
       double radius = getSize()/2;
       BlobUtils.rotatePoint((int) radius, this.angle);
       sb.addBlob(new Missle(xloc,yloc,this.angle));
    }
}
