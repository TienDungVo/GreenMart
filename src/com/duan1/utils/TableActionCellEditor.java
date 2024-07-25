/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duan1.utils;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author dung8
 */
public class TableActionCellEditor extends DefaultCellEditor{
   private TableActionEven even ;
   
    public TableActionCellEditor(TableActionEven even) {
        super(new JCheckBox());
        this.even = even;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        PanelAction action = new PanelAction();
        action.initEvent(even, row);
        action.setBackground(table.getSelectionBackground());
        return action;
    }
    
}
