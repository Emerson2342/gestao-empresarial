import javax.swing.*;

public class JPortaria extends JFrame {

    private JPanel PortariaPanel;
    private JTextField textField1;
    private JLabel label1;

    public JPortaria() {
        setContentPane(PortariaPanel);
        setTitle("Portaria");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new JPortaria();
    }
}
