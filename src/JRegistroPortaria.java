import DAO.PortariaDAO;
import main.java.empresa.portaria.Visitante;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class JRegistroPortaria extends JFrame {
    private JPanel RegistroPortaria;
    private JTable table;


    public JRegistroPortaria(List<Visitante> visitantes) {
        setTitle("Registro de Portaria");
        setContentPane(RegistroPortaria);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);

        String[] colunas = {"Matrícula", "Nome", "CPF", "Entrada", "Saída"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0);
        for (Visitante v : visitantes) {
            Object[] row = {
                    v.getMatricula(),
                    v.getNome(),
                    v.getCpf(),
                    v.getEntrada(),
                    v.getSaida()};
            model.addRow(row);
        }
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);


    }

    public static void main(String[] args) {
        List<Visitante> visitantes = new PortariaDAO().listarVisitantes();

        SwingUtilities.invokeLater(() -> new JRegistroPortaria(visitantes));
    }

}
