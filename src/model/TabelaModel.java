package model;

import java.awt.*;
import java.util.List;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

public class TabelaModel extends AbstractTableModel {
    private static final String[] colunas = {
            "ID", "Matricula", "Nome", "CPF", "TELEFONE", "Entrada", "Saida"
    };

    private List<VisitanteModel> visitantes;


    public TabelaModel(List<VisitanteModel> visitantes) {
        this.visitantes = visitantes;
    }

    @Override
    public int getRowCount() {
        return visitantes.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    public void configurarTamanhoColunas(JTable table) {
        TableColumnModel columnModel = table.getColumnModel();

        columnModel.getColumn(0).setPreferredWidth(50); // ID
        columnModel.getColumn(1).setPreferredWidth(100); // Matricula
        columnModel.getColumn(2).setPreferredWidth(150); // Nome
        columnModel.getColumn(3).setPreferredWidth(100); // CPF
        columnModel.getColumn(4).setPreferredWidth(150); // Telefone
        columnModel.getColumn(5).setPreferredWidth(100); // Entrada
        columnModel.getColumn(6).setPreferredWidth(100); // Saida

        CustomTableCellRenderer renderer = new CustomTableCellRenderer();

        renderer.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            if (i == 2) {
                continue;
            }
            columnModel.getColumn(i).setCellRenderer(renderer);
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        VisitanteModel visitante = visitantes.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return rowIndex + 1;
            case 1:
                return visitante.getMatricula();
            case 2:
                return visitante.getNome();
            case 3:
                return visitante.getCpf();
            case 4:
                return visitante.getTelefone();
            case 5:
                return visitante.getEntrada();
            case 6:
                return visitante.getSaida();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

}
