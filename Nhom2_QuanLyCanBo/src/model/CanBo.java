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
public class CanBo {
    protected String hoten;
    protected String namsinh;
    protected String gioitinh;
    protected String diachi;
    protected int ID;
    
    public CanBo() {
    }

    public CanBo(String hoten, String namsinh, String gioitinh, String diachi) {
        this.hoten = hoten;
        this.namsinh = namsinh;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
    }

    public String getHoten() {
        return hoten;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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
