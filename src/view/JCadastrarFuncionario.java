package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JCadastrarFuncionario extends JFrame {
    private JPanel CadastarPanel;
    private JButton btnVoltar;
    private JTextField admissaoField;
    private JTextField telefoneField;
    private JTextField nascimentoField;
    private JTextField nomeField;
    private JTextField departamentoField;
    private JTextField matriculaField;
    private JTextField cpfField;
    private JTextField cargoField;
    private JTextField salarioField;
    private JTextField enderecoField;
    private JButton btnCadastrar;

    public JCadastrarFuncionario(){
        setContentPane(CadastarPanel);
        setTitle("Cadastro de Funcionário");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setVisible(true);



        btnVoltar.addActionListener(new ActionListener() {
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

        SwingUtilities.invokeLater(() -> new JCadastrarFuncionario());
    }
}
