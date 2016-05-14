import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
public class ControlsMenu extends JComponent
{
    
    BufferedImage controls;
    public ControlsMenu()
    {
        
        try {
            controls = ImageIO.read(new File("That One Controls Sheet.png"));
        } catch (IOException e) 
        {
            System.out.println("File not found");
        }
    }
    public void paintComponent(Graphics g)
    {
        g.drawImage(controls, 0,0, null);
    }
}
