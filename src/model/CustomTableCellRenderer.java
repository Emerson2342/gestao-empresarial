package model;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class CustomTableCellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);


        setHorizontalAlignment(SwingConstants.CENTER);

        if (row % 2 == 0) {
            cellComponent.setBackground(Color.WHITE);
        } else {
            cellComponent. setBackground(new Color(240, 240, 240));
        }
        if (isSelected) {
            cellComponent.setBackground(new Color(50,124,228));
        }

        return cellComponent;
    }
}
