/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.*;
import java.util.ArrayList;
import model.CanBo;
import model.CongNhan;
import model.KySu;
import model.NhanVien;

/**
 *
 * @author HaQuocTuan
 */
public class DAO {

    private Connection conn;

    public DAO() {
        try {
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"
                    + "databasename=BTLJava;"
                    + "username=sa;"
                    + "password=admin");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    
    public ArrayList<KySu> getListKySu() {
        ArrayList<KySu> list = new ArrayList<>();
        String sql = "select HoTen, NamSinh, GioiTinh, DiaChi, ChucVu, MoTa \n"
                + "from CanBo \n"
                + "where ChucVu = N'Kỹ sư'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KySu s = new KySu();
                s.setHoten(rs.getString("HoTen"));
                s.setNamsinh(rs.getString("NamSinh"));
                s.setGioitinh(rs.getString("GioiTinh"));
                s.setDiachi(rs.getString("DiaChi"));
                s.setChucvu(rs.getString("ChucVu"));
                s.setMota(rs.getString("MoTa"));
                list.add(s);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<CongNhan> getListCongNhan() {
        ArrayList<CongNhan> list = new ArrayList<>();
        String sql = "select HoTen, NamSinh, GioiTinh, DiaChi, ChucVu, MoTa \n"
                + "from CanBo \n"
                + "where ChucVu = N'Công nhân'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CongNhan s = new CongNhan();
                s.setHoten(rs.getString("HoTen"));
                s.setNamsinh(rs.getString("NamSinh"));
                s.setGioitinh(rs.getString("GioiTinh"));
                s.setDiachi(rs.getString("DiaChi"));
                s.setChucvu(rs.getString("ChucVu"));
                s.setMota(rs.getString("MoTa"));
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<NhanVien> getListNhanVien() {
        ArrayList<NhanVien> list = new ArrayList<>();
        String sql = "select HoTen, NamSinh, GioiTinh, DiaChi, ChucVu, MoTa \n"
                + "from CanBo \n"
                + "where ChucVu = N'Nhân viên'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien s = new NhanVien();
                s.setHoten(rs.getString("HoTen"));
                s.setNamsinh(rs.getString("NamSinh"));
                s.setGioitinh(rs.getString("GioiTinh"));
                s.setDiachi(rs.getString("DiaChi"));
                s.setChucvu(rs.getString("ChucVu"));
                s.setMota(rs.getString("MoTa"));
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //check admin
    public boolean isAdmin(String user, String pass) {
        String sql = "select isAdmin \n"
                + "from CanBo\n"
                + "where Username = ? and Password = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int is = rs.getInt("isAdmin");
                if (is == 1) {
                    return true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    //checkUser
    public boolean isUser(String user, String pass) {
        String sql = "select * \n"
                + "from CanBo\n"
                + "where Username = ? and Password = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString("HoTen") != "") {
                    return true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public static void main(String[] args) {
        new DAO();
    }
}
