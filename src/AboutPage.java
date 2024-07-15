import javax.swing.*;
import java.awt.*;

public class AboutPage extends JPanel {
    private JFrame parentFrame;

    public AboutPage(JFrame frame) {
        this.parentFrame = frame;
        setLayout(new BorderLayout());

        JLabel aboutLabel = new JLabel("About the Game", JLabel.CENTER);
        aboutLabel.setFont(new Font("Serif", Font.BOLD, 32));
        add(aboutLabel, BorderLayout.NORTH);

        JTextArea aboutText = new JTextArea(
            "This game is designed to test your knowledge about Zambia.\n" +
            "You will be presented with questions from different categories including:\n" +
            "Culture, History, Geography, General Knowledge, and Politics.\n" +
            "You have 10 minutes to answer all questions. Good luck!"
        );
        aboutText.setFont(new Font("Serif", Font.PLAIN, 18));
        aboutText.setEditable(false);
        aboutText.setLineWrap(true);
        aboutText.setWrapStyleWord(true);
        add(aboutText, BorderLayout.CENTER);

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Serif", Font.BOLD, 20));
        backButton.addActionListener(e -> {
            parentFrame.remove(AboutPage.this);
            WelcomePage welcomePage = new WelcomePage(parentFrame);
            parentFrame.add(welcomePage);
            parentFrame.revalidate();
            parentFrame.repaint();
        });
        add(backButton, BorderLayout.SOUTH);
    }
}
