import java.awt.Event;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import sun.audio.*;

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
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception ex){}
        frame.setSize(300,200);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.add(title);
        panel.add(buttonPanel);
        buttonPanel.add(play);
        buttonPanel.add(controls);
        playSound();
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
                JFrame cframe = new JFrame("Controls");
                cframe.setSize(500,380);
                ControlsMenu cm = new ControlsMenu();
                cframe.add(cm);
                cframe.setVisible(true);
            }
        }
        PlayButtonListener pListener = new PlayButtonListener();
        ControlsButtonListener cListener = new ControlsButtonListener();
        play.addActionListener(pListener);
        controls.addActionListener(cListener);
        
        frame.setVisible(true);
    }
    private void playSound() 
    {
        try
        {
            InputStream inputStream = getClass().getResourceAsStream("MenuTheme.wav");
            AudioStream audioStream = new AudioStream(inputStream);
            AudioPlayer.player.start(audioStream);
        }
        catch (Exception e)
        {
            System.out.println("Audio File Not Found.");
        }
    }
}
