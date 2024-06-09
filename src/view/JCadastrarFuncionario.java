package view;

import DAO.CadastroFuncionarioDAO;
import main.java.empresa.departamento_pessoal.Cadastro;
import main.java.empresa.departamento_pessoal.Funcionario;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;

public class JCadastrarFuncionario extends JFrame {
    private JPanel CadastarPanel;
    private JButton btnVoltar;
    private JTextField admissaoField;
    private JFormattedTextField telefoneField;
    private JTextField nascimentoField;
    private JTextField nomeField;
    private JTextField departamentoField;
    private JTextField matriculaField;
    private JFormattedTextField cpfField;
    private JTextField cargoField;
    private JTextField salarioField;
    private JTextField enderecoField;
    private JButton btnCadastrar;

    private int matricula;
    private String nome;
    private String cpf;
    private String departamento;
    private String cargo;
    private String nascimento;
    private double salario;
    private String telefone;
    private String endereco;


    public JCadastrarFuncionario() {
        setContentPane(CadastarPanel);
        setTitle("Cadastro de Funcionário");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 500);
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

        telefoneField.setFormatterFactory(new DefaultFormatterFactory(mascararTelefone));
        cpfField.setFormatterFactory(new DefaultFormatterFactory(mascararCPF));


        try {
            mascararCPF = new MaskFormatter("###.###.###-##");
            mascararCPF.setPlaceholderCharacter('_');
        } catch (ParseException ecpf) {
            ecpf.printStackTrace();
        }
        admissaoField.setText(LocalDate.now().toString());
        matriculaField.setText("500");
        nomeField.setText("Teste");
        cpfField.setText("02970248174");
        departamentoField.setText("Operacional");
        cargoField.setText("Porteiro");
        nascimentoField.setText("24-06-09");
        salarioField.setText("5000");
        telefoneField.setText("61998354398");
        enderecoField.setText("Sol Nascente");


        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String matriculaText = matriculaField.getText();
                nome = nomeField.getText();
                cpf = cpfField.getText();
                departamento = departamentoField.getText();
                cargo = cargoField.getText();
                nascimento = nascimentoField.getText();
                String salarioText = salarioField.getText();
                telefone = telefoneField.getText();
                endereco = enderecoField.getText();

                try {
                    matricula = Integer.parseInt(matriculaText);
                } catch (NumberFormatException emat) {
                    JOptionPane.showMessageDialog(
                            CadastarPanel,
                            "Matrícula inválida. Favor insira apenas números!",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                    matriculaField.requestFocus();
                    return;
                }

                //cadastrando novo funcionário
                Cadastro novo = Cadastro.getInstance();
                novo.adicionarFuncionario(nome, cpf, departamento, cargo, nascimento, salario, telefone, endereco);
                Funcionario ultimoRegistro = novo.listaFuncionario().iterator().next();
                new CadastroFuncionarioDAO().cadastrarFuncionario(ultimoRegistro);

                SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(
                        CadastarPanel,
                        "Registro Cadastrado com sucesso!",
                        "Sucesso", JOptionPane.INFORMATION_MESSAGE));

            }
        });

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
