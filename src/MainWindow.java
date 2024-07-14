import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends HomeWindow implements ActionListener {
    String greeting = "Hello, welcome to Zambia Trivia Quiz Game";
    JLabel greetingLabel = new JLabel(greeting);
    JPanel greetingBox = new JPanel(new BorderLayout());
    JButton infoButton = new JButton("?");
    JPanel infoPanel = new JPanel(new BorderLayout());
    JPanel controlsPanel = new JPanel();


    public MainWindow(){
        super("Home");
        //add the greeting text into the center box using the greeting box
        greetingBox.add(greetingLabel);
        greetingBox.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        greetingBox.setPreferredSize(new Dimension(400,250));
        //
        mainBox.add(greetingBox, BorderLayout.CENTER);
        //add action listener to the info button
        infoButton.addActionListener(this);
        //add the info button to the control panel
        infoPanel.add(infoButton, BorderLayout.WEST);
        bottomControlBox.add(infoPanel, BorderLayout.CENTER);
        controlsPanel.setPreferredSize(new Dimension(1000,20));
        bottomControlBox.add(controlsPanel, BorderLayout.CENTER);



    }

    //HOME WINDOW
    private void createHomePanel() {

    }

    /**
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == infoButton) {
            InformationFrame window = new InformationFrame();
            this.toBack();
        } else if (e.getSource() == infoPanel) {
            JOptionPane.showMessageDialog(null,"Wow!!");
        }

    }
}
