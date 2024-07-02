package com.partials;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class cTable extends JTable {
    public cTable(javax.swing.table.TableModel dm) {
        super(dm);
        setFont(cFonts.TEXTFIELD_FONT);
        getTableHeader().setFont(cFonts.HEADER_TABLE_FONT);
        getTableHeader().setBackground(cColor.GREEN);
        getTableHeader().setForeground(cColor.WHITE);
        getTableHeader().setBorder(new javax.swing.border.LineBorder(cColor.WHITE, 1));
        setBorder(new javax.swing.border.LineBorder(cColor.WHITE, 1));
        setRowHeight(30);
        getTableHeader().setReorderingAllowed(false);
        setShowVerticalLines(false);
        setShowHorizontalLines(false);
        setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        setDragEnabled(true);
        setSelectionBackground(cColor.GREY);
        setSelectionForeground(cColor.BLACK);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        for (int i = 0; i < getColumnCount(); i++) {
            getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 4f0345e24e04e01974af5794c62b485d89140340
