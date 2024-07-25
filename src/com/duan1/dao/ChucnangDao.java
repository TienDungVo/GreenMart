/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duan1.dao;

import com.duan1.entity.ThongKeBieuDo;
import com.duan1.utils.Jdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javaswingdev.chart.ModelPieChart;

/**
 *
 * @author dung8
 */
public class ChucnangDao {
    public List<ModelPieChart> SelectbyPie() {
        String sql = "SELECT DM.TenDoanhMuc AS TenDoanhMuc,\n"
                + "       SUM(HDCT.SoLuong * SP.Gia) AS DoanhThu\n"
                + "FROM DoanhMucSanPham DM\n"
                + "JOIN SanPham SP ON DM.IDDanhMuc = SP.IDDanhmuc\n"
                + "JOIN HoaDonChiTiet HDCT ON SP.IDSanPham = HDCT.IDSanPham\n"
                + "JOIN HoaDon HD ON HDCT.IDHoaDon = HD.IDHoaDon\n"
                + "WHERE MONTH(HD.ThoiGian) = ?\n"
                + "  AND YEAR(HD.ThoiGian) = ?\n"
                + "GROUP BY DM.TenDoanhMuc;";
        return select(sql);
    }
    private List<ModelPieChart> select(String sql, Object... args) {
        List<ModelPieChart> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = Jdbc.executeQuery(sql, args);
                while (rs.next()) {
                    ModelPieChart model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }
     private ModelPieChart readFromResultSet(ResultSet rs) throws SQLException {
        ModelPieChart model = new ModelPieChart();
        model.setName(rs.getString("TenDoanhMuc"));
        model.setValues(rs.getInt("DoanhThu"));

        return model;
    }
}
