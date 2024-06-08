package view;

import DAO.PortariaDAO;
import main.java.empresa.portaria.Portaria;
import main.java.empresa.portaria.Visitante;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDateTime;

public class JPortaria extends JFrame {

    private JPanel PortariaPanel;
    private JTextField matriculaField;
    private JLabel label1;
    private JTextField nomeField;
    private JLabel nomeLabel;
    private JLabel cpfLabel;
    private JButton buttonRegistrar;
    private JButton buttonConsultar;
    private JButton buttonVoltar;
    private JButton btnRegistrarSaida;
    private JTextField fieldNomeSelecionado;
    private JTextField fieldMatriculaSaida;
    private JButton btnBuscar;
    private JFormattedTextField fieldCPFSelecionado;
    private JFormattedTextField telefoneField;
    private JFormattedTextField cpfField;

    private int matricula;
    private String nome;
    private String cpf;
    private String telefone;

    public JPortaria() {
        setContentPane(PortariaPanel);
        setTitle("Portaria");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);
        setVisible(true);

        MaskFormatter mascararTelefone = null;
        MaskFormatter mascararCPF = null;
        try {
            mascararTelefone = new MaskFormatter("(##)#####-####");
            mascararTelefone.setPlaceholderCharacter('_');
        } catch (ParseException et) {
            et.printStackTrace();
        }

        try {
            mascararCPF = new MaskFormatter("###.###.###-##");
            mascararCPF.setPlaceholderCharacter('_');
        } catch (ParseException ecpf) {
            ecpf.printStackTrace();
        }

        telefoneField.setFormatterFactory(new DefaultFormatterFactory(mascararTelefone));
        cpfField.setFormatterFactory(new DefaultFormatterFactory(mascararCPF));
        fieldCPFSelecionado.setFormatterFactory(new DefaultFormatterFactory(mascararCPF));

        buttonRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String matriculaText = matriculaField.getText();
                cpf = cpfField.getText();
                nome = nomeField.getText();
                telefone = telefoneField.getText();

                if (!validarCampos(matriculaText, cpf, nome, telefone)) {
                    return;
                }

                try {
                    matricula = Integer.parseInt(matriculaText);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                            PortariaPanel,
                            "Matrícula inválida. Favor insira apenas números!",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                    matriculaField.requestFocus();
                    return;
                }

                // Cadastrando novo visitante
                Portaria novo = Portaria.getInssstance();
                novo.adicionarVisitante(matricula, nome, cpf, telefone, LocalDateTime.now());
                Visitante ultimoRegistro = novo.listaVisitante().iterator().next();
                new PortariaDAO().resgistrarEntrada(ultimoRegistro);

                // Limpando os campos
                matriculaField.setText("");
                nomeField.setText("");
                cpfField.setText("");
                telefoneField.setText("");

                SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(
                        JPortaria.this,
                        "Registro Cadastrado com sucesso!"));
            }

            private boolean validarCampos(String matriculaText, String cpf, String nome, String telefone) {
                if (matriculaText.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(
                            PortariaPanel,
                            "Favor preencher o campo matrícula!",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                    matriculaField.requestFocus();
                    return false;
                }

                if (nome.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(
                            PortariaPanel,
                            "Favor preencher o campo nome!",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                    nomeField.requestFocus();
                    return false;
                }

                if (!CPFValido(cpf)) {
                    JOptionPane.showMessageDialog(
                            PortariaPanel,
                            "CPF inválido. Favor insira um CPF válido!",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                    cpfField.requestFocus();
                    return false;
                }

                if (!telefoneValido(telefone)) {
                    JOptionPane.showMessageDialog(
                            PortariaPanel,
                            "Telefone inválido. Favor insira um telefone válido!",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                    telefoneField.requestFocus();
                    return false;
                }

                return true;
            }

            private boolean CPFValido(String cpf) {
                String cpfNumerico = cpf.replaceAll("\\D", "");
                return cpfNumerico.length() == 11;
            }

            private boolean telefoneValido(String telefone) {
                String numTelefone = telefone.replaceAll("\\D", "");
                return numTelefone.length() == 11;
            }
        });

        buttonConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // dispose();
                JRegistroPortaria jRegistroPortaria = new JRegistroPortaria();
                jRegistroPortaria.setLocationRelativeTo(null);
            }
        });

        buttonVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                JMain jMain = new JMain();
                jMain.setLocationRelativeTo(null);
            }
        });

        btnRegistrarSaida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int matriculaSaida = Integer.parseInt(fieldMatriculaSaida.getText());
                    boolean atualizado = new PortariaDAO().registrarSaida(matriculaSaida);

                    if (atualizado) {
                        JOptionPane.showMessageDialog(
                                PortariaPanel,
                                "Saída atualizado com sucesso!",
                                "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                        fieldMatriculaSaida.setText("");
                        fieldNomeSelecionado.setText("");
                        fieldCPFSelecionado.setText("");

                    } else {
                        JOptionPane.showMessageDialog(
                                PortariaPanel,
                                "Falha ao atualizar saída!",
                                "Erro", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (NumberFormatException error) {
                    JOptionPane.showMessageDialog(
                            PortariaPanel,
                            "Matrícula inválida. Favor insira apenas números!",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int matriculaSaida = Integer.parseInt(fieldMatriculaSaida.getText());
                    Visitante selecionado = new PortariaDAO().selecionarVisitante(matriculaSaida);

                    if (selecionado != null) {
                        if (selecionado.getSaida() != null) {
                            System.out.println(selecionado.getSaida());
                            JOptionPane.showMessageDialog(
                                    PortariaPanel,
                                    "Não existe entrada em aberto para esta Matrícula!",
                                    "Erro", JOptionPane.WARNING_MESSAGE);
                        } else {
                            fieldNomeSelecionado.setText(selecionado.getNome());
                            fieldCPFSelecionado.setText(selecionado.getCpf());
                        }
                    } else {
                        JOptionPane.showMessageDialog(
                                PortariaPanel,
                                "Matrícula Inválida!",
                                "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(
                            PortariaPanel,
                            "Matrícula inválida. Favor confira a matrícula!",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                }
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
        SwingUtilities.invokeLater(() -> new JPortaria());
    }
}
