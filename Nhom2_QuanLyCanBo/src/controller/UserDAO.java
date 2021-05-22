/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.KySu;

/**
 *
 * @author HaQuocTuan
 */
public class UserDAO {

    private Connection conn;

    public UserDAO() {
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

    /**
     * lay danh sach cho user
     * @return 
     */
    public ArrayList<KySu> getListForUser() {
        ArrayList<KySu> list = new ArrayList<>();
        String sql = "select HoTen, NamSinh, GioiTinh, DiaChi, ChucVu, MoTa \n"
                + "from CanBo \n";
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
//    
    /**
     * Tìm kiếm Cán bộ theo tên
     * @param name
     * @return 
     */
    public ArrayList<KySu> search(String name) {
        ArrayList<KySu> list = new ArrayList<>();
        String sql = "select HoTen, NamSinh, GioiTinh, DiaChi, ChucVu, MoTa \n"
                + "from CanBo \n"
                + "where HoTen = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
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
    
    // Update 
    
    public int updateCanBo(KySu ks)
    {
        String sql="update CanBo set HoTen=?, NamSinh=?, GioiTinh=?, DiaChi=?, "
                + "Password=? "
                + "where IDCanBo=?";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, ks.getHoten());
            ps.setString(2, ks.getNamsinh());
            ps.setString(3, ks.getGioitinh());
            ps.setString(4, ks.getDiachi());
            ps.setString(5, ks.getChucvu());
            ps.setInt(6, ks.getID());
            if(ps.executeUpdate()>0)
            {
                System.out.println("Successful!!!");
            }
             else{
                System.out.println("Failed :(((((");
            }
        } catch (Exception e) {
        }
        return -1;
    }
    public static void main(String[] args) {
        new UserDAO();
    }
}
