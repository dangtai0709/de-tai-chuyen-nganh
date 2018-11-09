package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Doibong;
import model.bean.Taikhoan;
import model.bo.TaikhoanBO;

public class DoibongDAO {
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

	public void capnhat(String mataikhoan, String tendoi, String khuvuc, String trinhdo, String anh, String timdoi,
			String cosan, String thoigianthuongda, String gioithieu) {

		connect();
		String sql = "select * from doibong where mataikhoan=?";
		ResultSet rs = null;

		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, mataikhoan);
			rs = pstm.executeQuery();
			if (rs.next()) {
				String sql1 = "UPDATE doibong SET tendoi=?,trinhdo=?,anh=?,timdoi=?,cosan=?,thoiogianthuongda=?,gioithieu=?,khuvuc=? where mataikhoan=?";
				PreparedStatement pstm1 = connection.prepareStatement(sql1);
				pstm1.setString(1, tendoi);
				pstm1.setString(2, trinhdo);
				pstm1.setString(3, anh);
				pstm1.setString(4, timdoi);
				pstm1.setString(5, cosan);
				pstm1.setString(6, thoigianthuongda);
				pstm1.setString(7, gioithieu);
				pstm1.setString(8, khuvuc);
				pstm1.setString(9, mataikhoan);
				pstm1.executeUpdate();

			} else {
				String sql1 = "INSERT INTO doibong VALUES(?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement pstm1 = connection.prepareStatement(sql1);
				String madoibong = "DB";
				String sql2 = "select count(*) as db from doibong";
				PreparedStatement pstm2 = connection.prepareStatement(sql2);
				rs = pstm2.executeQuery();
				while (rs.next()) {
					madoibong += rs.getInt("db");
				}

				pstm1.setString(1, madoibong);
				pstm1.setString(2, mataikhoan);
				pstm1.setString(3, tendoi);
				pstm1.setString(4, trinhdo);
				pstm1.setString(5, anh);
				pstm1.setString(6, timdoi);
				pstm1.setString(7, cosan);
				pstm1.setString(8, thoigianthuongda);
				pstm1.setString(9, gioithieu);
				pstm1.setString(10, khuvuc);
				pstm1.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Doibong thongtin(String mataikhoan) {
		Doibong db = new Doibong();
		connect();
		String sql = "select * from doibong where mataikhoan=?";
		ResultSet rs = null;

		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, mataikhoan);
			rs = pstm.executeQuery();
			while (rs.next()) {

				db.setAnh(rs.getString("anh"));
				db.setCosan(rs.getString("cosan"));
				db.setGioithieu(rs.getString("gioithieu"));
				db.setKhuvuc(rs.getString("khuvuc"));
				db.setMadoibong(rs.getString("madoibong"));
				db.setMataikhoan(mataikhoan);
				db.setTendoi(rs.getString("tendoi"));
				db.setThoigianthuongda(rs.getString("thoiogianthuongda"));
				db.setTimdoi(rs.getString("timdoi"));
				String trinhdo=rs.getString("trinhdo");
				
				db.setTrinhdo(trinhdo);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return db;

	}

	public ArrayList<Doibong> dsdoibong(String timdoi) {
		connect();
		String sql = "select * from doibong where timdoi=?";
		ResultSet rs = null;
		TaikhoanBO tk = new TaikhoanBO();
		ArrayList<Doibong> ds = new ArrayList<>();
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, timdoi);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Doibong db = new Doibong();
				db.setAnh(rs.getString("anh"));
				db.setCosan(rs.getString("cosan"));
				db.setGioithieu(rs.getString("gioithieu"));
				db.setKhuvuc(rs.getString("khuvuc"));
				db.setMadoibong(rs.getString("madoibong"));
				String mataikhoan = rs.getString("mataikhoan");
				db.setMataikhoan(mataikhoan);
				db.setTendoi(rs.getString("tendoi"));
				db.setThoigianthuongda(rs.getString("thoiogianthuongda"));
				db.setTimdoi(rs.getString("timdoi"));
				db.setTrinhdo(rs.getString("trinhdo"));
				db.setDoitruong(tk.thongtintaikhoan(mataikhoan));
				ds.add(db);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds;
	}
	public ArrayList<Doibong> dsdoibong() {
		connect();
		String sql = "select * from doibong ";
		ResultSet rs = null;
		TaikhoanBO tk = new TaikhoanBO();
		ArrayList<Doibong> ds = new ArrayList<>();
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			
			rs = pstm.executeQuery();
			while (rs.next()) {
				Doibong db = new Doibong();
				db.setAnh(rs.getString("anh"));
				db.setCosan(rs.getString("cosan"));
				db.setGioithieu(rs.getString("gioithieu"));
				db.setKhuvuc(rs.getString("khuvuc"));
				db.setMadoibong(rs.getString("madoibong"));
				String mataikhoan = rs.getString("mataikhoan");
				db.setMataikhoan(mataikhoan);
				db.setTendoi(rs.getString("tendoi"));
				db.setThoigianthuongda(rs.getString("thoiogianthuongda"));
				db.setTimdoi(rs.getString("timdoi"));
				db.setTrinhdo(rs.getString("trinhdo"));
				db.setDoitruong(tk.thongtintaikhoan(mataikhoan));
				ds.add(db);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds;
	}

	public ArrayList<Doibong> dsdoibong(String tendoi, String timdoi) {
		connect();
		String sql = "select * from doibong where khuvuc like '%" + tendoi + "%' and timdoi=?";

		ResultSet rs = null;
		ArrayList<Doibong> ds = new ArrayList<>();

		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, timdoi);
			rs = pstm.executeQuery();
			while (rs.next()) {
				TaikhoanDAO tk = new TaikhoanDAO();
				Doibong db = new Doibong();
				db.setAnh(rs.getString("anh"));
				db.setCosan(rs.getString("cosan"));
				db.setGioithieu(rs.getString("gioithieu"));
				db.setKhuvuc(rs.getString("khuvuc"));
				db.setMadoibong(rs.getString("madoibong"));
				db.setMataikhoan(rs.getString("mataikhoan"));
				db.setTendoi(rs.getString("tendoi"));
				db.setThoigianthuongda(rs.getString("thoiogianthuongda"));
				db.setTimdoi(rs.getString("timdoi"));
				db.setTrinhdo(rs.getString("trinhdo"));
				db.setDoitruong(tk.thongtintaikhoan(rs.getString("mataikhoan")));

				ds.add(db);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds;
	}
	public ArrayList<Doibong> dsdoibonga(String khuvuc) {
		connect();
		String sql = "select * from doibong where khuvuc like '%" + khuvuc + "%' ";

		ResultSet rs = null;
		ArrayList<Doibong> ds = new ArrayList<>();

		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			
			rs = pstm.executeQuery();
			while (rs.next()) {
				TaikhoanDAO tk = new TaikhoanDAO();
				Doibong db = new Doibong();
				db.setAnh(rs.getString("anh"));
				db.setCosan(rs.getString("cosan"));
				db.setGioithieu(rs.getString("gioithieu"));
				db.setKhuvuc(rs.getString("khuvuc"));
				db.setMadoibong(rs.getString("madoibong"));
				db.setMataikhoan(rs.getString("mataikhoan"));
				db.setTendoi(rs.getString("tendoi"));
				db.setThoigianthuongda(rs.getString("thoiogianthuongda"));
				db.setTimdoi(rs.getString("timdoi"));
				db.setTrinhdo(rs.getString("trinhdo"));
				db.setDoitruong(tk.thongtintaikhoan(rs.getString("mataikhoan")));

				ds.add(db);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds;
	}

	public static void main(String[] args) {
		DoibongDAO a = new DoibongDAO();
		a.capnhat("TK10", "aaaaa", "ssss", "s2222", "s2222df", "2222sdf", "s2222df", "s222df", "s22222df");
	//System.out.println(a.thongtin("TK0100"));
		
	}
}
