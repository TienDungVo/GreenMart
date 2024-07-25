/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duan1.utils;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author dung8
 */
 public class ButtonRenderer extends JButton implements TableCellRenderer {

    public ButtonRenderer() {
        setOpaque(true);
        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Xử lý logic xóa dữ liệu
                // Ví dụ:
                JTable table = (JTable) getParent();
                int row = table.getEditingRow();
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.removeRow(row);
            }
        });
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (isSelected) {
            // Xử lý hiển thị khi ô được chọn
        } else {
            // Xử lý hiển thị khi ô không được chọn
        }
        // Thiết lập văn bản hoặc hình ảnh cho nút
        setText((value == null) ? "" : value.toString());
        return this;
    }
}

