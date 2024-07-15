import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class QuestionWindow extends JPanel {
    private List<Question> questions;
    private int currentQuestionIndex = 0;
    private JLabel questionLabel;
    private JRadioButton[] optionButtons;
    private ButtonGroup optionGroup;
    private int score = 0;

    public QuestionWindow(String category, List<Question> questions) {
        this.questions = questions;
        setLayout(new BorderLayout());

        // Main content with question and options
        JPanel mainBox = new JPanel();
        mainBox.setLayout(new BoxLayout(mainBox, BoxLayout.Y_AXIS));
        questionLabel = new JLabel();
        mainBox.add(questionLabel);

        optionButtons = new JRadioButton[4];
        optionGroup = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new JRadioButton();
            optionGroup.add(optionButtons[i]);
            mainBox.add(optionButtons[i]);
        }
        add(mainBox, BorderLayout.CENTER);

        // Display the first question
        if (!questions.isEmpty()) {
            displayQuestion();
        }
    }

    private void displayQuestion() {
        Question currentQuestion = questions.get(currentQuestionIndex);
        questionLabel.setText(currentQuestion.getQuestion());
        String[] options = currentQuestion.getOptions();
        for (int i = 0; i < options.length; i++) {
            optionButtons[i].setText(options[i]);
        }
        optionGroup.clearSelection();
    }

    private void checkAnswer() {
        Question currentQuestion = questions.get(currentQuestionIndex);
        for (JRadioButton button : optionButtons) {
            if (button.isSelected() && button.getText().equals(currentQuestion.getAnswer())) {
                score++;
                break;
            }
        }
    }

    public void addBottomControls(JPanel bottomControlBox) {
        JButton prevButton = new JButton("< Prev");
        JButton pauseButton = new JButton("||");
        JButton nextButton = new JButton("Next >");

        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentQuestionIndex > 0) {
                    currentQuestionIndex--;
                    displayQuestion();
                }
            }
        });

        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Timer timer = ((MainWindow) SwingUtilities.getWindowAncestor(QuestionWindow.this)).timer;
                if (timer.isRunning()) {
                    timer.stop();
                    pauseButton.setText("||");
                } else {
                    timer.start();
                    pauseButton.setText("I>");
                }
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
                currentQuestionIndex++;
                if (currentQuestionIndex < questions.size()) {
                    displayQuestion();
                } else {
                    displayScore();
                }
            }
        });

        bottomControlBox.setLayout(new FlowLayout());
        bottomControlBox.add(prevButton);
        bottomControlBox.add(pauseButton);
        bottomControlBox.add(nextButton);
        bottomControlBox.revalidate();
        bottomControlBox.repaint();
    }

    private void displayScore() {
        removeAll();
        JLabel scoreLabel = new JLabel("Your score: " + score + "/" + questions.size(), JLabel.CENTER);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(scoreLabel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
}
