/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duan1.entity;

/**
 *
 * @author dung8
 */
public class DoanhMuc {
    private int IDDoanhMuc;
    private String TenDoanhMuc,HinhAnh,MoTa;
   
    public DoanhMuc(int iddm, String tenDm) {
         this.IDDoanhMuc= iddm;
         this.TenDoanhMuc= tenDm;
    }
    public int getIDDoanhMuc() {
        return IDDoanhMuc;
    }

    public void setIDDoanhMuc(int IDDoanhMuc) {
        this.IDDoanhMuc = IDDoanhMuc;
    }

    public String getTenDoanhMuc() {
        return TenDoanhMuc;
    }

    public void setTenDoanhMuc(String TenDoanhMuc) {
        this.TenDoanhMuc = TenDoanhMuc;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String HinhAnh) {
        this.HinhAnh = HinhAnh;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public DoanhMuc() {
    }

    public DoanhMuc(int IDDoanhMuc, String TenDoanhMuc, String HinhAnh, String MoTa) {
        this.IDDoanhMuc = IDDoanhMuc;
        this.TenDoanhMuc = TenDoanhMuc;
        this.HinhAnh = HinhAnh;
        this.MoTa = MoTa;
    }

    public void setToolTipTextAt(int i, String valueOf) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
