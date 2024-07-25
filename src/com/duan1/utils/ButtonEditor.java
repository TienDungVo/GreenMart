/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duan1.utils;

import static com.duan1.ui.ThanhToanFrame.setTien;
import java.awt.Component;
import java.awt.Point;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dung8
 */
public class ButtonEditor extends DefaultCellEditor {

    protected JButton button;
    private JTable table;

    public ButtonEditor(JCheckBox checkBox, JTable table,int row) {
        super(checkBox);
        this.table = table;
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(e -> {
            DefaultTableModel model= (DefaultTableModel) table.getModel();
            
            
            
            
            int tong = 0;
            
            int rowCount = model.getRowCount();

            for (int i = 0; i < rowCount; i++) {
                int col2Value = (int) model.getValueAt(i, 2);
                int col3Value = (int) model.getValueAt(i, 3);
                int product = col2Value * col3Value;
                tong += product;
            }

            setTien(tong);
            

        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (isSelected) {
            button.setForeground(table.getSelectionForeground());
            button.setBackground(table.getSelectionBackground());
        } else {
            button.setForeground(table.getForeground());
            button.setBackground(table.getBackground());
        }

        return button;
    }
}
