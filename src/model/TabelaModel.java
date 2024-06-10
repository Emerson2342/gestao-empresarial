package model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TabelaModel extends AbstractTableModel {
    private static final String[] colunas = {
            "ID", "Matricula", "Nome", "CPF","TELEFONE", "Entrada", "Saida"
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
