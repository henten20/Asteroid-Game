package asteroidgame;

/*
 * University of Central Florida
 * COP 3330 Spring 2017
 * Author: <Henry_Ton>
 */

import blobz.BlobUtils;
import blobz.PolyBlob;
import java.util.Random;
import java.awt.Point;

public class Asteroid extends PolyBlob
{
    private static Random random = new Random();
     
    public Asteroid ( int x, int y, double rot)
    {
        super(-100, -100, rot);
        setDelta( x, y);
        
        int sides = random.nextInt(5) + 5;
        Point[] p = new Point[sides];
        double region = 2* Math.PI / sides;
    
        // creating vertex for each side
        for(int i = 0; i < sides; i++)
        {
            int distance = random.nextInt(11)+5;
            double angle = (i * region) + (Math.random()*region);
            p[i] = BlobUtils.rotatePoint(distance, angle);
        }
 
        setPolygon(p);
    }
}
 