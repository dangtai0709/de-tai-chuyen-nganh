package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import model.bean.Thongbao;

public class ThongbaoDAO {
	String url = "jdbc:sqlserver://localhost:1433;databaseName=sanbong";
	String userName = "sa";
	String password = "123456";
	Connection connection;
	
	void connect(){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void xoathongbao(String mataikhoan, String mathongbao) {
		connect();
		String sql="delete from thongbao where mataikhoan=? and mathongbao=?";
		
		try {
			PreparedStatement pstm= connection.prepareStatement(sql);
			pstm.setString(1, mataikhoan);
			pstm.setString(2,mathongbao);
			pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void themthongbao(String mataikhoan,String noidung) {
		connect();
		String sql="INSERT INTO  thongbao VALUES (?,?)";
		
		try {
			PreparedStatement pstm= connection.prepareStatement(sql);
			pstm.setString(1, mataikhoan);
			pstm.setString(2,noidung);
			pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<Thongbao> dsthongbao(String mataikhoan){
		connect();
		String sql="select * from thongbao where mataikhoan=?";
		ResultSet rs = null;
		ArrayList<Thongbao> ds= new ArrayList<>();
		try {
			PreparedStatement pstm= connection.prepareStatement(sql);
			pstm.setString(1, mataikhoan);
			rs=pstm.executeQuery();
			while(rs.next()) {
				Thongbao tb= new Thongbao();
				tb.setMataikhoan(rs.getString("mataikhoan"));
				tb.setMathongbao(rs.getString("mathongbao"));
				tb.setNoidung(rs.getString("noidung"));
				
				ds.add(tb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			return ds; 	
	}
	public ArrayList<Thongbao> dsthongbao(){
		connect();
		String sql="select * from thongbao ";
		ResultSet rs = null;
		ArrayList<Thongbao> ds= new ArrayList<>();
		try {
			PreparedStatement pstm= connection.prepareStatement(sql);
		
			rs=pstm.executeQuery();
			while(rs.next()) {
				Thongbao tb= new Thongbao();
				tb.setMataikhoan(rs.getString("mataikhoan"));
				tb.setMathongbao(rs.getString("mathongbao"));
				tb.setNoidung(rs.getString("noidung"));
				
				ds.add(tb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return ds; 	
	}
	public static void main(String[] args) {
		ThongbaoDAO a= new ThongbaoDAO();
		a.themthongbao("Tk01", "abc");
	}
}
