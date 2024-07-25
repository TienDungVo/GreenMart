package com.duan1.dao;


import com.duan1.entity.HoaDon;
import com.duan1.entity.SanPham;
import com.duan1.utils.Jdbc;
import java.security.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bridj.cpp.com.OLEAutomationLibrary;

/**
 *
 * @author dung8
 */
public class HoaDonDao {
     public List<HoaDon> select() {
        String sql = "SELECT * FROM HoaDon";
        return select(sql);
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

        model.setIDHoaDon(rs.getInt("IDHoaDon"));
        model.setMaVoucher(rs.getInt("MaVoucher"));
        model.setTrangThai(rs.getBoolean("TrangThai"));
        model.setNguoiThucHien(rs.getString("NguoiThucHien"));
        model.setTongTien(rs.getInt("TongTien"));
        model.setTienKhachDua(rs.getInt("TienKhachDua"));
        model.setTienThoi(rs.getInt("TienThoi"));
        model.setThoiGian(rs.getTimestamp("ThoiGian"));
        model.setGhichu(rs.getString("GhiChu"));

        return model;
    }
     public HoaDon findByIdHoaDon(int mahd) {
        String sql = "SELECT * FROM HoaDon WHERE IDHoaDon=?";
        List<HoaDon> list = select(sql, mahd);
        return list.size() > 0 ? list.get(0) : null;
    }
    public List<HoaDon> SelectbyTime(Date ngaydau, Date ngayCuoi){
    String sql = "SELECT * FROM HoaDon WHERE ThoiGian BETWEEN ? AND ?;";
    return select(sql, ngaydau, ngayCuoi);
}
}
