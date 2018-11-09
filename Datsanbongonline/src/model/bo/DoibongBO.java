package model.bo;

import java.util.ArrayList;

import model.bean.Doibong;
import model.dao.DoibongDAO;

public class DoibongBO {
	DoibongDAO DAO = new DoibongDAO();

	public ArrayList<Doibong> dsdoibong(String timdoi) {
		return DAO.dsdoibong(timdoi);
	}
	public ArrayList<Doibong> dsdoibong() {
		return DAO.dsdoibong();
	}
	public ArrayList<Doibong> dsdoibonga(String khuvuc) {
		return DAO.dsdoibonga(khuvuc);
	}

	public ArrayList<Doibong> dsdoibong(String tendoi,String timdoi) {
		return DAO.dsdoibong(tendoi, timdoi);
	}
	public Doibong thongtin(String mataikhoan) {
		return DAO.thongtin(mataikhoan);
	}
	public void capnhat(String mataikhoan, String tendoi, String khuvuc, String trinhdo, String anh,
			String timdoi, String cosan, String thoigianthuongda, String gioithieu) {
		DAO.capnhat(mataikhoan, tendoi, khuvuc, trinhdo, anh, timdoi, cosan, thoigianthuongda, gioithieu);
	}
}