package view;

import DAO.FuncionarioDAO;
import DAO.CargoDAO;
import main.java.empresa.departamento_pessoal.Funcionario;
import model.CargoModel;
import model.FuncionarioModel;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;

public class JCadastrarFuncionario extends JFrame {
    private JPanel CadastarPanel;
    private JButton btnVoltar;
    private JFormattedTextField admissaoField;
    private JFormattedTextField telefoneField;
    private JFormattedTextField nascimentoField;
    private JTextField nomeField;

    private JFormattedTextField matriculaField;
    private JFormattedTextField cpfField;
    private JTextField cargoField;
    private JFormattedTextField salarioField;
    private JTextField enderecoField;
    private JButton btnCadastrar;
    private JComboBox<String> comboBox;
    private JTextField departamentoField;
    private JTextField cboField;

    private int matricula;
    private String nome;
    private String cpf;
    private String departamento;
    private String cargo;
    private String nascimento;
    private String salario;
    private String telefone;
    private String endereco;
    private String admissao;


    public JCadastrarFuncionario() {
        setContentPane(CadastarPanel);
        setTitle("Cadastro de Funcionário");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);
        setVisible(true);

        preencherComboBox(comboBox);

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cargoSelecionado = (String) comboBox.getSelectedItem();
                if (cargoSelecionado != null) {
                    atualizarCamposCargo(cargoSelecionado);
                }
            }
        });


        MaskFormatter mascararTelefone = null;
        MaskFormatter mascararCPF = null;
        MaskFormatter mascararData = null;
        MaskFormatter mascararMatricula = null;
        MaskFormatter mascararSalario = null;

        try {
            mascararTelefone = new MaskFormatter("(##)#####-####");
            mascararTelefone.setPlaceholderCharacter('_');
        } catch (ParseException eTel) {
            eTel.printStackTrace();
        }
        try {
            mascararCPF = new MaskFormatter("###.###.###-##");
            mascararCPF.setPlaceholderCharacter('_');
        } catch (ParseException eCpf) {
            eCpf.printStackTrace();
        }
        try {
            mascararData = new MaskFormatter("##/##/####");
            mascararData.setPlaceholderCharacter('_');
        } catch (ParseException eDate) {
            eDate.printStackTrace();
        }
        try {
            mascararSalario = new MaskFormatter("R$ #.###,##");
            mascararSalario.setPlaceholderCharacter('0');
        } catch (ParseException eSal) {
            eSal.printStackTrace();
        }

        try {
            mascararMatricula = new MaskFormatter("#####");
            mascararMatricula.setPlaceholderCharacter('0');
        } catch (ParseException eMat) {
            eMat.printStackTrace();
        }

        telefoneField.setFormatterFactory(new DefaultFormatterFactory(mascararTelefone));
        cpfField.setFormatterFactory(new DefaultFormatterFactory(mascararCPF));
        nascimentoField.setFormatterFactory(new DefaultFormatterFactory(mascararData));
        admissaoField.setFormatterFactory(new DefaultFormatterFactory(mascararData));
        salarioField.setFormatterFactory(new DefaultFormatterFactory(mascararSalario));
        matriculaField.setFormatterFactory(new DefaultFormatterFactory(mascararMatricula));


        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                admissao = admissaoField.getText();
                String matriculaText = matriculaField.getText();
                nome = nomeField.getText();
                cpf = cpfField.getText();
                departamento = departamentoField.getText();
                cargo = (String) comboBox.getSelectedItem(); //pegando o valor selecionado
                nascimento = nascimentoField.getText();
                salario = salarioField.getText();
                telefone = telefoneField.getText();
                endereco = enderecoField.getText();

//                System.out.println("admissão: " + admissao);
//                System.out.println("matricula: " + matriculaText);
//                System.out.println("nome: " + nome);
//                System.out.println("cpf: " + cpf);
//                System.out.println("cargo: " + cargo);
//                System.out.println("nascimento: " + nascimento);
//                System.out.println("telefone: " + telefone);
//                System.out.println("endereço: " + endereco);


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

                if (!validarCampos(admissao, matricula, nome, cpf, cargo, nascimento, endereco)) {
                    return;
                }

                //cadastrando novo funcionário
                Funcionario novo = Funcionario.getInstance();
                novo.adicionarFuncionario(admissao, matricula, nome, cpf, departamento, cargo, nascimento, salario, telefone, endereco);
                FuncionarioModel ultimoRegistro = novo.listaFuncionario().iterator().next();
                new FuncionarioDAO().cadastrarFuncionario(ultimoRegistro);

                System.out.println(cargo);


                SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(
                        CadastarPanel,
                        "Registro Cadastrado com sucesso!",
                        "Sucesso", JOptionPane.INFORMATION_MESSAGE));
                dispose();
            }

            private boolean validarCampos(String admissao, int matricula, String nome, String cpf, String cargo, String nascimento, String endereco) {

                if (admissao.equals("__/__/____")) {
                    JOptionPane.showMessageDialog(
                            CadastarPanel, "Favor preencer o campo ADMISSÃO",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                    admissaoField.requestFocus();
                    return false;
                }
                if (matricula == 00000) {
                    JOptionPane.showMessageDialog(
                            CadastarPanel, "Favor preencer o campo MATRÍCULA",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                    matriculaField.requestFocus();
                    return false;
                }
                if (nome.equals("")) {
                    JOptionPane.showMessageDialog(
                            CadastarPanel, "Favor preencer o campo NOME",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                    nomeField.requestFocus();
                    nomeField.requestFocus();
                    return false;
                }
                if (cpf.equals("___.___.___-__")) {
                    JOptionPane.showMessageDialog(
                            CadastarPanel, "Favor preencer o campo CPF",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                    cpfField.requestFocus();
                    return false;
                }
                if (cargo.equals("Selecione o Cargo")) {
                    JOptionPane.showMessageDialog(
                            CadastarPanel, "Favor selecionar um CARGO",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                if (nascimento.equals("__/__/____")) {
                    JOptionPane.showMessageDialog(
                            CadastarPanel, "Favor preencer o campo NASCIMENTO",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                    nascimentoField.requestFocus();
                    return false;
                }
                if (telefone.equals("(__)_____-____")) {
                    JOptionPane.showMessageDialog(
                            CadastarPanel, "Favor preencer o campo TELEFONE",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                    telefoneField.requestFocus();
                    return false;
                }
                if (endereco.equals("")) {
                    JOptionPane.showMessageDialog(
                            CadastarPanel, "Favor preencer o campo ENDEREÇO",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                    enderecoField.requestFocus();
                    return false;
                }


                return true;
            }
        });

        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

    }

    private static void preencherComboBox(JComboBox<String> comboBox) {
        CargoDAO dao = new CargoDAO();
        List<String> cargos = dao.buscarCargos(); // Busque todos os cargos
        comboBox.addItem("Selecione o Cargo");
        for (String cargo : cargos) {
            comboBox.addItem(cargo);
        }
    }

    private void atualizarCamposCargo(String cargoSelecionado) {
        CargoDAO dao = new CargoDAO();
        CargoModel cargo = dao.selecionarCargo(cargoSelecionado);
        if (cargo != null) {
            cboField.setText(cargo.getCbo());
            departamentoField.setText(cargo.getDepartamento());
            salarioField.setText(cargo.getSalario());
        } else {

            cboField.setText("0000-00");
            departamentoField.setText("");
            salarioField.setText("R$ 0.000,00");
        }
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
