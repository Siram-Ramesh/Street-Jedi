import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

public class CharacterSelectMenu
{
    JFrame frame = new JFrame("Street-Jedi");
    JPanel mainPanel = new JPanel(new GridLayout(1,2));
    JPanel p1Panel = new JPanel(new GridLayout(2,1));
    JPanel p2Panel = new JPanel(new GridLayout(2,1));
    JPanel p1PicturePanel = new JPanel();
    JPanel p2PicturePanel = new JPanel();
    JPanel p1SelectPanel = new JPanel(new GridLayout(3,1));
    JPanel p2SelectPanel = new JPanel(new GridLayout(3,1));
    JButton p1ObiWan = new JButton("Obi-Wan");
    JButton p2ObiWan = new JButton("Obi-Wan");
    JButton p1Vader = new JButton("Vader");
    JButton p2Vader = new JButton("Vader");
    JButton p1Yoda = new JButton("Yoda");
    JButton p2Yoda = new JButton("Yoda");
    JButton p1Dooku = new JButton("Dooku");
    JButton p2Dooku = new JButton("Dooku");
    JPanel p1CharacterPanel1 = new JPanel(new GridLayout(1,2));
    JPanel p1CharacterPanel2 = new JPanel(new GridLayout(1,2));
    JPanel p2CharacterPanel1 = new JPanel(new GridLayout(1,2));
    JPanel p2CharacterPanel2 = new JPanel(new GridLayout(1,2));
    JCheckBox p1Ready = new JCheckBox("READY?");
    JCheckBox p2Ready = new JCheckBox("READY?");
    
    int p1Character;
    int p2Character;
    
    public CharacterSelectMenu()
    {
        frame.setSize(600,800);
        frame.add(mainPanel);
        mainPanel.add(p1Panel);
        mainPanel.add(p2Panel);
        p1Panel.add(p1PicturePanel);
        p2Panel.add(p2PicturePanel);
        p1Panel.setBorder(new TitledBorder(new EtchedBorder(),"Player 1"));
        p1Panel.add(p1SelectPanel);
        p2Panel.setBorder(new TitledBorder(new EtchedBorder(),"Player 2"));
        p2Panel.add(p2SelectPanel);
        p1SelectPanel.add(p1CharacterPanel1);
        p1CharacterPanel1.add(p1ObiWan);
        p1CharacterPanel1.add(p1Vader);
        p1SelectPanel.add(p1CharacterPanel2);
        p1CharacterPanel2.add(p1Yoda);
        p1CharacterPanel2.add(p1Dooku);
        p2SelectPanel.add(p2CharacterPanel1);
        p2CharacterPanel1.add(p2ObiWan);
        p2CharacterPanel1.add(p2Vader);
        p2SelectPanel.add(p2CharacterPanel2);
        p2CharacterPanel2.add(p2Yoda);
        p2CharacterPanel2.add(p2Dooku);
        p1SelectPanel.add(p1Ready);
        p2SelectPanel.add(p2Ready);
        
        frame.repaint();
        frame.setVisible(true);
        
        class ObiWan1Listener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                p1Character = 0;
                frame.repaint();
            }
        }
        class Vader1Listener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                p1Character = 1;
                frame.repaint();
            }
        }
        class Yoda1Listener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                p1Character = 2;
                frame.repaint();
            }
        }
        class Dooku1Listener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                p1Character = 3;
                frame.repaint();
            }
        }
        class ObiWan2Listener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                p2Character = 0;
                frame.repaint();
            }
        }
        class Vader2Listener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                p2Character = 1;
                frame.repaint();
            }
        }
        class Yoda2Listener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                p2Character = 2;
                frame.repaint();
            }
        }
        class Dooku2Listener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                p2Character = 3;
                frame.repaint();
            }
        }
        p1ObiWan.addActionListener(new ObiWan1Listener());
        p1Vader.addActionListener(new Vader1Listener());
        p1Yoda.addActionListener(new Yoda1Listener());
        p1Dooku.addActionListener(new Dooku1Listener());
        p2ObiWan.addActionListener(new ObiWan2Listener());
        p2Vader.addActionListener(new Vader2Listener());
        p2Yoda.addActionListener(new Yoda2Listener());
        p2Dooku.addActionListener(new Dooku2Listener());
        
        class ReadyListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                if(p1Ready.isSelected() && p2Ready.isSelected())
                {
                    frame.setVisible(false);
                    BattleUI battle = new BattleUI(p1Character, p2Character);
                }
            }
        }
        
        p1Ready.addActionListener(new ReadyListener());
        p2Ready.addActionListener(new ReadyListener());
    
    }
    
    
}
