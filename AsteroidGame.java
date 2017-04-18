package asteroidgame;

/*
 * University of Central Florida
 * COP 3330 Spring 2017
 * Author: <Henry_Ton>
 */

import blobz.BlobGUI;
import blobz.SandBox;
import blobz.SandBoxMode;
import java.util.Random;

public class AsteroidGame implements BlobGUI
{
    private static SandBox sb;
    Random random = new Random();
      
    public AsteroidGame()
    {
        sb = new SandBox();
        sb.init(this);
        sb.setFrameRate(15);
        sb.setSandBoxMode(SandBoxMode.FLOW);	
    }
    
    public static void main(String[] args)
    {
        new AsteroidGame();
    }
    
    @Override
    public void generate()
    {
        sb.addBlob(new Rocket(300,300,sb));
        
        for(int i = 0; i < 10; i++)
        {
            int x = 0, y = 0;
        
            while ( x == 0 || y == 0)
            {
                x = random.nextInt(7) - 3;
                y = random.nextInt(7) - 3;
            }
            
            double rot = (random.nextInt(2) == 1)? .1 : -.1;
            sb.addBlob(new Asteroid(x,y,rot));
        }
    }        
}
