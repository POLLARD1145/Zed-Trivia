import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Objects;

public class MainWindow extends HomeWindow implements ActionListener {
    CardLayout cardLayout = (CardLayout) mainBox.getLayout();
    Timer timer;
    int timeElapsed = 0;
    JLabel timerLabel = new JLabel("Time: 0s");
    JLabel timeRemainingLabel = new JLabel("Time remaining: 01:45");
    QuestionBank questionBank = new QuestionBank();
    int timeRemaining = 105; // 1 minute and 45 seconds

    public MainWindow() {
        super("Home");

        // Top Navbar
        timerContainer.add(timeRemainingLabel, BorderLayout.EAST);

        // Home Page
        JPanel homePanel = new JPanel(new BorderLayout());
        JLabel greetingLabel = new JLabel("Hello, welcome to Zambia Trivia Quiz Game", JLabel.CENTER);
        homePanel.add(greetingLabel, BorderLayout.CENTER);

        JButton playNowButton = new JButton("Play Now");
        playNowButton.addActionListener(this);
        homePanel.add(playNowButton, BorderLayout.SOUTH);
        mainBox.add(homePanel, "Home");

        // Add the info button to the side panel
        addButtonToBottomControlBox("Info");

        // Initial card display
        cardLayout.show(mainBox, "Home");

        // Initialize the timer
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeElapsed++;
                timerLabel.setText("Time: " + timeElapsed + "s");
            }
        });
    }

    public String formatTime(int seconds) {
        int minutes = seconds / 60;
        int secs = seconds % 60;
        return String.format("%02d:%02d", minutes, secs);
    }

    private void goToInfoPage() {
        setPageName("Information About Game");

        JPanel infoPanel = new JPanel(new BorderLayout());
        JLabel infoLabel = new JLabel("<html><div style='text-align: center; font-family: \"Times New Roman\"; font-size: 14px;'>"
                + "<h2 style='font-size: 18px;'>Zambia Trivia Quiz Game</h2>"
                + "<p>Test your knowledge about Zambia with our exciting trivia quiz game!<br>"
                + "Challenge yourself in different categories:</p>"
                + "<ul style='text-align: left;'>"
                + "<li><b>Geography:</b> Explore the landscapes, cities, and regions of Zambia.</li>"
                + "<li><b>History:</b> Dive into the rich history and cultural heritage of Zambia.</li>"
                + "<li><b>Wildlife:</b> Learn about the diverse wildlife and national parks.</li>"
                + "<li><b>Culture:</b> Discover the traditions, music, and cuisine of Zambia.</li>"
                + "<li><b>Sports:</b> Test your knowledge about famous athletes and sports events.</li>"
                + "</ul>"
                + "</div></html>", JLabel.CENTER);

        infoPanel.add(infoLabel, BorderLayout.CENTER);
        mainBox.add(infoPanel, "Information");

        // Update bottom controls
        cornerButtonContainer.removeAll();
        addButtonToBottomControlBox("< Back");

        cardLayout.show(mainBox, "Information");
        infoPanel.revalidate();
        infoPanel.repaint();
    }

    public void goToCategoryPage() {
        setPageName("Select a Category");

        JPanel categoryPanel = new JPanel(new BorderLayout());
        JLabel categoryLabel = new JLabel("<html><h2>Select a Category</h2></html>", JLabel.CENTER);
        categoryPanel.add(categoryLabel, BorderLayout.NORTH);

        JPanel categories = new JPanel();
        categories.setLayout(new BoxLayout(categories, BoxLayout.Y_AXIS));

        String[] categoryNames = {"Geography", "History", "Economy", "Wildlife", "Culture", "Sports"};
        for (String name : categoryNames) {
            JButton categoryButton = new JButton(name);
            categoryButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            categoryButton.addActionListener(this);
            categories.add(categoryButton);
            categories.add(Box.createRigidArea(new Dimension(0, 10))); // Add some space between buttons
        }

        categoryPanel.add(categories, BorderLayout.CENTER);
        mainBox.add(categoryPanel, "Category");

        // Update bottom controls
        cornerButtonContainer.removeAll();
        addButtonToBottomControlBox("< Back");

        cardLayout.show(mainBox, "Category");
        categoryPanel.revalidate();
        categoryPanel.repaint();
    }

    private void displayQuestionWindow(String category, List<Question> questions) {
        this.cornerButtonContainer.removeAll();
        setPageName(category + " Questions");

        QuestionWindow questionWindow = new QuestionWindow(category, questions, timeRemainingLabel, this);
        mainBox.add(questionWindow, "Question");

        // Update top navbar and start timer
        timerContainer.removeAll();
        timerContainer.add(timeRemainingLabel, BorderLayout.EAST);
        timer.start();

        // Remove the back button from the bottom controls
        cornerButtonContainer.removeAll();
        cornerButtonContainer.revalidate();
        cornerButtonContainer.repaint();

        // Update bottom controls
        bottomControlBox.removeAll();
        questionWindow.addBottomControls();

        cardLayout.show(mainBox, "Question");
        questionWindow.revalidate();
        questionWindow.repaint();
    }

    private void addButtonToBottomControlBox(String buttonText) {
        JButton button = new JButton(buttonText);
        button.addActionListener(this);
        cornerButtonContainer.add(button, BorderLayout.CENTER);
        cornerButtonContainer.revalidate();
        cornerButtonContainer.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonText = ((JButton) e.getSource()).getText();
        if (Objects.equals(buttonText, "Info")) {
            goToInfoPage();
        } else if (Objects.equals(buttonText, "< Back")) {
            setPageName("Home");
            addButtonToBottomControlBox("Info");
            cardLayout.show(mainBox, "Home");
        } else if (Objects.equals(buttonText, "Play Now")) {
            cornerButtonContainer.removeAll();
            timerContainer.removeAll();
            goToCategoryPage();
        } else {
            List<Question> categoryQuestions = questionBank.getQuestions(buttonText);
            displayQuestionWindow(buttonText, categoryQuestions);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainWindow mainWindow = new MainWindow();
            mainWindow.setVisible(true);
        });
    }
}
