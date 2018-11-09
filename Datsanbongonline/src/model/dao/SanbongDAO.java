package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Sanbong;
import model.bo.TaikhoanBO;

public class SanbongDAO {
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

	public Sanbong sanbong(String masanbong) {
		connect();
		String sql = "select * from sanbong where masanbong=?";
		ResultSet rs = null;
		ResultSet rs1 = null;
		Sanbong sb = new Sanbong();
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, masanbong);
			rs = pstm.executeQuery();
			while (rs.next()) {

				sb.setAnh(rs.getString("anh"));
				sb.setGia1(rs.getString("gia1"));
				sb.setGia2(rs.getString("gia2"));
				sb.setGia3(rs.getString("gia3"));
				sb.setGia4(rs.getString("gia4"));
				sb.setGia5(rs.getString("gia5"));
				sb.setSosan(rs.getString("sosan"));
				sb.setLoaisan(rs.getString("loaisan"));
				sb.setMasanbong(rs.getString("masanbong"));
				sb.setMataikhoan(rs.getString("mataikhoan"));
				sb.setTensan(rs.getString("tensan"));
				sb.setKhuvuc(rs.getString("khuvuc"));
				sb.setThongtin(rs.getString("thongtin"));
				// sb.setThoigiandatdat(rs.getString("thoigiandatdat"));
				// select batdau,ketthuc from datsan where masanbong=? And ngay=?
				String sql1 = "select count(*) as sandadat from datsan where masanbong=? ";
				PreparedStatement pstm1 = connection.prepareStatement(sql1);
				pstm1.setString(1, sb.getMasanbong());
				
				rs1 = pstm1.executeQuery();
				int dadat = 0;
				while (rs1.next()) {
					dadat = rs1.getInt("sandadat");
				}
				int sosantrong = Integer.parseInt(sb.getSosan()) * 5 - dadat;
				sb.setSosantrong(Integer.toString(sosantrong));
				TaikhoanBO tk = new TaikhoanBO();
				sb.setChusan(tk.thongtintaikhoan(sb.getMataikhoan()));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb;
	}
	public Sanbong sanbong(String masanbong,String ngay) {
		connect();
		String sql = "select * from sanbong where masanbong=?";
		ResultSet rs = null;
		ResultSet rs1 = null;
		Sanbong sb = new Sanbong();
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, masanbong);
			rs = pstm.executeQuery();
			while (rs.next()) {

				sb.setAnh(rs.getString("anh"));
				sb.setGia1(rs.getString("gia1"));
				sb.setGia2(rs.getString("gia2"));
				sb.setGia3(rs.getString("gia3"));
				sb.setGia4(rs.getString("gia4"));
				sb.setGia5(rs.getString("gia5"));
				sb.setSosan(rs.getString("sosan"));
				sb.setLoaisan(rs.getString("loaisan"));
				sb.setMasanbong(rs.getString("masanbong"));
				sb.setMataikhoan(rs.getString("mataikhoan"));
				sb.setTensan(rs.getString("tensan"));
				sb.setKhuvuc(rs.getString("khuvuc"));
				sb.setThongtin(rs.getString("thongtin"));
				// sb.setThoigiandatdat(rs.getString("thoigiandatdat"));
				// select batdau,ketthuc from datsan where masanbong=? And ngay=?
				String sql1 = "select count(*) as sandadat from datsan where masanbong=? and ngay=?";
				PreparedStatement pstm1 = connection.prepareStatement(sql1);
				pstm1.setString(1, sb.getMasanbong());
				pstm1.setString(2, ngay);
				
				rs1 = pstm1.executeQuery();
				int dadat = 0;
				while (rs1.next()) {
					dadat = rs1.getInt("sandadat");
				}
				int sosantrong = Integer.parseInt(sb.getSosan()) * 5 - dadat;
				sb.setSosantrong(Integer.toString(sosantrong));
				TaikhoanBO tk = new TaikhoanBO();
				sb.setChusan(tk.thongtintaikhoan(sb.getMataikhoan()));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb;
	}
public void capnhat(String masanbong, String mataikhoan, String loaisan, String tensan, String anh, String thongtin,
		String khuvuc, String sosan, String gia1, String gia2, String gia3, String gia4, String gia5) {
	connect();
	String sql = "INSERT INTO sanbong VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	
	
		PreparedStatement pstm;
		try {
			pstm = connection.prepareStatement(sql);
			pstm.setString(1, masanbong);
			pstm.setString(2, mataikhoan);
			pstm.setString(3, loaisan);
			pstm.setString(4, tensan);
			pstm.setString(5, anh);
			pstm.setString(6, thongtin);
			pstm.setString(7, khuvuc);
			pstm.setString(8, gia1);
			pstm.setString(9, gia2);
			pstm.setString(10, gia3);
			pstm.setString(11, gia4);
			pstm.setString(12, gia5);
			pstm.setString(13, sosan);
			
			 pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	
	
}
	public Sanbong sanbonga(String masanbong) {
		connect();
		String sql = "select * from sanbong where mataikhoan=?";
		ResultSet rs = null;
		ResultSet rs1 = null;
		Sanbong sb = new Sanbong();
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, masanbong);
			rs = pstm.executeQuery();
			while (rs.next()) {

				sb.setAnh(rs.getString("anh"));
				sb.setGia1(rs.getString("gia1"));
				sb.setGia2(rs.getString("gia2"));
				sb.setGia3(rs.getString("gia3"));
				sb.setGia4(rs.getString("gia4"));
				sb.setGia5(rs.getString("gia5"));
				sb.setSosan(rs.getString("sosan"));
				sb.setLoaisan(rs.getString("loaisan"));
				sb.setMasanbong(rs.getString("masanbong"));
				sb.setMataikhoan(rs.getString("mataikhoan"));
				sb.setTensan(rs.getString("tensan"));
				sb.setKhuvuc(rs.getString("khuvuc"));
				sb.setThongtin(rs.getString("thongtin"));
				// sb.setThoigiandatdat(rs.getString("thoigiandatdat"));
				// select batdau,ketthuc from datsan where masanbong=? And ngay=?
				String sql1 = "select count(*) as sandadat from datsan where masanbong=? ";
				PreparedStatement pstm1 = connection.prepareStatement(sql1);
				pstm1.setString(1, sb.getMasanbong());
				
				rs1 = pstm1.executeQuery();
				int dadat = 0;
				while (rs1.next()) {
					dadat = rs1.getInt("sandadat");
				}
				int sosantrong = Integer.parseInt(sb.getSosan()) * 5 - dadat;
				sb.setSosantrong(Integer.toString(sosantrong));
				TaikhoanBO tk = new TaikhoanBO();
				sb.setChusan(tk.thongtintaikhoan(sb.getMataikhoan()));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb;
	}

	public ArrayList<Sanbong> dssanbong() {
		connect();
		String sql = "select * from sanbong";
		ResultSet rs = null;
		ResultSet rs1 = null;
		ArrayList<Sanbong> ds = new ArrayList<>();
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Sanbong sb = new Sanbong();
				sb.setAnh(rs.getString("anh"));
				// sb.setGia1(rs.getString("gia1"));
				// sb.setGia2(rs.getString("gia2"));
				// sb.setGia3(rs.getString("gia3"));
				// sb.setGia4(rs.getString("gia4"));
				// sb.setGia5(rs.getString("gia5"));
				sb.setSosan(rs.getString("sosan"));
				sb.setLoaisan(rs.getString("loaisan"));
				sb.setMasanbong(rs.getString("masanbong"));
				sb.setMataikhoan(rs.getString("mataikhoan"));
				sb.setTensan(rs.getString("tensan"));
				sb.setKhuvuc(rs.getString("khuvuc"));
				sb.setThongtin(rs.getString("thongtin"));
				// sb.setThoigiandatdat(rs.getString("thoigiandatdat"));
				// select batdau,ketthuc from datsan where masanbong=? And ngay=?
				String ngay= java.time.LocalDate.now().toString();
				String sql1 = "select count(*) as sandadat from datsan where masanbong=? and ngay=?";
				PreparedStatement pstm1 = connection.prepareStatement(sql1);
				pstm1.setString(1, sb.getMasanbong());
				pstm1.setString(2, ngay);
				rs1 = pstm1.executeQuery();
				int dadat = 0;
				while (rs1.next()) {
					dadat = rs1.getInt("sandadat");
				}
				int sosantrong = Integer.parseInt(sb.getSosan()) * 5 - dadat;
				sb.setSosantrong(Integer.toString(sosantrong));
				TaikhoanBO tk = new TaikhoanBO();
				sb.setChusan(tk.thongtintaikhoan(sb.getMataikhoan()));

				ds.add(sb);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds;
	}

	public ArrayList<Sanbong> dssanbong(String khuvuc, String ngay) {
		connect();
		String sql = "select * from sanbong where khuvuc like '%" + khuvuc + "%'";
		ResultSet rs = null;
		ResultSet rs1 = null;
		ArrayList<Sanbong> ds = new ArrayList<>();
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);

			rs = pstm.executeQuery();
			while (rs.next()) {
				Sanbong sb = new Sanbong();
				sb.setAnh(rs.getString("anh"));
				// sb.setGia1(rs.getString("gia1"));
				// sb.setGia2(rs.getString("gia2"));
				// sb.setGia3(rs.getString("gia3"));
				// sb.setGia4(rs.getString("gia4"));
				// sb.setGia5(rs.getString("gia5"));
				sb.setSosan(rs.getString("sosan"));
				sb.setLoaisan(rs.getString("loaisan"));
				sb.setMasanbong(rs.getString("masanbong"));
				sb.setMataikhoan(rs.getString("mataikhoan"));
				sb.setTensan(rs.getString("tensan"));
				sb.setKhuvuc(rs.getString("khuvuc"));
				sb.setThongtin(rs.getString("thongtin"));

				String sql1 = "select count(*) as sandadat from datsan where masanbong=? and ngay=? ";
				PreparedStatement pstm1 = connection.prepareStatement(sql1);
				pstm1.setString(1, sb.getMasanbong());
				pstm1.setString(2, ngay);
				
				rs1 = pstm1.executeQuery();
				int dadat = 0;
				while (rs1.next()) {
					dadat = rs1.getInt("sandadat");
				}
				int sosantrong = Integer.parseInt(sb.getSosan()) * 5 - dadat;
				sb.setSosantrong(Integer.toString(sosantrong));
				TaikhoanBO tk = new TaikhoanBO();
				sb.setChusan(tk.thongtintaikhoan(sb.getMataikhoan()));
				if (sosantrong > 0) {
					ds.add(sb);
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds;
	}

	public static void main(String[] args) {
		SanbongDAO a = new SanbongDAO();
		System.out.println(a.sanbong("SB01"));
		//a.capnhat(masanbong, mataikhoan, loaisan, tensan, anh, thongtin, khuvuc, sosan, gia1, gia2, gia3, gia4, gia5);
		a.capnhat("SB02", "TK2", "1", "abc", "abc", "abc", "abc", "abc", "1", "2", "3", "4", "6");
	}
}
