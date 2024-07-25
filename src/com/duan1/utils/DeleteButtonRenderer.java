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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author dung8
 */
public class DeleteButtonRenderer extends JButton implements TableCellRenderer {

    public DeleteButtonRenderer() {
        setOpaque(true);
        // Thiết lập ActionListener cho nút
        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lấy vị trí hàng chứa nút đã được nhấn
                JTable table = (JTable) getParent();
                int row = table.getEditingRow();
                // Xóa hàng tại vị trí đã lấy
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

