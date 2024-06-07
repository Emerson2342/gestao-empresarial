import DAO.PortariaDAO;
import main.java.empresa.portaria.Portaria;
import main.java.empresa.portaria.Visitante;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class JPortaria extends JFrame {

    private JPanel PortariaPanel;
    private JTextField matriculaField;
    private JLabel label1;
    private JTextField nomeField;
    private JLabel nomeLabel;
    private JLabel cpfLabel;
    private JTextField cpfField;
    private JButton buttonRegistrar;
    private JButton buttonConsultar;
    private JButton buttonVoltar;
    private JButton btnRegistrarSaida;
    private JTextField telefoneField;

    private int matricula;
    private String nome;
    private String cpf;
    private String telefone;


    public JPortaria() {
        setContentPane(PortariaPanel);
        setTitle("Portaria");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        buttonRegistrar.setEnabled(false);

        DocumentListener documentListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkFields();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkFields();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkFields();
            }

            private boolean isValidCPF(String cpf){
                return cpf.matches("\\d{11}");
            }

            private void checkFields() {
                boolean allFieldsFilled =
                        !matriculaField.getText().trim().isEmpty()
                        &&
                        !nomeField.getText().trim().isEmpty()
                        &&
                        isValidCPF(cpfField.getText().trim());
                buttonRegistrar.setEnabled(allFieldsFilled);
            }
        };

        matriculaField.getDocument().addDocumentListener(documentListener);
        nomeField.getDocument().addDocumentListener(documentListener);
        cpfField.getDocument().addDocumentListener(documentListener);


        buttonRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String matriculaText = matriculaField.getText();
                String cpf = cpfField.getText();
                nome = nomeField.getText();
                telefone = telefoneField.getText();

                try {
                    matricula = Integer.parseInt(matriculaText);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                            PortariaPanel,
                            "Matrícula inválida. Favor insira apenas números!",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                }
                if (cpf.length() != 11) {
                    JOptionPane.showMessageDialog(
                            PortariaPanel,
                            "CPF inválido. Favor insira apenas números!",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                }
                if (nome == "") {
                    JOptionPane.showMessageDialog(
                            PortariaPanel,
                            "Favor preencher o campo nome!",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                }


                if (matricula > 0 && nome != "" && cpf.length() == 11) {

                    JOptionPane.showMessageDialog(
                            JPortaria.this,
                            "Registro Cadastrado com sucesso!");

                    Portaria novo = Portaria.getInssstance();
                    novo.adicionarVisitante(matricula, nome, cpf,telefone, LocalDateTime.now());
                    novo.listaVisitante();
                    Visitante ultimoRegistro = novo.listaVisitante().iterator().next();

                    new PortariaDAO().resgistrarEntrada(ultimoRegistro);
                    matriculaField.setText("");
                    nomeField.setText(null);
                    cpfField.setText("");
                    telefoneField.setText("");
                }

            }
        });
        buttonConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //dispose();
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
