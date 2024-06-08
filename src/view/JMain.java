package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JMain extends JFrame {
    private JLabel titleLabel;
    private JPanel MainPanel;
    private JButton portariaButton;
    private JButton dpButton;
    private JButton almoxarifadoButton;
    private JButton btnFechar;


    public JMain() {
        setContentPane(MainPanel);
        setTitle("Gestão Empresarial");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(700, 500);
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

                dispose();
                JDepartamentoPessoal dp = new JDepartamentoPessoal();
                dp.setLocationRelativeTo(dp);
            }
        });
        almoxarifadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(JMain.this, "Almoxarifado");
            }
        });
        btnFechar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        UIManager.put("Button.focus", UIManager.get("Button.background"));

        SwingUtilities.invokeLater(() ->  new JMain());
    }

}
