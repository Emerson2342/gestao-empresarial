import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JMain extends JFrame {
    private JLabel titleLabel;
    private JPanel MainPanel;
    private JButton portariaButton;
    private JButton dpButton;
    private JButton almoxarifadoButton;


    public JMain() {
        setContentPane(MainPanel);
        setTitle("Gestão Empresarial");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);
        setVisible(true);


        portariaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // JOptionPane.showMessageDialog(JMain.this, "Portaria");
                dispose();

                JPortaria jportaria = new JPortaria();
                jportaria.setLocationRelativeTo(jportaria);
            }
        });


        dpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(JMain.this, "Departamento Pessoal");
            }
        });
        almoxarifadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(JMain.this, "Almoxarifado");
            }
        });


    }

    public static void main(String[] args) {
        new JMain();
    }

}
