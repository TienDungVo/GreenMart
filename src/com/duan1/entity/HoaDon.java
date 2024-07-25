/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duan1.entity;

import java.sql.Timestamp;

/**
 *
 * @author dung8
 */
public class HoaDon {

    private int IDHoaDon, MaVoucher, TongTien, TienKhachDua, TienThoi;
    private boolean TrangThai;
    private String NguoiThucHien, ghichu;
    private Timestamp ThoiGian;

    public HoaDon() {
    }

    public HoaDon(int IDHoaDon, int MaVoucher, int TongTien, int TienKhachDua, int TienThoi, boolean TrangThai, String NguoiThucHien, String ghichu, Timestamp ThoiGian) {
        this.IDHoaDon = IDHoaDon;
        this.MaVoucher = MaVoucher;
        this.TongTien = TongTien;
        this.TienKhachDua = TienKhachDua;
        this.TienThoi = TienThoi;
        this.TrangThai = TrangThai;
        this.NguoiThucHien = NguoiThucHien;
        this.ghichu = ghichu;
        this.ThoiGian = ThoiGian;
    }

    public int getIDHoaDon() {
        return IDHoaDon;
    }

    public void setIDHoaDon(int IDHoaDon) {
        this.IDHoaDon = IDHoaDon;
    }

    public int getMaVoucher() {
        return MaVoucher;
    }

    public void setMaVoucher(int MaVoucher) {
        this.MaVoucher = MaVoucher;
    }

    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int TongTien) {
        this.TongTien = TongTien;
    }

    public int getTienKhachDua() {
        return TienKhachDua;
    }

    public void setTienKhachDua(int TienKhachDua) {
        this.TienKhachDua = TienKhachDua;
    }

    public int getTienThoi() {
        return TienThoi;
    }

    public void setTienThoi(int TienThoi) {
        this.TienThoi = TienThoi;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getNguoiThucHien() {
        return NguoiThucHien;
    }

    public void setNguoiThucHien(String NguoiThucHien) {
        this.NguoiThucHien = NguoiThucHien;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public Timestamp getThoiGian() {
        return ThoiGian;
    }

    public void setThoiGian(Timestamp ThoiGian) {
        this.ThoiGian = ThoiGian;
    }

}
