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

/**
 *
 * @author dung8
 */
public class ThongKeBieuDoDao {

    public List<ThongKeBieuDo> SelectbyTime(int thang, int nam) {
        String sql = "SELECT DM.TenDoanhMuc AS TenDoanhMuc,\n"
                + "       SUM(HDCT.SoLuong * SP.Gia) AS DoanhThu\n"
                + "FROM DoanhMucSanPham DM\n"
                + "JOIN SanPham SP ON DM.IDDanhMuc = SP.IDDanhmuc\n"
                + "JOIN HoaDonChiTiet HDCT ON SP.IDSanPham = HDCT.IDSanPham\n"
                + "JOIN HoaDon HD ON HDCT.IDHoaDon = HD.IDHoaDon\n"
                + "WHERE MONTH(HD.ThoiGian) = ?\n"
                + "  AND YEAR(HD.ThoiGian) = ?\n"
                + "GROUP BY DM.TenDoanhMuc;";
        return select(sql, thang, nam);
    }

    private List<ThongKeBieuDo> select(String sql, Object... args) {
        List<ThongKeBieuDo> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = Jdbc.executeQuery(sql, args);
                while (rs.next()) {
                    ThongKeBieuDo model = readFromResultSet(rs);
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

    private ThongKeBieuDo readFromResultSet(ResultSet rs) throws SQLException {
        ThongKeBieuDo model = new ThongKeBieuDo();
        model.setTenDanhMuc(rs.getString("TenDoanhMuc"));
        model.setDoanhThu(rs.getInt("DoanhThu"));

        return model;
    }
        
    
}
