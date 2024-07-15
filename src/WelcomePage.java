import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePage extends JPanel {
    private JFrame parentFrame;

    public WelcomePage(JFrame frame) {
        this.parentFrame = frame;
        setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("Welcome to the Zambia Quiz Game!", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Serif", Font.BOLD, 32));
        add(welcomeLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton playButton = new JButton("Play Game");
        playButton.setFont(new Font("Serif", Font.BOLD, 20));
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentFrame.remove(WelcomePage.this);
                CategorySelectionPage categorySelectionPage = new CategorySelectionPage(parentFrame);
                parentFrame.add(categorySelectionPage);
                parentFrame.revalidate();
                parentFrame.repaint();
            }
        });
        buttonPanel.add(playButton);

        JButton aboutButton = new JButton("About");
        aboutButton.setFont(new Font("Serif", Font.BOLD, 20));
        aboutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentFrame.remove(WelcomePage.this);
                AboutPage aboutPage = new AboutPage(parentFrame);
                parentFrame.add(aboutPage);
                parentFrame.revalidate();
                parentFrame.repaint();
            }
        });
        buttonPanel.add(aboutButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }
}
