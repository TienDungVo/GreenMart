/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duan1.entity;

/**
 *
 * @author dung8
 */
public class SanPham {
    private  String IDSanPham,TenSanPham,MoTa,HinhAnh;
    private int IDDoanhMuc;
    private  int Gia;

    public SanPham() {
    }
    
    public SanPham(String IDSanPham, String TenSanPham, String MoTa, String HinhAnh, int IDDoanhMuc, int Gia) {
        this.IDSanPham = IDSanPham;
        this.TenSanPham = TenSanPham;
        this.MoTa = MoTa;
        this.HinhAnh = HinhAnh;
        this.IDDoanhMuc = IDDoanhMuc;
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

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String HinhAnh) {
        this.HinhAnh = HinhAnh;
    }

    public int getIDDoanhMuc() {
        return IDDoanhMuc;
    }

    public void setIDDoanhMuc(int IDDoanhMuc) {
        this.IDDoanhMuc = IDDoanhMuc;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int Gia) {
        this.Gia = Gia;
    }
    
}
