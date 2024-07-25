/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duan1.dao;

import com.duan1.entity.HoaDon;
import com.duan1.entity.HoaDon;
import com.duan1.utils.Jdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dung8
 */
public class ThanhToanDao {

    public List<HoaDon> select() {
        String sql = "SELECT * FROM HoaDon";
        return select(sql);
    }
    public void delete(int idhd){
        String sql = " delete FROM HoaDonChiTiet WHERE IDHoaDon= ?";
        String sql1 ="delete FROM HoaDon WHERE IDHoaDon= ?";
        Jdbc.executeUpdate(sql, idhd);
        Jdbc.executeUpdate(sql1, idhd);
    }

    public int insertHoaDon(HoaDon hd) throws SQLException {
        String sql = "INSERT INTO HoaDon (MaVoucher, NguoiThucHien, TongTien, TienKhachDua, TienThoi, GhiChu, ThoiGian) VALUES (?, ?, ?, ?, ?, ?, ?)";
        int idHoaDon = Jdbc.executeUpdateAndReturnGeneratedId(sql, hd.getMaVoucher(), hd.getNguoiThucHien(), hd.getTongTien(), hd.getTienKhachDua(), hd.getTienThoi(), hd.getGhichu(), hd.getThoiGian());
        return idHoaDon;
    }

    private List<HoaDon> select(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = Jdbc.executeQuery(sql, args);
                while (rs.next()) {
                    HoaDon model = readFromResultSet(rs);
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

    private HoaDon readFromResultSet(ResultSet rs) throws SQLException {
        HoaDon model = new HoaDon();

        model.setMaVoucher(rs.getInt("MaVoucher"));
        model.setNguoiThucHien(rs.getString("NguoiThucHien"));
        model.setTongTien(rs.getInt("TongTien"));
        model.setTienKhachDua(rs.getInt("TienKhachDua"));
        model.setTienThoi(rs.getInt("TienThoi"));
        model.setGhichu(rs.getString("GhiChu"));
        return model;
    }

}
