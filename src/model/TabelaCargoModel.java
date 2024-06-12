package model;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumnModel;
import java.util.List;

public class TabelaCargoModel extends AbstractTableModel {
    private List<CargoModel> cargos;

    private static String[] colunas = {
            "ORDEM", "CBO", "CARGO", "DEPARTAMENTO", "SALARIO"
    };

    public TabelaCargoModel(List<CargoModel> cargos) {
        this.cargos = cargos;
    }

    @Override
    public int getRowCount() {
        return cargos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        CargoModel cargo = cargos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return rowIndex + 1;
            case 1:
                return cargo.getCbo();
            case 2:
                return cargo.getCargo();
            case 3:
                return cargo.getDepartamento();
            case 4:
                return cargo.getSalario();
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
            columnModel.getColumn(i).setCellRenderer(renderer);
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
}
