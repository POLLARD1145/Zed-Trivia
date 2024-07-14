import javax.swing.*;
import java.awt.*;

public class HomeWindow{
    JFrame mainFrame = new JFrame();
    JPanel mainBox = new JPanel();
    JPanel sidePanel = new JPanel(); //left side to have the info button
    JPanel rightSidePanel = new JPanel();
    JPanel topNavBar = new JPanel(); //navigation bar to contain the timer
    JPanel bottomControlBox = new JPanel(); // to contain the control
    JPanel messageBox = new JPanel();
    JLabel message = new JLabel("Welcome to Zambia Trivia Quiz");
    
    public HomeWindow(){
        //initialize the mainFrame and it's attributes
        mainFrame.setTitle("Home - Zambia Trivia");
        mainFrame.setSize(1200,800);
        //add the top navigation bar
        mainFrame.add(topNavBar, BorderLayout.NORTH);
        topNavBar.setPreferredSize(new Dimension(1200,100));
        //add the bottom box to contain the controls
        mainFrame.add(bottomControlBox, BorderLayout.SOUTH);
        bottomControlBox.setPreferredSize(new Dimension(1200,100));
        //add the left side pane
        mainFrame.add(sidePanel, BorderLayout.WEST);
        sidePanel.setPreferredSize(new Dimension(200,600));
        //add the right side pane
        mainFrame.add(rightSidePanel, BorderLayout.EAST);
        rightSidePanel.setPreferredSize(new Dimension(200,600));

        //add the main center box
        mainFrame.add(mainBox, BorderLayout.CENTER);
        mainBox.setPreferredSize(new Dimension(800,600));
        mainBox.setBackground(new Color(128,128,128));

        mainBox.setLocation(200,100);
        mainBox.add(messageBox, BorderLayout.CENTER);
        messageBox.add(message);

        //end
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }
}
