package view;

import DAO.FuncionarioDAO;
import model.FuncionarioModel;
import model.LinhaListradas;
import model.TabelaFuncionariosModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class JListaFuncionarios extends JFrame {
    private JPanel ListaFuncionariosPanel;
    private JTable table;
    private JButton btnFechar;

    public JListaFuncionarios() {
        setTitle("Lista de Funcionários");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1300, 700);
        setLocationRelativeTo(null);

        ListaFuncionariosPanel = new JPanel(new BorderLayout());
        setContentPane(ListaFuncionariosPanel);


        List<FuncionarioModel> funcionarios = new FuncionarioDAO().listarFuncionarios();

        TabelaFuncionariosModel tabelaFuncionariosModel = new TabelaFuncionariosModel(funcionarios);

        table = new JTable(tabelaFuncionariosModel);

        table.setDefaultRenderer(Object.class, new LinhaListradas());

        JScrollPane scrollPane = new JScrollPane(table);

        ListaFuncionariosPanel.add(scrollPane);

        ListaFuncionariosPanel.setBorder(new EmptyBorder(25, 15, 55, 15));

        setVisible(true);
        table.setModel(tabelaFuncionariosModel);


        btnFechar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        ListaFuncionariosPanel.add(btnFechar, BorderLayout.PAGE_END);
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
        SwingUtilities.invokeLater(() -> new JListaFuncionarios());
    }

}
