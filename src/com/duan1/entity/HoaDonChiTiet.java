/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duan1.entity;

/**
 *
 * @author dung8
 */
public class HoaDonChiTiet {
    private int IDHoaDonChiTiet, IDHoaDon,SoLuong,Gia;
    private String IDSanPham,TenSanPham;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(int IDHoaDonChiTiet, int IDHoaDon, int SoLuong, int Gia, String IDSanPham, String TenSanPham) {
        this.IDHoaDonChiTiet = IDHoaDonChiTiet;
        this.IDHoaDon = IDHoaDon;
        this.SoLuong = SoLuong;
        this.Gia = Gia;
        this.IDSanPham = IDSanPham;
        this.TenSanPham = TenSanPham;
    }

    public int getIDHoaDonChiTiet() {
        return IDHoaDonChiTiet;
    }

    public void setIDHoaDonChiTiet(int IDHoaDonChiTiet) {
        this.IDHoaDonChiTiet = IDHoaDonChiTiet;
    }

    public int getIDHoaDon() {
        return IDHoaDon;
    }

    public void setIDHoaDon(int IDHoaDon) {
        this.IDHoaDon = IDHoaDon;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int Gia) {
        this.Gia = Gia;
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

   
  
    
}
