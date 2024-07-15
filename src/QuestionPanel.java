import javax.swing.*;
import java.awt.*;

public class QuestionPanel extends JPanel {
    public QuestionPanel(String question, String[] options) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel questionLabel = new JLabel(question);
        questionLabel.setFont(new Font("Serif", Font.BOLD, 20));
        add(questionLabel);

        ButtonGroup group = new ButtonGroup();
        for (String option : options) {
            JRadioButton radioButton = new JRadioButton(option);
            radioButton.setFont(new Font("Serif", Font.PLAIN, 18));
            group.add(radioButton);
            add(radioButton);
        }
    }
}
