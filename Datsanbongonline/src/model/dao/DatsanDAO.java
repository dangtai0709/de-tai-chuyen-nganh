package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Datsan;
import model.bean.Sanbong;

public class DatsanDAO {
	String url = "jdbc:sqlserver://localhost:1433;databaseName=sanbong";
	String userName = "sa";
	String password = "123456";
	Connection connection;

	void connect() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Datsan> dsdatsan(String mataikhoan) {
		connect();
		String sql = "select * from datsan where mataikhoan=? ORDER BY ngay DESC";
		ResultSet rs = null;
		ArrayList<Datsan> ds = new ArrayList<>();
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, mataikhoan);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Datsan db = new Datsan();
				db.setBatdau(rs.getString("batdau"));
				db.setGhichu(rs.getString("ghichu"));
				db.setLienhe(rs.getString("lienhe"));
				db.setMasanbong(rs.getString("masanbong"));
				db.setMataikhoan(rs.getString("mataikhoan"));
				db.setNgay(rs.getString("ngay"));
				db.setTennguoidat(rs.getString("tennguoidat"));
				

				ds.add(db);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds;
	}
	public ArrayList<Datsan> dsdatsana(String mataikhoan) {
		connect();
		String sql = "select * from datsan where masanbong=? ORDER BY ngay DESC";
		ResultSet rs = null;
		ArrayList<Datsan> ds = new ArrayList<>();
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, mataikhoan);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Datsan db = new Datsan();
				db.setBatdau(rs.getString("batdau"));
				db.setGhichu(rs.getString("ghichu"));
				db.setLienhe(rs.getString("lienhe"));
				db.setMasanbong(rs.getString("masanbong"));
				db.setMataikhoan(rs.getString("mataikhoan"));
				db.setNgay(rs.getString("ngay"));
				db.setTennguoidat(rs.getString("tennguoidat"));
			

				ds.add(db);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds;
	}

	public ArrayList<Integer> dadat(String masanbong, String ngay) {
		int dadat = 0;
		ArrayList<Integer> ds = new ArrayList<>();
		connect();
		String sql = "select count(*) as dadat from datsan where masanbong=? and ngay=? and batdau=? ";
		ResultSet rs = null;
		try {
			for (int i = 0; i <= 5; i++) {
				PreparedStatement pstm = connection.prepareStatement(sql);
				pstm.setString(1, masanbong);
				pstm.setString(2, ngay);
				pstm.setInt(3, i);
			
				rs = pstm.executeQuery();
				while (rs.next()) {
					dadat = rs.getInt("dadat");
					ds.add(dadat);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ds;
	}

	public Boolean kiemtra(String masanbong, String ngay, String batdau) {
		int dadat = 0;
		SanbongDAO sb = new SanbongDAO();
		Sanbong sb1 = sb.sanbong(masanbong);
		connect();
		String sql = "select count(*) as dadat from datsan where masanbong=? and ngay=? and batdau=? ";
		ResultSet rs = null;
		try {

			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, masanbong);
			pstm.setString(2, ngay);
			pstm.setString(3, batdau);
			
			rs = pstm.executeQuery();
			while (rs.next()) {
				dadat = rs.getInt("dadat");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (dadat > Integer.parseInt(sb1.getSosan()))
			return false;
		else
			return true;
	}

	public Boolean datsan(String mataikhoan, String masanbong, String tennguoidat, String ngay, String batdau,
			String lienhe, String ghichu) {
		connect();
		String sql = "INSERT INTO datsan VALUES (?,?,?,?,?,?,?)";

		if (mataikhoan == "") {
			String sql1 = "select COUNT(*) as tk from datsan";
			PreparedStatement pstm1;
			try {
				mataikhoan = "TD";
				pstm1 = connection.prepareStatement(sql1);
				ResultSet rs = pstm1.executeQuery();
				while (rs.next()) {
					mataikhoan = mataikhoan + (rs.getInt("tk") + 1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, mataikhoan);
			pstm.setString(2, masanbong);
			pstm.setString(3, tennguoidat);
			pstm.setString(4, ngay);
			pstm.setString(5, batdau);
			pstm.setString(6, lienhe);
			pstm.setString(7, ghichu);

			if (kiemtra(masanbong, ngay, batdau)) {
			
				pstm.executeUpdate();
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	public void xoadatsan(String mataikhoan, String masanbong, String ngay, String batdau) {
		connect();
		String sql = "DELETE FROM datsan where mataikhoan=? and masanbong=? and ngay=? and batdau=?";
		ResultSet rs = null;
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, mataikhoan);
			pstm.setString(2, masanbong);
			pstm.setString(3, ngay);
			pstm.setString(4, batdau);
			pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		DatsanDAO a = new DatsanDAO();
//a.xoadatsan("TD100", "SB01", "2018-10-30", "1");
//	System.out.println(a.dsdatsana("SB01"));
//		SanbongDAO sb= new SanbongDAO();
//		System.out.println(a.dadat("SB01", "2018-11-06").toString());
//		System.out.println(sb.sanbong("SB01"));
		System.out.println(a.datsan("TK2", "SB01", "trung", "2018-12-2", "3", "xx", "xx"));
	}
}
