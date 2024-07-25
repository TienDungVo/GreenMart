/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duan1.entity;

/**
 *
 * @author dung8
 */
public class TaiKhoan {
    
    private String UserName,TenTK ;
    private boolean role;
    private String MoTaRole,Password,HinhAnh;

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String HinhAnh) {
        this.HinhAnh = HinhAnh;
    }
    
    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getTenTK() {
        return TenTK;
    }

    public void setTenTK(String TenTK) {
        this.TenTK = TenTK;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    public String getMoTaRole() {
        return MoTaRole;
    }

    public void setMoTaRole(String MoTaRole) {
        this.MoTaRole = MoTaRole;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public TaiKhoan(String UserName, String TenTK, boolean role, String MoTaRole, String Password) {
        this.UserName = UserName;
        this.TenTK = TenTK;
        this.role = role;
        this.MoTaRole = MoTaRole;
        this.Password = Password;
    }

    public TaiKhoan() {
    }
    
    
    
}
