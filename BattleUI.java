

import java.awt.Event;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class BattleUI
{
    Character player1;
    Character player2;
    JFrame frame;
    public BattleUI(int p1, int p2)
    {
        frame = new JFrame("Street-Jedi");
        frame.setSize(800,600);
        player1 = new Luke(frame);
        player2 = new Luke(frame);
        frame.add(player1);
        frame.add(player2);
        frame.setVisible(true);
        /*
        switch (p1)
        {
            case 0://player1 = new 
            break;
            case 1://player1 = new
            break;
            case 2://player1 = new
            break;
            case 3://player1 = new
        }
        switch (p2)
        {
            case 0://player2 = new
            break;
            case 1://player2 = new
            break;
            case 2://player2 = new
            break;
            case 3://player2 = new
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
                         
                    break;
                    case KeyEvent.VK_O: 
                         //if(player1.getXLocation()+player1.getHeight()<500)player1.airMele();
                         //else player1.groundMele();
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
    }
}
