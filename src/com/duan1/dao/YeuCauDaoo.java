/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duan1.dao;

import com.duan1.entity.Voucher;
import com.duan1.entity.YeuCau;
import com.duan1.utils.Jdbc;
import com.duan1.utils.ShareHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dung8
 */
public class YeuCauDaoo {

    public List<YeuCau> select() {
        String sql = "SELECT * FROM yeuCau where trangthai=1 ";
        return select(sql);
    }

    public List<YeuCau> selectDagui() {
        String sql = "SELECT * FROM yeuCau where trangthai is null";
        return select(sql);
    }

    public List<YeuCau> selectDahuy() {
        String sql = "SELECT * FROM yeuCau where trangthai  = 0";
        return select(sql);
    }

    public void Insert(String NoiDungChinh, String NoiDung) {
        String sql = "INSERT INTO yeuCau (idNguoithuchien, title, mess, thoigian)\n"
                + "VALUES (?,?,?,?);";
         Jdbc.executeUpdate(sql,ShareHelper.USER.getUserName(),NoiDungChinh,NoiDung,new Timestamp(System.currentTimeMillis()) );
    }
 public void updateXetDuyet(int stt,int trangthai ,String PhanHoi) {
        String sql = "Update YeuCau set  phanhoi =? , trangthai = ? where idyc =? ";
         Jdbc.executeUpdate(sql, PhanHoi ,trangthai,stt);
    }

    private List<YeuCau> select(String sql, Object... args) {
        List<YeuCau> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = Jdbc.executeQuery(sql, args);
                while (rs.next()) {
                    YeuCau model = readFromResultSet(rs);
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

    private YeuCau readFromResultSet(ResultSet rs) throws SQLException {
        YeuCau model = new YeuCau();
        model.setIdyc(rs.getInt("idyc"));
        model.setNguoithuchien(rs.getString("idNguoithuchien"));
        model.setPhanHoi(rs.getString("phanHoi"));
        model.setTitle(rs.getString("title"));
        model.setNoidung(rs.getString("mess"));
        model.setTrangthai(rs.getBoolean("trangthai"));
        model.setThoigian(rs.getTimestamp("thoigian"));
        return model;
    }

    public static void main(String[] args) {
        YeuCauDaoo cauDaoo = new YeuCauDaoo();
        cauDaoo.select();
    }
}
