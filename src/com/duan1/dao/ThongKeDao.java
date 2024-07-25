/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duan1.dao;

import com.duan1.entity.GioHang;
import com.duan1.utils.Jdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author dung8
 */
public class ThongKeDao {

    public List<GioHang> hongKESoLuongBanRa() {
        String sql = "SELECT SanPham.IDSanPham, \n"
                + "       SUM(HoaDonChiTiet.SoLuong) AS SoLuong , SanPham.Gia AS Gia\n"
                + "FROM SanPham\n"
                + "INNER JOIN HoaDonChiTiet ON SanPham.IDSanPham = HoaDonChiTiet.IDSanPham\n"
                + "INNER JOIN HoaDon ON HoaDonChiTiet.IDHoaDon = HoaDon.IDHoaDon\n"
                + "\n"
                + "GROUP BY SanPham.IDSanPham, SanPham.Gia;";
        return select(sql);
    }

    public List<GioHang> SelectbyTime(Date ngaydau, Date ngayCuoi) {
        String sql = "SELECT SanPham.IDSanPham,  \n"
                + "       SUM(HoaDonChiTiet.SoLuong) AS SoLuong , SanPham.Gia AS Gia\n"
                + "FROM SanPham\n"
                + "INNER JOIN HoaDonChiTiet ON SanPham.IDSanPham = HoaDonChiTiet.IDSanPham\n"
                + "INNER JOIN HoaDon ON HoaDonChiTiet.IDHoaDon = HoaDon.IDHoaDon\n"
                + "WHERE HoaDon.ThoiGian BETWEEN ? AND ?\n"
                + "GROUP BY SanPham.IDSanPham, SanPham.Gia;";
        return select(sql, ngaydau, ngayCuoi);
    }

    private List<GioHang> select(String sql, Object... args) {
        List<GioHang> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = Jdbc.executeQuery(sql, args);
                while (rs.next()) {
                    GioHang model = readFromResultSet(rs);
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

    private GioHang readFromResultSet(ResultSet rs) throws SQLException {
        GioHang model = new GioHang();
        model.setIDSanPham(rs.getString("IDSanPham"));
        model.setSoLuong(rs.getInt("SoLuong"));
        model.setGia(rs.getInt("Gia"));

        return model;
    }
}
