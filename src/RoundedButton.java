import javax.swing.*;
import java.awt.*;

class RoundedButton extends JButton {
    private int diameter;

    public RoundedButton(String text, int diameter) {
        super(text);
        this.diameter = diameter;
        setContentAreaFilled(false); // Ensures the background is not filled by default button drawing
        setPreferredSize(new Dimension(diameter, diameter)); // Set the preferred size to ensure the button is circular
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillOval(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getForeground());
        g2.drawOval(0, 0, getWidth() - 1, getHeight() - 1);
        g2.dispose();
    }

    @Override
    public void setContentAreaFilled(boolean b) {
        // No-op to prevent background from being filled by the parent class
    }
}
