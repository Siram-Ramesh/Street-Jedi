import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
public class HealthBar extends JComponent
{
    Character p1;
    Character p2;
    Rectangle2D.Double player1HealthBar;
    Rectangle2D.Double player2HealthBar;
    Rectangle2D.Double player1StaminaBar;
    Rectangle2D.Double player2StaminaBar;
    public HealthBar(Character player1, Character player2)
    { 
        p1 = player1;
        p2 = player2;
        player1HealthBar = new Rectangle2D.Double(0,0,player1.getHealth(), 50);
        player2HealthBar = new Rectangle2D.Double(350,0,player2.getHealth(), 50);
        player1StaminaBar = new Rectangle2D.Double(0,60,player1.getStamina(), 20);
        player2StaminaBar = new Rectangle2D.Double(350,60,player2.getStamina(), 20);
    }
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(0,255,0));
        player1HealthBar.setFrame(0,0,p1.getHealth(), 50);
        player2HealthBar.setFrame(350,0,p2.getHealth(), 50);
        g2.fill(player1HealthBar);
        g2.fill(player2HealthBar);
        g2.setColor(new Color(0,0,255));
        player1StaminaBar.setFrame(0,60,p1.getStamina(), 20);
        player2StaminaBar.setFrame(350,60,p2.getStamina(), 20);
        g2.fill(player1StaminaBar);
        g2.fill(player2StaminaBar);
    }
}
