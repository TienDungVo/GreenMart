/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duan1.dao;

import com.duan1.entity.Kho;
import com.duan1.entity.TaiKhoan;
import com.duan1.utils.Jdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dung8
 */
public class KhoHangDao {

    public void insert(Kho model) {
        String sql = "INSERT INTO Kho (IDSanPham, SoLuong) VALUES (?, ?);";
        Jdbc.executeUpdate(sql,
                model.getIDSanPham(),
                model.getSoluong());
    }

    public void delete(String MaNV) {
        String sql = "DELETE FROM KhoSanPHam WHERE IDDanhMuc=?";
        Jdbc.executeUpdate(sql, MaNV);
    }

    public List<Kho> select() {
        String sql = "select K.* , s.TenSanPham from kho K inner join SanPham s on k.IDSanPham= s.IDSanPham";
        return select(sql);
    }

    public Kho findById(int madm) {
        String sql = "SELECT * FROM Kho WHERE IDDanhMuc=?";
        List<Kho> list = select(sql, madm);
        return list.size() > 0 ? list.get(0) : null;
    }

//    public String findIdDm(int madm){
//        String sql = "SELECT tendoanhmuc FROM Kho WHERE IDDanhMuc=?";
//        return select(sql,madm);
//    }
    private List<Kho> select(String sql, Object... args) {
        List<Kho> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = Jdbc.executeQuery(sql, args);
                while (rs.next()) {
                    Kho model = readFromResultSet(rs);
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

    private Kho readFromResultSet(ResultSet rs) throws SQLException {
        Kho model = new Kho();
        model.setIDKho(rs.getInt("IDKho"));
        model.setIDSanPham(rs.getString("IDSanPham"));
        model.setSoluong(rs.getInt("SoLuong"));
        model.setTensp(rs.getString("TenSanPham"));
        return model;
    }

    public int insertTT(String idsp, int sl) {
        return Jdbc.excuteKhho(idsp, sl);
    }

    public void update(String idsp,int soluong) {
        String sql = "UPDATE [GreenMart].[dbo].[Kho] \n" +
"SET SoLuong = SoLuong + ? \n" +
"WHERE IDSanPham = ?;";
         Jdbc.executeUpdate(sql, soluong,idsp);
        

    }
}
