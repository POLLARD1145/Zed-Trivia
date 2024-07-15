import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CategorySelectionPage extends JPanel {
    private JFrame parentFrame;

    public CategorySelectionPage(JFrame frame) {
        this.parentFrame = frame;
        setLayout(new BorderLayout());

        JLabel categoryLabel = new JLabel("Select a Category", JLabel.CENTER);
        categoryLabel.setFont(new Font("Serif", Font.BOLD, 32));
        add(categoryLabel, BorderLayout.NORTH);

        JPanel categoryPanel = new JPanel();
        categoryPanel.setLayout(new GridLayout(5, 1));

        String[] categories = {"Culture", "History", "Geography", "General Knowledge", "Politics"};
        for (String category : categories) {
            JButton categoryButton = new JButton(category);
            categoryButton.setFont(new Font("Serif", Font.BOLD, 20));
            categoryButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    parentFrame.remove(CategorySelectionPage.this);
                    QuizPanel quizPanel = new QuizPanel(parentFrame, category);
                    parentFrame.add(quizPanel);
                    parentFrame.revalidate();
                    parentFrame.repaint();
                }
            });
            categoryPanel.add(categoryButton);
        }

        add(categoryPanel, BorderLayout.CENTER);
    }
}
