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
public class YeuCau {

    private int idyc;
    private String nguoithuchien, title, noidung,phanHoi;
    private Timestamp thoigian;
    private boolean trangthai;

    public YeuCau() {
    }

    public YeuCau(int idyc, String nguoithuchien, String title, String noidung, Timestamp thoigian, boolean trangthai) {
        this.idyc = idyc;
        this.nguoithuchien = nguoithuchien;
        this.title = title;
        this.noidung = noidung;
        this.thoigian = thoigian;
        this.trangthai = trangthai;
    }

    public int getIdyc() {
        return idyc;
    }

    public void setIdyc(int idyc) {
        this.idyc = idyc;
    }

    public String getNguoithuchien() {
        return nguoithuchien;
    }

    public void setNguoithuchien(String nguoithuchien) {
        this.nguoithuchien = nguoithuchien;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public Timestamp getThoigian() {
        return thoigian;
    }

    public void setThoigian(Timestamp thoigian) {
        this.thoigian = thoigian;
    }

    public boolean isTrangthai() {
        return trangthai;
    }

    public void setTrangthai(boolean trangthai) {
        this.trangthai = trangthai;
    }

    public String getPhanHoi() {
        return phanHoi;
    }

    public void setPhanHoi(String phanHoi) {
        this.phanHoi = phanHoi;
    }
    
}
