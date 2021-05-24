/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.KySu;

/**
 *
 * @author HaQuocTuan
 */
public class AdminDAO {

    private Connection conn;

    public AdminDAO() {
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
     * getdata cho admin
     *
     * @return
     */
    public ArrayList<KySu> getListForAdmin() {
        ArrayList<KySu> list = new ArrayList<>();
        String sql = "select IDCanBo,HoTen, NamSinh, GioiTinh, DiaChi, ChucVu, MoTa, Username, Password, isAdmin \n"
                + "from CanBo ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KySu s = new KySu();
                s.setID(rs.getInt("IDCanBo"));
                s.setHoten(rs.getString("HoTen"));
                s.setNamsinh(rs.getString("NamSinh"));
                s.setGioitinh(rs.getString("GioiTinh"));
                s.setDiachi(rs.getString("DiaChi"));
                s.setChucvu(rs.getString("ChucVu"));
                s.setMota(rs.getString("MoTa"));
                s.setUsername(rs.getString("Username"));
                s.setPassword(rs.getString("Password"));
                s.setIsAdmin(Integer.parseInt(rs.getString("isAdmin")));
                list.add(s);
                PrintWriter pw = new PrintWriter("F:\\AccountCB.txt");

                for (KySu kySu : list) {
                    pw.print(kySu.getID());
                    pw.print(";  " + kySu.getUsername());
                    pw.print(";  " + kySu.getPassword());
                    pw.print("\n");

                }
                pw.close();
                FileReader fr = new FileReader("F:\\AccountCB.txt");
                BufferedReader br = new BufferedReader(fr);
                String line = "";
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
                br.close();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * them can bo moi
     *
     * @param s
     * @param username
     * @param password
     * @return
     */
    public int addPerson(KySu s) {
        String sql = "INSERT INTO CanBo VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getHoten());
            ps.setString(2, s.getNamsinh());
            ps.setString(3, s.getGioitinh());
            ps.setString(4, s.getDiachi());
            ps.setString(5, s.getChucvu());
            ps.setString(6, s.getMota());
            ps.setString(7, s.getUsername());
            ps.setString(8, s.getPassword());
            ps.setInt(9, s.getIsAdmin());
            if (ps.executeUpdate() > 0) {
                System.out.println("Successful!!!");
            } else {
                System.out.println("Failed :(((((");
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return -1;
    }

    // Update
    public int updateCv(KySu ks) {
        String sql = "Update CanBo set HoTen=?, NamSinh=?, GioiTinh=?, DiaChi=?, "
                + "ChucVu=?, MoTa=?,Username=? "
                + "where IDCanBo=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ks.getHoten());
            ps.setString(2, ks.getNamsinh());
            ps.setString(3, ks.getGioitinh());
            ps.setString(4, ks.getDiachi());
            ps.setString(5, ks.getChucvu());
            ps.setString(6, ks.getMota());
            ps.setString(7, ks.getUsername());
            ps.setInt(8, ks.getID());
            if (ps.executeUpdate() > 0) {
                System.out.println("Successful!!!");
            } else {
                System.out.println("Failed :(((((");
            }
            return 1;
        } catch (Exception e) {
        }
        return -1;
    }

    // Delete 
    public int deleteCv(KySu ks) {
        String sql = "delete CanBo where IDCanBo=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, ks.getID());
            if (ps.executeUpdate() > 0) {
                System.out.println("Successful!!!");
            } else {
                System.out.println("Failed :(((((");
            }
            return 1;
        } catch (Exception e) {
        }
        return -1;
    }

    /**
     * sap xep danh sach theo ten
     *
     * @return
     */
    public ArrayList<KySu> sortByName() {
        ArrayList<KySu> list = new ArrayList<>();
        String sql = "select IDCanBo,HoTen, NamSinh, GioiTinh, DiaChi, ChucVu, MoTa, Username, Password, isAdmin \n"
                + "from CanBo "
                + "order by HoTen";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KySu s = new KySu();
                s.setID(rs.getInt("IDCanBo"));
                s.setHoten(rs.getString("HoTen"));
                s.setNamsinh(rs.getString("NamSinh"));
                s.setGioitinh(rs.getString("GioiTinh"));
                s.setDiachi(rs.getString("DiaChi"));
                s.setChucvu(rs.getString("ChucVu"));
                s.setMota(rs.getString("MoTa"));
                s.setUsername(rs.getString("Username"));
                s.setPassword(rs.getString("Password"));
                s.setIsAdmin(Integer.parseInt(rs.getString("isAdmin")));
                list.add(s);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * sap xep danh sach theo nam sinh
     *
     * @return
     */
    public ArrayList<KySu> sortByDate() {
        ArrayList<KySu> list = new ArrayList<>();
        String sql = "select IDCanBo,HoTen, NamSinh, GioiTinh, DiaChi, ChucVu, MoTa, Username, Password, isAdmin \n"
                + "from CanBo "
                + "order by NamSinh";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KySu s = new KySu();
                s.setID(rs.getInt("IDCanBo"));
                s.setHoten(rs.getString("HoTen"));
                s.setNamsinh(rs.getString("NamSinh"));
                s.setGioitinh(rs.getString("GioiTinh"));
                s.setDiachi(rs.getString("DiaChi"));
                s.setChucvu(rs.getString("ChucVu"));
                s.setMota(rs.getString("MoTa"));
                s.setUsername(rs.getString("Username"));
                s.setPassword(rs.getString("Password"));
                s.setIsAdmin(Integer.parseInt(rs.getString("isAdmin")));
                list.add(s);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        new AdminDAO();

    }
}
