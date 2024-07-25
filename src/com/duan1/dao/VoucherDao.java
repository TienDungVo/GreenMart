/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duan1.dao;

import com.duan1.entity.DoanhMuc;
import com.duan1.entity.Voucher;
import com.duan1.utils.Jdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dung8
 */
public class VoucherDao {

    public void insert(Voucher model) {
        String sql = "INSERT INTO Voucher (MaVoucher, HinhAnh, MoTa, GiaTri) VALUES (?, ?, ?, ?);";
        Jdbc.executeUpdate(sql,
                model.getMaVoucher(),
                model.getHinhAnh(),
                model.getMoTa(),
                model.getGiaTri());
    }

    public void update(Voucher model) {
        String sql = "UPDATE Voucher SET HinhAnh =? , MoTa =? , GiaTri =?  WHERE MaVoucher=?";
        Jdbc.executeUpdate(sql,
                model.getHinhAnh(),
                model.getMoTa(),
                model.getGiaTri(),
                model.getMaVoucher());

    }

    public void delete(String MaNV) {
        String sql = "DELETE FROM Voucher WHERE MaVoucher = ?";
        Jdbc.executeUpdate(sql, MaNV);
    }

    public List<Voucher> select() {
        String sql = "SELECT * FROM Voucher";
        return select(sql);
    }

   

    private List<Voucher> select(String sql, Object... args) {
        List<Voucher> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = Jdbc.executeQuery(sql, args);
                while (rs.next()) {
                    Voucher model = readFromResultSet(rs);
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

    private Voucher readFromResultSet(ResultSet rs) throws SQLException {
        Voucher model = new Voucher();
        model.setMaVoucher(rs.getInt("MaVoucher"));
        model.setGiaTri(rs.getInt("GiaTri"));
        model.setMoTa(rs.getString("MoTa"));

        model.setHinhAnh(rs.getString("HinhAnh"));

        return model;
    }
     public Voucher findById(int mavc) {
        String sql = "SELECT * FROM Voucher WHERE MaVoucher=?";
        List<Voucher> list = select(sql, mavc);
        return list.size() > 0 ? list.get(0) : null;
    }

}
