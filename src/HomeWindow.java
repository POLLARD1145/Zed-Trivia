import javax.swing.*;
import java.awt.*;

public class HomeWindow extends JFrame {
    protected JPanel mainBox = new JPanel(new CardLayout());
    protected JPanel sidePanel = new JPanel(); // left side to have the info button
    protected JPanel rightSidePanel = new JPanel();
    protected JPanel topNavBar = new JPanel(new CardLayout()); // navigation bar to contain the timer
    protected JPanel bottomControlBox = new JPanel(new CardLayout()); // to contain the control
    protected String pageName;  // name of the current page being accessed


    public HomeWindow(String pageName) {
        // Initialize the mainFrame and its attributes
        this.pageName = pageName;
        setTitle(this.pageName + " - Zambia Trivia");
        setSize(1200, 600);
        setLayout(new BorderLayout());

        // Add the top navigation bar
        add(topNavBar, BorderLayout.NORTH);
        topNavBar.setPreferredSize(new Dimension(1200, 80));

        // Add the bottom box to contain the controls
        add(bottomControlBox, BorderLayout.SOUTH);
        bottomControlBox.setPreferredSize(new Dimension(1200, 80));

        // Add the left side pane
        add(sidePanel, BorderLayout.WEST);
        sidePanel.setPreferredSize(new Dimension(200, 440));

        // Add the right side pane
        add(rightSidePanel, BorderLayout.EAST);
        rightSidePanel.setPreferredSize(new Dimension(200, 440));

        // Add the main center box
        add(mainBox, BorderLayout.CENTER);
        mainBox.setPreferredSize(new Dimension(800, 440));
        mainBox.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        // End
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Accessor methods for panels
    public JPanel getMainBox() {
        return mainBox;
    }

    public JPanel getSidePanel() {
        return sidePanel;
    }

    public JPanel getRightSidePanel() {
        return rightSidePanel;
    }

    public JPanel getTopNavBar() {
        return topNavBar;
    }

    public JPanel getBottomControlBox() {
        return bottomControlBox;
    }
}
