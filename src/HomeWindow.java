import javax.swing.*;
import java.awt.*;

public class HomeWindow extends JFrame {
    protected JPanel mainBox = new JPanel(new CardLayout());
    protected JPanel sidePanel = new JPanel(); // left side to have the info button
    protected JPanel rightSidePanel = new JPanel();
    protected JPanel rightSpace = new JPanel();
    protected JPanel timerContainer = new JPanel();
    protected JPanel topNavBar = new JPanel(new BorderLayout()); // navigation bar to contain the timer
    protected JPanel bottomControlBox = new JPanel(new BorderLayout()); // to contain the control
    protected String pageName;  // name of the current page being accessed
    protected JPanel leftCorner = new JPanel();
    protected JPanel leftSpace = new JPanel();
    protected JPanel cornerButtonContainer = new JPanel(new CardLayout());
    //center controls container
    protected JPanel centerContainer = new JPanel();







    public HomeWindow(String pageName) {
        // Initialize the mainFrame and its attributes
        this.pageName = pageName;
        setTitle(this.pageName + " - Zambia Trivia");
        setSize(1200, 600);
        setLayout(new BorderLayout());
        setFont(new Font("Serif",Font.PLAIN,20));

        //add the timer container
        rightSpace.setPreferredSize(new Dimension(200, 40));
        topNavBar.add(rightSpace, BorderLayout.EAST);
        topNavBar.add(timerContainer, BorderLayout.CENTER);

        // Add the top navigation bar
        add(topNavBar, BorderLayout.NORTH);
        topNavBar.setPreferredSize(new Dimension(1200, 80));

        //add the corner panel to contain the info button
        bottomControlBox.add(leftCorner, BorderLayout.WEST);
        leftSpace.setPreferredSize(new Dimension(40,20));
        leftCorner.setLayout(new BoxLayout(leftCorner, BoxLayout.X_AXIS));
        leftCorner.add(leftSpace);
        cornerButtonContainer.setMaximumSize(new Dimension(100,20));
        leftCorner.add(cornerButtonContainer);

        //add center panel to the bottom panel
        centerContainer.setLayout(new BoxLayout(centerContainer, BoxLayout.X_AXIS));
        bottomControlBox.add(centerContainer);

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

    public void setPageName(String pageName) {
        this.pageName = pageName;
        setTitle(pageName + " - Zambia Trivia");
    }
}
