package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JDepartamentoPessoal extends JFrame {

    private JPanel DPPanel;
    private JButton btnVoltar;
    private JButton btnFechar;
    private JButton btnCadastrar;

    public JDepartamentoPessoal() {
        setContentPane(DPPanel);
        setTitle("Departamento Pessoal");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);


        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                JMain jMain = new JMain();
                jMain.setLocationRelativeTo(jMain);
            }
        });
        btnFechar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCadastrarFuncionario jCadastrarFuncionario = new JCadastrarFuncionario();
                jCadastrarFuncionario.setLocationRelativeTo(jCadastrarFuncionario);

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

        SwingUtilities.invokeLater(() -> new JDepartamentoPessoal());
    }


}
