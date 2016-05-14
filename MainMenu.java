import java.awt.Event;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import sun.audio.*;

public class MainMenu extends JComponent
{
    JPanel panel = new JPanel(new GridLayout(2,1));//the frame will be split into two rows: one that shows the title, and one that contains the buttons for playing and viewing the
                                                   //controls
    JPanel buttonPanel = new JPanel(new GridLayout(1,2));//this panel splits the lower row of the above panel into two columns, one for each button(play and controls)
    JButton play = new JButton("PLAY");//the JButton for starting a game
    JButton controls = new JButton("CONTROLS");//the JButton for viewing the controls 
    JLabel title = new JLabel("STREET-JEDI");//the JLabel displaying the title of the game- will be placed in the top row of the main panel.
    JFrame frame = new JFrame("Street-Jedi");
    AudioStream audioStream;//declaring an AudioStream instance field variable that will be used to play music- it is stored as an instance field variable so that it can be passed 
    //into other methods as a parameter. This allows the music to be stopped in other classes
    public MainMenu()
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());//setting  the look and feel of the frame allows the buttons to glow when the player mouses over them
        }
        catch (Exception ex){}
        frame.setSize(300,200);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//makes the music stop when the window is closed.
        frame.add(panel);
        panel.add(title);//assembles the panels and components
        panel.add(buttonPanel);
        buttonPanel.add(play);
        buttonPanel.add(controls);
        playSound();//starts playing the music
        class PlayButtonListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                frame.setVisible(false);//makes the main window invisible so that the players' screen isn't cluttered with windows as the game goes on
                CharacterSelectMenu csm = new CharacterSelectMenu(audioStream);//if the players choose to play, they are brought to the character select menu
                //the AudioStream object is passed in so that the CharacterSelectMenu object can stop playing the music when certain conditions are met.
            }
        }
        class ControlsButtonListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                //the main frame isn't hidden so that the players can still view the controls while they play the game, and don't have to exit their match to see how to play
                JFrame cframe = new JFrame("Controls");
                cframe.setSize(500,380);
                ControlsMenu cm = new ControlsMenu();
                cframe.add(cm);
                cframe.setVisible(true);/*The controls menu shows a BufferedImage that displays how to play the game. BufferedImages need to be drawn using the drawImage method
                of the Graphics class inside a JComponent's paintComponent method, so the Controls menu class is a Jcomponent with code for drawing the BufferedImage, and the 
                ControlsMenu object was added to a frame.*/
            }
        }
        PlayButtonListener pListener = new PlayButtonListener();
        ControlsButtonListener cListener = new ControlsButtonListener();//adding the actionListeners to the Jbuttons
        play.addActionListener(pListener);
        controls.addActionListener(cListener);
        
        frame.setVisible(true);//shows the window to the players once everything has been assembled
    }
    private void playSound() 
    {
        try
        {
            InputStream inputStream = getClass().getResourceAsStream("MenuTheme.wav");
            audioStream = new AudioStream(inputStream);
            AudioPlayer.player.start(audioStream);
        }
        catch (Exception e)
        {
            System.out.println("Audio File Not Found.");
        }
    }
}
