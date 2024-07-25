/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duan1.dao;

import com.duan1.entity.NhatKyHoatDong;
import com.duan1.entity.NhatKyHoatDong;
import com.duan1.ui.NkHoatDonglFrame;
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
public class NhatKyHDDao {

    public List<NhatKyHoatDong> select() {
        String sql = "SELECT * FROM NhatKiHoatDong WHERE TrangThai = 1 ";
        return select(sql);
    }

    private List<NhatKyHoatDong> select(String sql, Object... args) {
        List<NhatKyHoatDong> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = Jdbc.executeQuery(sql, args);
                while (rs.next()) {
                    NhatKyHoatDong model = readFromResultSet(rs);
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

    private NhatKyHoatDong readFromResultSet(ResultSet rs) throws SQLException {
        NhatKyHoatDong model = new NhatKyHoatDong();

        model.setIDNhatKyHoatDong(rs.getInt("IDNhatKiHoatDong"));
        model.setThoiGian(rs.getTimestamp("ThoiGianHoatDong"));
        model.setMoTa(rs.getString("MoTa"));
        model.setNguoiThucHien(rs.getString("NguoiThucHien"));

        return model;
    }

    public NhatKyHoatDong findByIdNhatKyHoatDong(int mahd) {
        String sql = "SELECT * FROM NhatKyHoatDong WHERE =?";
        List<NhatKyHoatDong> list = select(sql, mahd);
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<NhatKyHoatDong> SelectbyTime(Date ngaydau, Date ngayCuoi) {
        String sql = "SELECT * FROM NhatKyHoatDong WHERE ThoiGian BETWEEN ? AND ?;";
        return select(sql, ngaydau, ngayCuoi);

    }

    public void insert(NhatKyHoatDong model) {
        String sql = "INSERT INTO NhatKiHoatDong (MoTa,ThoiGianHoatDong,NguoiThucHien,TrangThai) VALUES (?, ?, ?, ?);";
        Jdbc.executeUpdate(sql,
                model.getMoTa(),
                model.getThoiGian(),
                model.getNguoiThucHien(),
                model.isTrangThai());
    }

    public void Update() {
        String sql = "UPDATE [GreenMart].[dbo].[NhatKiHoatDong]\n"
                + "SET TrangThai = 0\n"
                + "WHERE TrangThai = 1;";
        Jdbc.executeUpdate(sql);
    }

}
