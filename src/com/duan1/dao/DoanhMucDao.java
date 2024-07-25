/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duan1.dao;

import com.duan1.entity.DoanhMuc;
import com.duan1.utils.Jdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dung8
 */
public class DoanhMucDao {

    public void insert(DoanhMuc model) {
        String sql = "INSERT INTO DoanhMucSanPham (TenDoanhMuc, HinhAnh, MoTa) VALUES (?, ?,?);";
        Jdbc.executeUpdate(sql,
                model.getTenDoanhMuc(),
                model.getHinhAnh(),
                model.getMoTa());
    }

    public void update(DoanhMuc model) {
        String sql = "UPDATE DoanhMucSanPham SET TenDoanhMuc = ?, MoTa = ?, HinhAnh= ? WHERE IDDanhMuc = ?;";
        Jdbc.executeUpdate(sql,
                model.getTenDoanhMuc(),
                model.getMoTa(),
                model.getHinhAnh(),
                model.getIDDoanhMuc());
    }

    public void delete(String MaNV) {
        String sql = "DELETE FROM DoanhMucSanPHam WHERE IDDanhMuc=?";
        Jdbc.executeUpdate(sql, MaNV);
    }

    public List<DoanhMuc> select() {
        String sql = "SELECT * FROM DoanhMucSanPham";
        return select(sql);
    }

    public DoanhMuc findById(int madm) {
        String sql = "SELECT * FROM DoanhMucSanPham WHERE IDDanhMuc=?";
        List<DoanhMuc> list = select(sql, madm);
        return list.size() > 0 ? list.get(0) : null;
    }
    
//    public String findIdDm(int madm){
//        String sql = "SELECT tendoanhmuc FROM DoanhMucSanPham WHERE IDDanhMuc=?";
//        return select(sql,madm);
//    }

    private List<DoanhMuc> select(String sql, Object... args) {
        List<DoanhMuc> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = Jdbc.executeQuery(sql, args);
                while (rs.next()) {
                    DoanhMuc model = readFromResultSet(rs);
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

    private DoanhMuc readFromResultSet(ResultSet rs) throws SQLException {
        DoanhMuc model = new DoanhMuc();
        model.setIDDoanhMuc(rs.getInt("IDDanhMuc"));
        model.setTenDoanhMuc(rs.getString("TenDoanhMuc"));
        model.setHinhAnh(rs.getString("HinhAnh"));
        model.setMoTa(rs.getString("MoTa"));
        return model;
    }
   
}
