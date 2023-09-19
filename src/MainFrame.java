import javax.swing.*;

public class MainFrame extends JFrame {
    public MainFrame(){
//        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.add(new MainPanel());
        this.pack();
        this.setVisible(true);
    }
}
