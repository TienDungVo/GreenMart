/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duan1.entity;

/**
 *
 * @author dung8
 */
public class ThongKeBieuDo {

    private String tenDanhMuc;
    private int DoanhThu;

    public ThongKeBieuDo() {
    }

    public ThongKeBieuDo(String tenDanhMuc, int DoanhThu) {
        this.tenDanhMuc = tenDanhMuc;
        this.DoanhThu = DoanhThu;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public int getDoanhThu() {
        return DoanhThu;
    }

    public void setDoanhThu(int DoanhThu) {
        this.DoanhThu = DoanhThu;
    }

}
