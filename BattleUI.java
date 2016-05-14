
import java.awt.Event;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class BattleUI implements ActionListener
{
    Character player1;
    Character player2;
    JFrame frame;
    HealthBar stats;
    public BattleUI(int p1, int p2)
    {
        frame = new JFrame("Street-Jedi");
        frame.setSize(800,600);
        player1 = new Luke();
        player2 = new Luke();
        stats = new HealthBar(player1, player2);
        frame.add(player1);
        frame.setVisible(true);
        frame.add(player2);
        frame.setVisible(true);
        frame.add(stats);
        /*
        switch (p1)
        {
            case 0: player1 = new 
            break;
            case 1: player1 = new
            break;
            case 2: player1 = new
            break;
            case 3: player1 = new
            break;
            case 4: player1 = new
            break;
        }
        switch (p2)
        {
            case 0: player2 = new
            break;
            case 1: player2 = new
            break;
            case 2: player2 = new
            break;
            case 3: player2 = new
            break;
            case 4: player2 = new
            break;
        }  
        */
        class ControlsListener implements KeyListener
        {
            public void keyPressed(KeyEvent e)
            {
                switch(e.getKeyCode())
                {
                    case KeyEvent.VK_E:  
                         //if(player1.getXLocation()+player1.getHeight()<500)player1.airMele();
                         //else player1.groundMele();
                         player1.groundMele(player2);
                         
                    break;
                    case KeyEvent.VK_O: 
                         //if(player2.getXLocation()+player2.getHeight()<500)player2.airMele();
                         //else player2.groundMele();
                         player2.groundMele(player1);
                    break;
                    case KeyEvent.VK_S: player1.block(); break;
                    case KeyEvent.VK_K: player2.block(); break;
                    case KeyEvent.VK_D: if(!(player1.isBlocking())) player1.changeXSpeed(15);  break;
                    case KeyEvent.VK_A: if(!(player1.isBlocking())) player1.changeXSpeed(-15); break;
                    case KeyEvent.VK_W: if(!(player1.isBlocking())) player1.jump(15);  break;
                    case KeyEvent.VK_J: if(!(player2.isBlocking())) player2.changeXSpeed(-15);  break;
                    case KeyEvent.VK_L: if(!(player2.isBlocking())) player2.changeXSpeed(15);  break;
                    case KeyEvent.VK_I: if(!(player1.isBlocking())) player2.jump(15);  break;
                }
            }

            public void keyReleased(KeyEvent e)
            {
                switch(e.getKeyCode())
                {
                    case KeyEvent.VK_S: player1.stopBlocking(); break;
                    case KeyEvent.VK_K: player2.stopBlocking(); break;
                    case KeyEvent.VK_D: player1.stopWalking(); break;
                    case KeyEvent.VK_A: player1.stopWalking(); break;
                    case KeyEvent.VK_J: player2.stopWalking(); break;
                    case KeyEvent.VK_L: player2.stopWalking(); break;
                }
            }

            public void keyTyped(KeyEvent e){}   
        }
        frame.addKeyListener(new ControlsListener());
        Timer t = new Timer(5,this);
        t.start();
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        player1.move();
        player1.setLocation(player1.getXLocation(), player1.getYLocation());
        player1.repaint();
        player2.move();
        player2.setLocation(player2.getXLocation(), player2.getYLocation());
        player2.repaint();
        stats.repaint();
    }
}
