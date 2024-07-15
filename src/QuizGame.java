import javax.swing.*;

public class QuizGame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Zambia Quiz Game");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            
            WelcomePage welcomePage = new WelcomePage(frame);
            frame.add(welcomePage);
            
            frame.setVisible(true);
        });
    }
}
