package view;

import DAO.PortariaDAO;
import model.CustomHeaderRenderer;
import model.VisitanteModel;
import model.LinhaListradas;
import model.TabelaModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class JRegistroPortaria extends JFrame {
    private JPanel RegistroPortaria;
    private JTable table;
    private JButton btnFechar;

    public JRegistroPortaria() {
        setTitle("Registro de Portaria");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);


        RegistroPortaria = new JPanel(new BorderLayout());
        setContentPane(RegistroPortaria);


        //cria a lista vindo do banco de dados
        List<VisitanteModel> visitantes = new PortariaDAO().listarVisitantes();
        //instancia o model da tabela
        TabelaModel tabelaModel = new TabelaModel(visitantes);

        //cria a tabela com o modelo
        table = new JTable(tabelaModel);

        //adiciona formatação customizadas criadas
        DefaultTableCellRenderer headerRenderer = new CustomHeaderRenderer();
        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        //edita as linhas da tabela
        table.setDefaultRenderer(Object.class, new LinhaListradas());

        tabelaModel.configurarTamanhoColunas(table);


        //adiciona a tabela no JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);

        //adicionar o JScrollPane ao RegistroPortaria
        add(scrollPane);
        RegistroPortaria.setBorder(new EmptyBorder(25, 15, 55, 15));

        setVisible(true);
        table.setModel(tabelaModel);


        btnFechar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        RegistroPortaria.add(btnFechar, BorderLayout.PAGE_END);
        btnFechar.setPreferredSize(new Dimension(0, 50));
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
        SwingUtilities.invokeLater(() -> new JRegistroPortaria());
    }


}
