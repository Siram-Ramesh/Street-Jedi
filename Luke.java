import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
public class Luke extends Character
{
    BufferedImage standing;
    BufferedImage walking;
    BufferedImage blocking;
    BufferedImage jumping;
    BufferedImage attacking;
    JFrame frame;
    public Luke(JFrame fr)
    {
        frame = fr;
        super.height = 50;
        try {
            standing = ImageIO.read(new File("lukeStand.gif"));
        } catch (IOException e) {
        }
        try {
            walking = ImageIO.read(new File("lukeWalk.gif"));
        } catch (IOException e) {
        }
        try {
            attacking = ImageIO.read(new File("lukeSlash1fast.gif"));
        } catch (IOException e) {
        }
        try {
            standing = ImageIO.read(new File("lukeJump.gif"));
        } catch (IOException e) {
        }
    }
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        if(super.blocking)
        {
            //g2.drawImage((Image)blocking, 0,0, null);
        }
        else
        {
            if(super.yloc < (500- super.height))
            {
                g2.drawImage((Image)jumping, 0,0, null);
            }
            else
            {
                if(super.walking)
                {
                    g2.drawImage((Image)walking, 0,0, null);
                }
                else
                {
                    g2.drawImage((Image)standing, 0,0, null);
                }
            }
        }
    }
}
