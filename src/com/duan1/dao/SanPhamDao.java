/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duan1.dao;

import com.duan1.entity.SanPham;
import com.duan1.entity.SanPham;
import com.duan1.utils.Jdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dung8
 */
public class SanPhamDao {

    public void insert(SanPham model) {
        String sql = "INSERT INTO SanPham (IDSanPham, IDDanhmuc, TenSanPham, Gia, MoTa, HinhAnh) VALUES (?, ?, ?, ?, ?, ?);";
        Jdbc.executeUpdate(sql,
                model.getIDSanPham(),
                model.getIDDoanhMuc(),
                model.getTenSanPham(),
                model.getGia(),
                model.getMoTa(),
                model.getHinhAnh()
        );
    }

    public void update(SanPham model) {
        String sql = "UPDATE SanPham SET IDDanhmuc = ?, TenSanPham = ?, Gia = ?, MoTa = ?, HinhAnh = ? WHERE IDSanpham = ?;";
        Jdbc.executeUpdate(sql,
                model.getIDDoanhMuc(),
                model.getTenSanPham(),
                model.getGia(),
                model.getMoTa(),
                model.getHinhAnh(),
                model.getIDSanPham());
    }

    public void delete(String MaSP) {
        String sql = "DELETE FROM SanPHam WHERE IDSanpham=?";
        Jdbc.executeUpdate(sql, MaSP);
    }

    public List<SanPham> select() {
        String sql = "SELECT * FROM SanPham";
        return select(sql);
    }

    public List<SanPham> selectToKhoHang() {
        String sql = "SELECT SP.*\n"
                + "FROM SanPham SP\n"
                + "LEFT JOIN Kho K ON SP.IDSanPham = K.IDSanPham\n"
                + "WHERE K.IDSanPham IS NULL;";
        return select(sql);
    }

    public List<SanPham> selectThanhToan() {
        String sql = "SELECT SP.*\n"
                + "FROM SanPham SP\n"
                + "JOIN Kho K ON SP.IDSanPham = K.IDSanPham;";
        return select(sql);
    }

    public List<SanPham> findById(int madm) {
        String sql = "SELECT * FROM SanPham WHERE IDDanhMuc=?";
        List<SanPham> list = select(sql, madm);
        return list;
    }

    public List<SanPham> findByIdSP(String masp) {
        String sql = "SELECT * FROM SanPham WHERE IDSanPham=?";
        List<SanPham> list = select(sql, masp);
        return list;
    }

    public SanPham findByIdSp(String masp) {
        String sql = "SELECT * FROM SanPham WHERE IDSanPham=?";
        List<SanPham> list = select(sql, masp);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<SanPham> select(String sql, Object... args) {
        List<SanPham> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = Jdbc.executeQuery(sql, args);
                while (rs.next()) {
                    SanPham model = readFromResultSet(rs);
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

    private SanPham readFromResultSet(ResultSet rs) throws SQLException {
        SanPham model = new SanPham();
        model.setIDSanPham(rs.getString("IDSanPham"));
        model.setIDDoanhMuc(rs.getInt("IDDanhMuc"));
        model.setHinhAnh(rs.getString("HinhAnh"));
        model.setMoTa(rs.getString("MoTa"));
        model.setTenSanPham(rs.getString("TenSanPham"));
        model.setGia(rs.getInt("Gia"));

        return model;
    }

}
