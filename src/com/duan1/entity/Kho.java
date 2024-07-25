/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duan1.entity;

/**
 *
 * @author dung8
 */
public class Kho {
    private int IDKho,Soluong;
    private String IDSanPham,tensp;

    public Kho() {
    }

    public Kho(int IDKho, int Soluong, String IDSanPham, String tensp) {
        this.IDKho = IDKho;
        this.Soluong = Soluong;
        this.IDSanPham = IDSanPham;
        this.tensp = tensp;
    }

    public int getIDKho() {
        return IDKho;
    }

    public void setIDKho(int IDKho) {
        this.IDKho = IDKho;
    }

    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int Soluong) {
        this.Soluong = Soluong;
    }

    public String getIDSanPham() {
        return IDSanPham;
    }

    public void setIDSanPham(String IDSanPham) {
        this.IDSanPham = IDSanPham;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

   
    
}
