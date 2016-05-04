import java.awt.Event;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu extends JComponent
{
    JPanel panel = new JPanel(new GridLayout(2,1));
    JPanel buttonPanel = new JPanel(new GridLayout(1,2));
    JButton play = new JButton("PLAY");
    JButton controls = new JButton("CONTROLS");
    JLabel title = new JLabel("STREET-JEDI");
    JFrame frame = new JFrame("Street-Jedi-Dangerzone");
    public MainMenu()
    {
        frame.setSize(300,200);
        frame.add(panel);
        panel.add(title);
        panel.add(buttonPanel);
        buttonPanel.add(play);
        buttonPanel.add(controls);
        
        class PlayButtonListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                frame.setVisible(false);
                CharacterSelectMenu csm = new CharacterSelectMenu();
            }
        }
        class ControlsButtonListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                //stuff and things and stuff
            }
        }
        PlayButtonListener pListener = new PlayButtonListener();
        ControlsButtonListener cListener = new ControlsButtonListener();
        play.addActionListener(pListener);
        controls.addActionListener(cListener);
        
        frame.setVisible(true);
    }
    
}
