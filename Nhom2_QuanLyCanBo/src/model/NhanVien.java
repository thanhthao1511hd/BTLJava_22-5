/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author HaQuocTuan
 */
public class NhanVien extends CanBo {

    String chucvu;
    String mota;
    String username;
    String password;
    int isAdmin, ID;

    public NhanVien(String chucvu, String mota, String username) {
        this.chucvu = chucvu;
        this.mota = mota;
        this.username = username;
    }

    public NhanVien(String chucvu, String mota, String username, String hoten, String namsinh, String gioitinh, String diachi) {
        super(hoten, namsinh, gioitinh, diachi);
        this.chucvu = chucvu;
        this.mota = mota;
        this.username = username;
    }

    
    
    public NhanVien(String chucvu, String mota, String username, String password, int isAdmin) {
        this.chucvu = chucvu;
        this.mota = mota;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public NhanVien(String chucvu, String mota, String username, String password, int isAdmin, String hoten, String namsinh, String gioitinh, String diachi) {
        super(hoten, namsinh, gioitinh, diachi);
        this.chucvu = chucvu;
        this.mota = mota;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    
    public NhanVien() {
    }

    public NhanVien(String chucvu, String mota) {
        this.chucvu = chucvu;
        this.mota = mota;
    }

    public NhanVien(String chucvu, String mota, String hoten, String namsinh, String gioitinh, String diachi) {
        super(hoten, namsinh, gioitinh, diachi);
        this.chucvu = chucvu;
        this.mota = mota;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(String namsinh) {
        this.namsinh = namsinh;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

}
