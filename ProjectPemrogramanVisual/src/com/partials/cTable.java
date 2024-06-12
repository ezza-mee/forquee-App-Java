package com.partials;

import javax.swing.JTable;

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
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

}
