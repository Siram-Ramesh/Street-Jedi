import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
public class Character extends JComponent
{
    int health;
    int stamina;
    int xloc;
    int yloc;
    boolean blocking;
    int damage;
    int height;
    boolean facingLeft;
    Rectangle2D.Double test;
    boolean isFlinching;
    boolean walking;
    int xmov;
    int ymov;
    
    public Character()
    {
        health = 250;
        stamina = 100;
        damage = 5;
        xmov = 0;
        ymov = 0;
    }
    public boolean isFacingLeft()
    {
        return facingLeft;
    }
    public void hurt(Character enemy, int atk, boolean direction)
    {
        if(!enemy.isBlocking() && facingLeft != enemy.isFacingLeft())health -= atk;
        
    }
    public void jump(int i)
    {
        if(!(yloc<500)) 
        {
            ymov = i;
            repaint();
        }
    }
    public void gravity(int i)
    {
        if(yloc<500) 
        {
            ymov -= i;
        }
    }
    public void move()
    {
        xloc += xmov;
        yloc += ymov;
        repaint();
    }
    public void changeXSpeed(int i)
    {
        xmov = i;
        walking = true;
        repaint();
    }
    public boolean isBlocking()
    {
        return blocking;
    }
    public void block()
    {
        stopWalking();
        blocking = true;
        repaint();
    }
    public void stopBlocking()
    {
        blocking = false;
        repaint();
    }
    public void stopWalking()
    {
        xmov = 0;
        walking = false;
        repaint();
    }
    public int getXLocation()
    {
        return xloc;
    }
    public int getYLocation()
    {
        return yloc;
    }
    public int getHeight()
    {
        return height;
    }
    public void groundMele(Character p2)
    {
        Rectangle2D.Double attack;
        if(facingLeft)
        {
            attack = new Rectangle2D.Double(xloc, yloc, height*2, height);
        }
        else
        {
            attack = new Rectangle2D.Double(xloc, yloc, height*2, height);
        }
        Rectangle2D.Double enemy = new Rectangle2D.Double(p2.getXLocation(), p2.getYLocation(), p2.getHeight(), p2.getHeight());
        if(attack.intersects(enemy))
        {
            p2.hurt(this, damage, facingLeft);
        }
    }
    public void airMele(Character p2)
    {
        
    }
    
}

