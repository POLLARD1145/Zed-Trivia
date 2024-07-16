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
    private Timer timer;
    private JLabel timeRemainingLabel;
    private JPanel mainQuestionPanel;
    private int timeRemaining = 105; // 1 minute and 45 seconds
    private MainWindow mainWindow;

    public QuestionWindow(String category, List<Question> questions, JLabel timeRemainingLabel, MainWindow mainWindow) {
        this.questions = questions;
        this.timeRemainingLabel = timeRemainingLabel;
        this.mainWindow = mainWindow;
        setLayout(new BorderLayout());

        // Initialize the timer
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeRemaining--;
                timeRemainingLabel.setText("Time remaining: " + mainWindow.formatTime(timeRemaining));
                if (timeRemaining <= 0) {
                    timer.stop();
                    displayScore();
                }
            }
        });
        timer.start();

        // Main content with question and options
        mainQuestionPanel = new JPanel();
        mainQuestionPanel.setLayout(new BoxLayout(mainQuestionPanel, BoxLayout.Y_AXIS));
        questionLabel = new JLabel();
        mainQuestionPanel.add(questionLabel);

        optionButtons = new JRadioButton[4];
        optionGroup = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new JRadioButton();
            optionGroup.add(optionButtons[i]);
            mainQuestionPanel.add(optionButtons[i]);
        }
        add(mainQuestionPanel, BorderLayout.CENTER);

        // Display the first question
        if (!questions.isEmpty()) {
            displayQuestion();
        }

        // Add controls to the bottom
        addBottomControls();
    }

    private void displayQuestion() {
        Question currentQuestion = questions.get(currentQuestionIndex);
        questionLabel.setText((currentQuestionIndex + 1) + ". " + currentQuestion.getQuestion());
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

    public void addBottomControls() {
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
                if (timer.isRunning()) {
                    timer.stop();
                    pauseButton.setText("I>");
                    hideQuestions();
                } else {
                    timer.start();
                    pauseButton.setText("||");
                    showQuestions();
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

        JPanel bottomControls = new JPanel();
        bottomControls.setLayout(new FlowLayout());
        bottomControls.add(prevButton);
        bottomControls.add(pauseButton);
        bottomControls.add(nextButton);

        add(bottomControls, BorderLayout.SOUTH);
    }

    private void hideQuestions() {
        questionLabel.setVisible(false);
        for (JRadioButton button : optionButtons) {
            button.setVisible(false);
        }
    }

    private void showQuestions() {
        questionLabel.setVisible(true);
        for (JRadioButton button : optionButtons) {
            button.setVisible(true);
        }
    }

    private void displayScore() {
        timer.stop(); // Stop the timer
        mainWindow.timer.stop(); // Stop the main window timer
        mainWindow.timerContainer.removeAll(); // Remove the timer label

        removeAll();

        JLabel yourScoreLabel = new JLabel("Your Score", JLabel.CENTER);
        yourScoreLabel.setFont(new Font("Arial", Font.BOLD, 24));
        yourScoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        ScoreCircle scoreCircle = new ScoreCircle(score, questions.size());
        scoreCircle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel timeSpentLabel = new JLabel("Time spent: " + mainWindow.formatTime(mainWindow.timeElapsed), JLabel.CENTER);
        timeSpentLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        timeSpentLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel scorePanel = new JPanel();
        scorePanel.setLayout(new BoxLayout(scorePanel, BoxLayout.Y_AXIS));
        scorePanel.add(Box.createVerticalGlue());
        scorePanel.add(yourScoreLabel);
        scorePanel.add(Box.createRigidArea(new Dimension(0, 10)));
        scorePanel.add(scoreCircle);
        scorePanel.add(Box.createRigidArea(new Dimension(0, 10)));
        scorePanel.add(timeSpentLabel);
        scorePanel.add(Box.createVerticalGlue());

        JButton playAgainButton = new JButton("Play Again");
        JButton seeAnswersButton = new JButton("See Answers");

        playAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Reset the timer
                mainWindow.timeElapsed = 0;
                mainWindow.timerLabel.setText("Time: 0s");

                // Go to categories page
                mainWindow.goToCategoryPage();
            }
        });

        seeAnswersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAnswers();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(playAgainButton);
        buttonPanel.add(seeAnswersButton);
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(scorePanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        revalidate();
        repaint();
    }


    private void displayAnswers() {
        removeAll();
        JButton backButton = new JButton("< Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Navigate to the home page
                mainWindow.setPageName("Home");
                mainWindow.cardLayout.show(mainWindow.mainBox, "Home");
            }
        });

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(backButton, BorderLayout.WEST);
        add(topPanel, BorderLayout.NORTH);

        JPanel answersPanel = new JPanel();
        answersPanel.setLayout(new BoxLayout(answersPanel, BoxLayout.Y_AXIS));
        int counter = 1;
        for (Question question : questions) {
            JLabel questionLabel = new JLabel(counter + ". " + question.getQuestion());
            counter++;
            JLabel answerLabel = new JLabel("   A: " + question.getAnswer());
            questionLabel.setFont(new Font("Serif", Font.BOLD, 20));
            answersPanel.add(questionLabel);
            answersPanel.add(answerLabel);
        }

        JScrollPane scrollPane = new JScrollPane(answersPanel);
        add(scrollPane, BorderLayout.CENTER);

        revalidate();
        repaint();
    }

    // Custom component to draw the score inside a circle
    private static class ScoreCircle extends JComponent {
        private int score;
        private int totalQuestions;

        public ScoreCircle(int score, int totalQuestions) {
            this.score = score;
            this.totalQuestions = totalQuestions;
            setPreferredSize(new Dimension(50, 50)); // Adjust the size here to make the circle smaller
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int diameter = Math.min(getWidth(), getHeight());
            int x = (getWidth() - diameter) / 2;
            int y = (getHeight() - diameter) / 2;

            g2d.setColor(Color.BLUE);
            g2d.fillOval(x, y, diameter, diameter);

            g2d.setColor(Color.WHITE);
            g2d.setFont(new Font("Arial", Font.BOLD, diameter / 3)); // Adjust the font size proportionally
            String scoreText = score + "/" + totalQuestions;
            FontMetrics fm = g2d.getFontMetrics();
            int textWidth = fm.stringWidth(scoreText);
            int textHeight = fm.getAscent();
            g2d.drawString(scoreText, x + (diameter - textWidth) / 2, y + (diameter + textHeight) / 2 - fm.getDescent());
        }
    }
}
