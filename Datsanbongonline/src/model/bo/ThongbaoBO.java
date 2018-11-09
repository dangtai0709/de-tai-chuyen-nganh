package model.bo;

import java.util.ArrayList;

import model.bean.Thongbao;
import model.dao.ThongbaoDAO;

public class ThongbaoBO {
	ThongbaoDAO tb=new ThongbaoDAO();
	public ArrayList<Thongbao> dsthongbao(String mataikhoan){
		return tb.dsthongbao(mataikhoan);
	}
	public void xoathongbao(String mataikhoan, String mathongbao) {
		tb.xoathongbao(mataikhoan, mathongbao);
	}
	public ArrayList<Thongbao> dsthongbao(){
		return tb.dsthongbao();
	}
	public void themthongbao(String mataikhoan,String noidung) {
		tb.themthongbao(mataikhoan, noidung);
	}
}
