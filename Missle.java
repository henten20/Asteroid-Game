package asteroidgame;

/*
 * University of Central Florida
 * COP 3330 Spring 2017
 * Author: <Henry_Ton>
 */

import blobz.Blob;
import blobz.BlobProximity;
import static java.awt.Color.blue;

public class Missle extends Blob implements BlobProximity
{
    final int size = 5;
    final double speed = 5.0; 
    
    public Missle(int x, int y, double theta) 
    {
        super(x, y, blue);
        setSize(size);
        
        int dx = (int)Math.round(speed*Math.cos(theta));
        int dy = (int)Math.round(speed*Math.sin(theta));
        setDelta(dx,dy);
    }
}
