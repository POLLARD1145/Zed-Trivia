import javax.swing.*;
import java.awt.*;

public class HomeFrame extends HomeWindow {
    String greeting = "Hello, welcome to Zambia Trivia Quiz Game";
    JLabel greetingLabel = new JLabel(greeting);
    JPanel greetingBox = new JPanel();
    JButton infoButton = new RoundedButton("?",35);
    public  HomeFrame(){
        super("Home");
        //add the greeting text into the center box using the greeting box
        greetingBox.add(greetingLabel);
        greetingBox.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        greetingBox.setPreferredSize(new Dimension(400,250));
        //
        mainBox.add(greetingBox, BorderLayout.CENTER);

        bottomControlBox.add(infoButton, BorderLayout.WEST);



    }
}
