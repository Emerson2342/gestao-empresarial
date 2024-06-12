package view;

import DAO.CargoDAO;
import model.CargoModel;
import model.CustomHeaderRenderer;
import model.LinhaListradas;
import model.TabelaCargoModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class JListaCargos extends JFrame {
    private JPanel ListaCargoPanel;
    private JTable table;
    private JButton btnFechar;

    public JListaCargos(){
        setTitle("Lista de Cargos");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        ListaCargoPanel = new JPanel(new BorderLayout());
        setContentPane(ListaCargoPanel);

        List<CargoModel> cargos = new CargoDAO().listarCargos();

        TabelaCargoModel tabelaCargoModel = new TabelaCargoModel(cargos);
        table = new JTable(tabelaCargoModel);

        DefaultTableCellRenderer headerRenderer = new CustomHeaderRenderer();
        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        table.setDefaultRenderer(Object.class, new LinhaListradas());
        tabelaCargoModel.configurarTamanhoColunas(table);

        JScrollPane ScrollPane = new JScrollPane(table);

        ListaCargoPanel.add(ScrollPane);

        ListaCargoPanel.setBorder(new EmptyBorder(25,15,55,15));

        setVisible(true);
        table.setModel(tabelaCargoModel);

        btnFechar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        ListaCargoPanel.add(btnFechar, BorderLayout.PAGE_END);
        btnFechar.setPreferredSize(new Dimension(0,50));
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
        SwingUtilities.invokeLater(() -> new JListaCargos());
    }

}
