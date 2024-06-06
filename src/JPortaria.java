import DAO.PortariaDAO;
import main.java.empresa.portaria.Portaria;
import main.java.empresa.portaria.Visitante;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.time.LocalDateTime;
import java.util.List;

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

    private int matricula;
    private String nome;
    private String cpf;


    public JPortaria() {
        setContentPane(PortariaPanel);
        setTitle("Portaria");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(510, 400);
        setLocationRelativeTo(null);
        setVisible(true);


        buttonRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String matriculaText = matriculaField.getText();
                String cpf = cpfField.getText();
                nome = nomeField.getText();

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
                    novo.adicionarVisitante(matricula, nome, cpf, LocalDateTime.now());
                    novo.listaVisitante();

                    Visitante ultimoRegistro = novo.listaVisitante().iterator().next();

                    new PortariaDAO().resgistrarEntrada(ultimoRegistro);
                    dispose();
                }

            }
        });
        buttonConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Visitante> visitantes = new PortariaDAO().listarVisitantes();

                JRegistroPortaria jRegistroPortaria = new JRegistroPortaria(visitantes);
                jRegistroPortaria.setLocationRelativeTo(jRegistroPortaria);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JPortaria());


    }

}
