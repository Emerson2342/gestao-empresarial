package view;

import DAO.CadastroFuncionarioDAO;
import DAO.CargoDAO;
import main.java.empresa.departamento_pessoal.Cargos;
import model.CargoModel;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class JCadastrarCargo extends JFrame {
    private JPanel JCargoPanel;
    private JFormattedTextField cboField;
    private JFormattedTextField cargoField;
    private JFormattedTextField departamentoField;
    private JButton btnCadastrar;
    private JButton btnVoltar;
    private JFormattedTextField salarioField;

    private String CBO;
    private String cargo;
    private String departamento;
    private String salario;

    public JCadastrarCargo(){
        setContentPane(JCargoPanel);
        setTitle("Cadastrar Cargo");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(350, 400);
        setLocationRelativeTo(null);
        setVisible(true);

        MaskFormatter mascararCBO = null;
        MaskFormatter mascararSalario = null;

        try{
            mascararCBO = new MaskFormatter("####-##");
            mascararCBO.setPlaceholderCharacter('0');
        }catch (ParseException eCBO){
            eCBO.printStackTrace();
        }

        try {
            mascararSalario = new MaskFormatter("R$ #.###,##");
            mascararSalario.setPlaceholderCharacter('0');
        } catch (ParseException eSal) {
            eSal.printStackTrace();
        }
        cboField.setFormatterFactory(new DefaultFormatterFactory(mascararCBO));
        salarioField.setFormatterFactory(new DefaultFormatterFactory(mascararSalario));

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CBO = cboField.getText();
                cargo = cargoField.getText();
                departamento = departamentoField.getText();
                salario = salarioField.getText();


              if(!validarCampos(CBO,cargo, departamento, salario)){
                  return;
              }

              //cadastrando novo cargo
                Cargos novo = Cargos.getInstance();
              novo.adicionarCargo(CBO, departamento, cargo, salario);
                CargoModel ultimoRegistro = novo.listaCargos().iterator().next();
                new CargoDAO().cadastrarCargo(ultimoRegistro);

                SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(
                        JCadastrarCargo.this,
                        "Cargo cadastrado com sucesso!"));

                cboField.setText("");
                cargoField.setText("");
                departamentoField.setText("");
                salarioField.setText("");
                dispose();
            }

            private boolean validarCampos(String cbo, String cargo, String departamento, String salario){
                if(cbo.equals("0000-00")){
                    JOptionPane.showMessageDialog(
                            JCargoPanel,
                            "Favor preencher o CBO!",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                    cboField.requestFocus();
                    return false;
                }

                if(departamento.trim().isBlank()){
                    JOptionPane.showMessageDialog(
                            JCargoPanel,
                            "Favor preencher o campo DEPARTAMENTO!",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                    departamentoField.requestFocus();
                    return false;
                }
                if(cargo.trim().isBlank()){
                    JOptionPane.showMessageDialog(
                            JCargoPanel,
                            "Favor preencher o campo CARGO!",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                    cargoField.requestFocus();
                    return false;
                }
                if(salario.trim().isBlank()){
                    JOptionPane.showMessageDialog(
                            JCargoPanel,
                            "Favor preencher o campo SALÁRIO!",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                    salarioField.requestFocus();
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

        SwingUtilities.invokeLater(() -> new JCadastrarCargo());
    }
}
