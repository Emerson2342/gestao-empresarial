import DAO.PortariaDAO;
import main.java.empresa.portaria.Visitante;
import model.ModeloTabela;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class JRegistroPortaria extends JFrame {
    private JPanel RegistroPortaria;
    private JTable table;
    private JButton buttonFechar;

    public JRegistroPortaria() {
        setTitle("Registro de Portaria");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);


        RegistroPortaria = new JPanel(new BorderLayout());
        setContentPane(RegistroPortaria);

        //cria a lista vindo do banco de dados
        List<Visitante> visitantes = new PortariaDAO().listarVisitantes();
        //instancia o model da tabela
        ModeloTabela modeloTabela = new ModeloTabela(visitantes);

        //cria a tabela com o modelo
        table = new JTable(modeloTabela);
        //adiciona a tabela no JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);

        //adicionar o JScrollPane ao RegistroPortaria
        RegistroPortaria.add(scrollPane, BorderLayout.CENTER);

        RegistroPortaria.setBorder(new EmptyBorder(25, 15, 55, 15));

        setVisible(true);
        //table.setModel(modeloTabela);
        buttonFechar = new JButton("Voltar");
        buttonFechar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        RegistroPortaria.add(buttonFechar, BorderLayout.SOUTH);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JRegistroPortaria());


    }

}
