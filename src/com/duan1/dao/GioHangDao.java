/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duan1.dao;

import com.duan1.entity.GioHang;
import com.duan1.entity.Kho;
import com.duan1.utils.Jdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dung8
 */
public class GioHangDao {

    public GioHang select(String idsp) {
        String sql = "select IDSanPham,TenSanPham,Gia from SanPham where IDSanPham = ?";
        List<GioHang> list = select(sql, idsp);
        return list.size() > 0 ? list.get(0) : null;

    }

   

//    public String findIdDm(int madm){
//        String sql = "SELECT tendoanhmuc FROM Kho WHERE IDDanhMuc=?";
//        return select(sql,madm);
//    }
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
        model.setGia(rs.getInt("Gia"));
        model.setTenSanPham(rs.getString("TenSanPham"));
      
        return model;
    }

}
