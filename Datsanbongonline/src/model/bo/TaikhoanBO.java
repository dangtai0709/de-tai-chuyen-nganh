package model.bo;

import java.util.ArrayList;

import model.bean.Taikhoan;
import model.dao.TaikhoanDAO;

public class TaikhoanBO {
	TaikhoanDAO DAO = new TaikhoanDAO();

	public boolean checkLogin(String tenDangNhap, String matKhau) {
		return DAO.checkLogin(tenDangNhap, matKhau);
	}
	public Boolean taotaikhoan(String ten, String sdt, String matkhau) {
		return DAO.taotaikhoan(ten, sdt, matkhau);
	}
	public Taikhoan thongtintaikhoan(String tenDangNhap, String matKhau) {
		return DAO.thongtintaikhoan(tenDangNhap, matKhau);
	}
	public Boolean capnhattaikhoan(String mataikhoan, String email, String matkhau, String anh, String ten) {
		return DAO.capnhattaikhoan(mataikhoan, email, matkhau, anh, ten);
	}
	public ArrayList<Taikhoan> danhsachtaikhoan() {
		return DAO.danhsachtaikhoan();
	}
	public Taikhoan thongtintaikhoan(String mataikhoan) {
		return DAO.thongtintaikhoan(mataikhoan);
	}
}
