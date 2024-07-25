package com.duan1.dao;

import com.duan1.entity.HoaDon;
import com.duan1.entity.HoaDonChiTiet;

import com.duan1.utils.Jdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author dung8
 */
public class HoaDonChiTietDao {

    public List<HoaDonChiTiet> select() {
        String sql = "SELECT * FROM HoaDonChiTiet";
        return select(sql);
    }

    public void insertHoaDonChiTiet(HoaDonChiTiet hd) {
        String sql = "INSERT INTO HoaDonChiTiet (IDHoaDon,IDSanPham,SoLuong,Gia) VALUES (?, ?, ?, ?)";
        Jdbc.executeUpdate(sql, hd.getIDHoaDon(), hd.getIDSanPham(), hd.getSoLuong(), hd.getGia());

    }

    private List<HoaDonChiTiet> select(String sql, Object... args) {
        List<HoaDonChiTiet> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = Jdbc.executeQuery(sql, args);
                while (rs.next()) {
                    HoaDonChiTiet model = readFromResultSet(rs);
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

    private HoaDonChiTiet readFromResultSet(ResultSet rs) throws SQLException {
        HoaDonChiTiet model = new HoaDonChiTiet();

        model.setIDHoaDon(rs.getInt("IDHoaDon"));
        model.setIDSanPham(rs.getString("IDSanPham"));
        model.setTenSanPham(rs.getString("TenSanPham"));
        model.setSoLuong(rs.getInt("SoLuong"));
        model.setGia(rs.getInt("Gia"));

        return model;
    }

    public List<HoaDonChiTiet> selectbyMaHDNew(int maHD) {
        String sql = "SELECT HDCT.IDHoaDon AS IDHoaDon,\n"
                + "       HDCT.IDSanPham AS IDSanPham,\n"
                + "       SP.TenSanPham AS TenSanPham,\n"
                + "       HDCT.SoLuong AS SoLuong,\n"
                + "       SP.Gia AS Gia\n"
                + "FROM HoaDonChiTiet HDCT\n"
                + "JOIN SanPham SP ON HDCT.IDSanPham = SP.IDSanPham\n"
                + "WHERE IDHoaDon = ? ";
        return select(sql, maHD);
    }

    public List<HoaDonChiTiet> selectbyMaHD(int maHD) {
        String sql = "SELECT \n"
                + "       HDCT.IDHoaDonChiTiet AS IDHoaDonChiTiet,\n"
                + "       HDCT.IDHoaDon AS IDHoaDon,\n"
                + "       HDCT.IDSanPham AS IDSanPham,\n"
                + "       SP.TenSanPham AS TenSanPham,\n"
                + "       HDCT.SoLuong AS SoLuong,\n"
                + "       SP.Gia AS Gia\n"
                + "FROM HoaDonChiTiet HDCT\n"
                + "JOIN SanPham SP ON HDCT.IDSanPham = SP.IDSanPham\n"
                + "WHERE IDHoaDon =?";
        return select(sql, maHD);
    }
}
