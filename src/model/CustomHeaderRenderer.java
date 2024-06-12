package model;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class CustomHeaderRenderer extends DefaultTableCellRenderer {
    public CustomHeaderRenderer() {
        setHorizontalAlignment(SwingConstants.CENTER);
        setBackground(new Color(240, 240, 240));
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {
        JComponent c = (JComponent) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);


        // Adiciona uma borda na célula do cabeçalho para exibir a linha de divisão entre as colunas
        Border border = BorderFactory.createMatteBorder(0, 0, 1, 1, Color.BLACK); // Adiciona uma linha na parte inferior e à direita
        c.setBorder(border);
        c.setPreferredSize(new Dimension(c.getPreferredSize().width, 30));

        return c;
    }
}
