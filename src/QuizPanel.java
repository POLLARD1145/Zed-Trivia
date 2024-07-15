import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizPanel extends JPanel {
    private JFrame parentFrame;
    private JLabel timerLabel;
    private Timer timer;
    private int timeRemaining = 600; // 10 minutes for the quiz
    private String category;

    public QuizPanel(JFrame frame, String category) {
        this.parentFrame = frame;
        this.category = category;
        setLayout(new BorderLayout());

        JLabel categoryLabel = new JLabel("Category: " + category, JLabel.CENTER);
        categoryLabel.setFont(new Font("Serif", Font.BOLD, 24));
        add(categoryLabel, BorderLayout.NORTH);

        timerLabel = new JLabel("Time Remaining: 10:00", JLabel.CENTER);
        timerLabel.setFont(new Font("Serif", Font.BOLD, 20));
        add(timerLabel, BorderLayout.SOUTH);

        JPanel questionPanel = new JPanel();
        questionPanel.setLayout(new GridLayout(0, 1));

        // Example question
        String question1 = "What is the capital of Zambia?";
        String[] options1 = {"Lusaka", "Kitwe", "Ndola", "Livingstone"};
        questionPanel.add(new QuestionPanel(question1, options1));

        // Add more questions here based on the category...

        add(questionPanel, BorderLayout.CENTER);

        JButton nextButton = new JButton("Next Question");
        nextButton.setFont(new Font("Serif", Font.BOLD, 20));
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle next question
            }
        });
        add(nextButton, BorderLayout.EAST);

        startTimer();
    }

    private void startTimer() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeRemaining--;
                int minutes = timeRemaining / 60;
                int seconds = timeRemaining % 60;
                timerLabel.setText(String.format("Time Remaining: %02d:%02d", minutes, seconds));

                if (timeRemaining <= 0) {
                    timer.stop();
                    JOptionPane.showMessageDialog(parentFrame, "Time's up!");
                    // Handle end of quiz
                }
            }
        });
        timer.start();
    }
}
