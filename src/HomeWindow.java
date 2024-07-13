import javax.swing.*;
import java.awt.*;

public class HomeWindow{
    JFrame mainFrame = new JFrame();
    JPanel mainBox = new JPanel();
    JPanel messageBox = new JPanel();
    JLabel message = new JLabel("Welcome to Zambia Trivia Quiz");
    public HomeWindow(){
        mainFrame.setTitle("Home - Zambia Trivia");
        mainFrame.setSize(1200,800);
        mainFrame.add(mainBox, BorderLayout.CENTER);
        

        //end
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }
}
