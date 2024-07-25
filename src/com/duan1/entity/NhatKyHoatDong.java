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
public class NhatKyHoatDong {
    private int IDNhatKyHoatDong;
    private String MoTa ,NguoiThucHien;
    private Timestamp ThoiGian;
    private boolean TrangThai;
    public NhatKyHoatDong() {
    }

    public NhatKyHoatDong(int IDNhatKyHoatDong, String MoTa, String NguoiThucHien, Timestamp ThoiGian, boolean TrangThai) {
        this.IDNhatKyHoatDong = IDNhatKyHoatDong;
        this.MoTa = MoTa;
        this.NguoiThucHien = NguoiThucHien;
        this.ThoiGian = ThoiGian;
        this.TrangThai = TrangThai;
    }

    public int getIDNhatKyHoatDong() {
        return IDNhatKyHoatDong;
    }

    public void setIDNhatKyHoatDong(int IDNhatKyHoatDong) {
        this.IDNhatKyHoatDong = IDNhatKyHoatDong;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public String getNguoiThucHien() {
        return NguoiThucHien;
    }

    public void setNguoiThucHien(String NguoiThucHien) {
        this.NguoiThucHien = NguoiThucHien;
    }

    public Timestamp getThoiGian() {
        return ThoiGian;
    }

    public void setThoiGian(Timestamp ThoiGian) {
        this.ThoiGian = ThoiGian;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

   
}