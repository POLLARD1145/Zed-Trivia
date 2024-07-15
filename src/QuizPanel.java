import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class QuizPanel extends JPanel {
    private JFrame parentFrame;
    private JLabel timerLabel;
    private Timer timer;
    private int timeRemaining = 600; // 10 minutes for the quiz
    private String category;
    private int currentQuestionIndex = 0;
    private List<Question> questions;
    private JLabel questionLabel;
    private ButtonGroup optionGroup;
    private JPanel optionPanel;

    public QuizPanel(JFrame frame, String category) {
        this.parentFrame = frame;
        this.category = category;
        this.questions = getQuestionsForCategory(category); // Get questions based on category

        setLayout(new BorderLayout());

        JLabel categoryLabel = new JLabel("Category: " + category, JLabel.CENTER);
        categoryLabel.setFont(new Font("Serif", Font.BOLD, 24));
        add(categoryLabel, BorderLayout.NORTH);

        timerLabel = new JLabel("Time Remaining: 10:00", JLabel.CENTER);
        timerLabel.setFont(new Font("Serif", Font.BOLD, 20));
        add(timerLabel, BorderLayout.SOUTH);

        JPanel questionPanel = new JPanel();
        questionPanel.setLayout(new BorderLayout());

        questionLabel = new JLabel("", JLabel.CENTER);
        questionLabel.setFont(new Font("Serif", Font.BOLD, 20));
        questionPanel.add(questionLabel, BorderLayout.NORTH);

        optionPanel = new JPanel();
        optionPanel.setLayout(new GridLayout(0, 1));
        questionPanel.add(optionPanel, BorderLayout.CENTER);

        add(questionPanel, BorderLayout.CENTER);

        startTimer();
        displayNextQuestion();
    }

    private void displayNextQuestion() {
        if (currentQuestionIndex < questions.size()) {
            Question question = questions.get(currentQuestionIndex);
            questionLabel.setText(question.getQuestion());
            optionPanel.removeAll();
            optionGroup = new ButtonGroup();
            for (String option : question.getOptions()) {
                JRadioButton radioButton = new JRadioButton(option);
                radioButton.setFont(new Font("Serif", Font.PLAIN, 18));
                radioButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        currentQuestionIndex++;
                        displayNextQuestion();
                    }
                });
                optionGroup.add(radioButton);
                optionPanel.add(radioButton);
            }
            optionPanel.revalidate();
            optionPanel.repaint();
        } else {
            // Handle end of quiz
            JOptionPane.showMessageDialog(parentFrame, "Quiz Completed!");
            // You can add more actions here, like showing the score or returning to the main menu
        }
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

    private List<Question> getQuestionsForCategory(String category) {

        return List.of(
                new Question("What is the capital of Zambia?", new String[]{"Lusaka", "Kitwe", "Ndola", "Livingstone"}),
                new Question("Who is the current President of Zambia?", new String[]{"Edgar Lungu", "Hakainde Hichilema", "Levy Mwanawasa", "Michael Sata"}),
                new Question("Who was the first female Vice President of Zambia?", new String[]{"Inonge Wina", "Edith Nawakwi", "Mutale Nalumango", "Sylvia Masebo"}),
                new Question("Which document serves as the supreme law of Zambia?", new String[]{"The Constitution", "The Bill Of Rights", "The Penal Code", "The Civil Code"}),
                new Question("What is the term length for the President of Zambia?", new String[]{"4 years", "5 years", "6 years", "7 years"}),
                new Question("Which political party won the 2021 general elections in Zambia?", new String[]{"Patriotic Front (PF)", "Movement for Multi-party Democracy (MMD)", " United Party for National Development (UPND)", "Forum for Democracy and Development (FDD)"}),
                new Question("What is the highest court in Zambia's judicial system?", new String[]{" High Court", "Constitutional Court", "Supreme Court", " Court of Appeal"}),
                new Question("Who was Zambia’s first President?", new String[]{"Michael Sata", "Levy Mwanawasa", "Kenneth Kaunda", "Frederick Chiluba"}),
                new Question("In which year did Zambia gain independence from British colonial rule?", new String[]{"1960", "1964", "1970", "1980"}),
                new Question("What is the legislative body of Zambia called?", new String[]{"The National Assembly", " The House of Commons", "The Senate", "The Parliament"})

        );
    }
}
