import java.awt.*;
import javax.swing.*;
public class Character extends JComponent
{
    int health;
    int stamina;
    int xloc;
    int yloc;
    boolean blocking;
    int damage;
    public Character()
    {
        health = 250;
        stamina = 100;
        blocking = false;
        damage = 5;
    }
    public void jump()
    {
    }
    public void moveLeft()
    {
        xloc -= 25;
    }
    public void moveRight()
    {
        xloc += 25;
    }
    public void block()
    {
        blocking = true;
    }
    public void stopBlocking()
    {
        blocking = false;
    }
    public int getXLocation()
    {
        return xloc;
    }
    public int getYLocation()
    {
        return yloc;
    }
    public void groundMele()
    {
        
    }
    public void airMele()
    {
        
    }
}

