package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JDepartamentoPessoal extends JFrame {

    private JPanel DPPanel;
    private JButton btnVoltar;
    private JButton btnFechar;
    private JButton btnCadastrarFuncionario;
    private JButton btnCadastrarCargo;
    private JButton btnListarFuncionarios;
    private JButton btnListarCargos;

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
        btnCadastrarFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCadastrarFuncionario jCadastrarFuncionario = new JCadastrarFuncionario();
                jCadastrarFuncionario.setLocationRelativeTo(jCadastrarFuncionario);

            }
        });
        btnCadastrarCargo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCadastrarCargo jCadastrarCargo = new JCadastrarCargo();
                jCadastrarCargo.setLocationRelativeTo(jCadastrarCargo);
            }
        });
        btnListarFuncionarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JListaFuncionarios jListaFuncionarios = new JListaFuncionarios();
                jListaFuncionarios.setLocationRelativeTo(jListaFuncionarios);
            }
        });

        btnListarCargos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JListaCargos jListaCargos = new JListaCargos();
                jListaCargos.setLocationRelativeTo(jListaCargos);
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
