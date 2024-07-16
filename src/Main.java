import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        //HomeWindow window = new HomeWindow("Home");
        SwingUtilities.invokeLater(MainWindow::new);
    }
}