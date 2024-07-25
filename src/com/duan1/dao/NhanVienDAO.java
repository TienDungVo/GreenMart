/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duan1.dao;

import com.duan1.entity.Doipass;
import com.duan1.entity.TaiKhoan;
import com.duan1.utils.Jdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dung8
 */
public class NhanVienDAO {
   public void insert(TaiKhoan model){
 String sql="INSERT INTO TaiKhoan (Username, TenTK, role, MoTaRole, MatKhau, HinhAnh) VALUES (?, ?, ?, ?, ?, ?);";
 Jdbc.executeUpdate(sql, 
 model.getUserName(), 
 model.getTenTK(),
 model.isRole(), 
 model.getMoTaRole(),
 model.getPassword(),
 model.getHinhAnh());
 }
 
 public void update(TaiKhoan model){
 String sql="UPDATE TaiKhoan SET TenTK=?,role=?,MoTaRole =?,MatKhau =?,HinhAnh =? WHERE Username=?";
 Jdbc.executeUpdate(sql,  
 model.getTenTK(),
 model.isRole(), 
 model.getMoTaRole(),
 model.getPassword(),
 model.getHinhAnh(),
 model.getUserName());
 
 }
    
    public void delete(String MaNV) {
        String sql = "DELETE FROM TaiKhoan WHERE Username = ?";
        Jdbc.executeUpdate(sql, MaNV);
    }

    public List<TaiKhoan> select() {
        String sql = "SELECT * FROM TaiKhoan";
        return select(sql);
    }
     public List<TaiKhoan> findByIdManv(String manv) {
        String sql = "SELECT * FROM TaiKhoan WHERE Username=?";
        return select(sql,manv);
    }
    public TaiKhoan findById(String manv) {
        String sql = "SELECT * FROM TaiKhoan WHERE Username=?";
        List<TaiKhoan> list = select(sql, manv);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<TaiKhoan> select(String sql, Object... args) {
        List<TaiKhoan> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = Jdbc.executeQuery(sql, args);
                while (rs.next()) {
                    TaiKhoan model = readFromResultSet(rs);
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

    private TaiKhoan readFromResultSet(ResultSet rs) throws SQLException {
        TaiKhoan model = new TaiKhoan();
        model.setUserName(rs.getString("Username"));
        model.setTenTK(rs.getString("TenTK"));
        model.setRole(rs.getBoolean("role"));
        model.setMoTaRole(rs.getString("MoTaRole"));
        model.setPassword(rs.getString("MatKhau")); 
        model.setHinhAnh(rs.getString("HinhAnh"));
                
        return model;
    }
     public void update1(Doipass model){ 
String sql="UPDATE TaiKhoan SET MatKhau =? WHERE Username=? "; 
    Jdbc.executeUpdate(sql,
            model.getMatkhau(),
            model.getMaNV()); 
    
}    
    
}


