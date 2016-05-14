import java.awt.*;
import javax.swing.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.geom.*;
public class Luke extends Character
{
    ImageIcon standing;
    ImageIcon walking;
    ImageIcon blocking;
    ImageIcon jumping;
    ImageIcon attacking;
    JLabel luke;
    
    public Luke()
    {
        super.height = 50;
        standing = new ImageIcon("lukeStand.gif");
        walking = new ImageIcon("lukeWalk.gif");
        attacking = new ImageIcon("lukeSlash1fast.gif");
        standing = new ImageIcon("lukeJump.gif");
        blocking = new ImageIcon("LukeBlock.gif");
        luke = new JLabel(standing);
    }
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        if(!(super.blocking))
        {
            luke.setIcon(blocking);
            //g2.setColor(Color.GREEN);
            Rectangle2D.Double placeHolder = new Rectangle2D.Double(300,300,50,50);
            System.out.println(this.getXLocation());
            g2.fill(placeHolder);
        }
        else
        {
            if(super.yloc < (500- super.height))
            {
                
            }
            else
            {
                if(super.walking)
                {
                    
                }
                else
                {
                    
                }
            }
        }
    }
}
