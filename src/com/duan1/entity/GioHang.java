/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duan1.entity;

/**
 *
 * @author dung8
 */
public class GioHang {
    private String IDSanPham, TenSanPham;
    private int Gia,SoLuong;

    public GioHang() {
    }

    public GioHang(String IDSanPham, String TenSanPham, int Gia, int SoLuong) {
        this.IDSanPham = IDSanPham;
        this.TenSanPham = TenSanPham;
        this.Gia = Gia;
        this.SoLuong = SoLuong;
    }

    public String getIDSanPham() {
        return IDSanPham;
    }

    public void setIDSanPham(String IDSanPham) {
        this.IDSanPham = IDSanPham;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String TenSanPham) {
        this.TenSanPham = TenSanPham;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int Gia) {
        this.Gia = Gia;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }
    
    
}
