package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Taikhoan;

public class TaikhoanDAO {
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

	public boolean checkLogin(String tenDangNhap, String matKhau) {
		connect();
		String sql = "SELECT * FROM taikhoan WHERE (email=? or sodienthoai=?) and matkhau=? ";
		ResultSet rs = null;
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, tenDangNhap);
			pstm.setString(2, tenDangNhap);
			pstm.setString(3, matKhau);
			rs = pstm.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				rs.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	public Taikhoan thongtintaikhoan(String tenDangNhap, String matKhau) {
		connect();
		Taikhoan a = new Taikhoan();
		String sql = "SELECT * FROM taikhoan WHERE (email=? or sodienthoai=?) and matkhau=? ";
		ResultSet rs = null;
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, tenDangNhap);
			pstm.setString(2, tenDangNhap);
			pstm.setString(3, matKhau);
			rs = pstm.executeQuery();
			while (rs.next()) {
				a.setLogo(rs.getString("anh"));
				a.setEmail(rs.getString("email"));
				a.setMataikhoan(rs.getString("mataikhoan"));
				a.setMatkhau(rs.getString("matkhau"));
				a.setSdt(rs.getString("sodienthoai"));
				a.setTen(rs.getString("ten"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				rs.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return a;
	}
	public Taikhoan thongtintaikhoan(String mataikhoan) {
		connect();
		Taikhoan a = new Taikhoan();
		String sql = "SELECT * FROM taikhoan WHERE mataikhoan=?";
		ResultSet rs = null;
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, mataikhoan);
			rs = pstm.executeQuery();
			while (rs.next()) {
				a.setLogo(rs.getString("anh"));
				a.setEmail(rs.getString("email"));
				a.setMataikhoan(rs.getString("mataikhoan"));
				a.setMatkhau(rs.getString("matkhau"));
				a.setSdt(rs.getString("sodienthoai"));
				a.setTen(rs.getString("ten"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				rs.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return a;
	}

	public ArrayList<Taikhoan> danhsachtaikhoan() {
		connect();

		String sql = "SELECT * FROM taikhoan  ";
		ResultSet rs = null;
		ArrayList<Taikhoan> ds = new ArrayList<>();
		
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);

			rs = pstm.executeQuery();
			while (rs.next()) {
				Taikhoan a = new Taikhoan();
				a.setLogo(rs.getString("anh"));
				a.setEmail(rs.getString("email"));
				a.setMataikhoan(rs.getString("mataikhoan"));
				a.setMatkhau(rs.getString("matkhau"));
				a.setSdt(rs.getString("sodienthoai"));
				a.setTen(rs.getString("ten"));
				ds.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				rs.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ds;
	}

	public Boolean taotaikhoan(String ten, String sdt, String matkhau) {
		connect();
		String sql1 = "select COUNT(*) as tk from taikhoan";
		String sql = "INSERT INTO taikhoan VALUES (?,?,?,?,?,?) ";
		ResultSet rs = null;
		PreparedStatement pstm1 = null;
		try {
			pstm1 = connection.prepareStatement(sql1);
			rs = pstm1.executeQuery();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String mataikhoan = "TK";
		try {
			while (rs.next()) {
				mataikhoan = mataikhoan + (rs.getInt("tk") + 1);

			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sql2 = "select * from taikhoan where sodienthoai=?";
		try {
			pstm1 = connection.prepareStatement(sql2);
			pstm1.setString(1, sdt);
			rs = pstm1.executeQuery();
			if (rs.next())
				return false;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {

			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, mataikhoan);
			pstm.setString(2, ten);
			pstm.setString(3, "");
			pstm.setString(4, sdt);
			pstm.setString(5, "./images/user/default-user.png");
			pstm.setString(6, matkhau);
			
			if (pstm.executeUpdate() == 1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {

			try {
				rs.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}

	public Boolean capnhattaikhoan(String mataikhoan, String email, String matkhau, String anh, String ten) {
		connect();
		
		String sql = "update taikhoan set email=?,matkhau=?,anh=?,ten=? where mataikhoan=? ";
		ResultSet rs = null;
		
		
				PreparedStatement pstm;
				try {
					pstm = connection.prepareStatement(sql);
			
				pstm.setString(1, email);
				pstm.setString(2, matkhau);
				pstm.setString(3, anh);
				pstm.setString(4, ten);
				pstm.setString(5, mataikhoan);
				if (pstm.executeUpdate() < 1)
					return true;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return true;

	}

	public static void main(String[] args) {
		TaikhoanDAO a = new TaikhoanDAO();
//		System.out.println(a.checkLogin("123890", "123456"));
//		System.out.println(a.taotaikhoan("abc", "abc6", "abc"));
	//System.out.println(a.capnhattaikhoan("TK12", "127dssdsdsd", "1234","", "abc"));
	//	System.out.println(a.thongtintaikhoan("TK4"));
	
	}

}
