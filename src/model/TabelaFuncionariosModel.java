package model;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumnModel;
import java.util.List;

public class TabelaFuncionariosModel extends AbstractTableModel {
    private static final String[] colunas = {
            "ORDEM", "ADMISSAO", "MATRICULA", "NOME", "CPF", "DEPARTAMENTO", "CARGO", "NASCIMENTO", "SALARIO",
            "TELEFONE", "ENDERECO"
    };
    private List<FuncionarioModel> funcionarios;

    public TabelaFuncionariosModel(List<FuncionarioModel> funcionarios) {
        this.funcionarios = funcionarios;
    }

    @Override
    public int getRowCount() {
        return funcionarios.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        FuncionarioModel funcionario = funcionarios.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return rowIndex + 1;
            case 1:
                return funcionario.getAdmissao();
            case 2:
                return funcionario.getMatricula();
            case 3:
                return funcionario.getNome();
            case 4:
                return funcionario.getCpf();
            case 5:
                return funcionario.getDepartamento();
            case 6:
                return funcionario.getCargo();
            case 7:
                return funcionario.getDataNascimento();
            case 8:
                return funcionario.getSalario();
            case 9:
                return funcionario.getTelefone();
            case 10:
                return funcionario.getEndereco();
            default:
                return null;
        }
    }

    public void configurarTamanhoColunas(JTable table) {
        TableColumnModel columnModel = table.getColumnModel();

        columnModel.getColumn(0).setPreferredWidth(30);

        CustomTableCellRenderer renderer = new CustomTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            if(i ==3){
                continue;
            }
            columnModel.getColumn(i).setCellRenderer(renderer);
        }
    }
    @Override
    public String getColumnName(int column){
        return colunas[column];
    }

}
