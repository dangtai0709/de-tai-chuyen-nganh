package model.bo;

import java.util.ArrayList;

import model.bean.Datsan;
import model.dao.DatsanDAO;

public class DatsanBO {
	DatsanDAO ds = new DatsanDAO();

	public ArrayList<Datsan> dsdatsan(String mataikhoan) {
		return ds.dsdatsan(mataikhoan);
	}
	public ArrayList<Datsan> dsdatsana(String mataikhoan) {
		return ds.dsdatsana(mataikhoan);
	}

	public ArrayList<Integer> dadat(String masanbong, String ngay) {
		return ds.dadat(masanbong, ngay);
	}

	public Boolean datsan(String mataikhoan, String masanbong, String tennguoidat, String ngay, String batdau,
			String lienhe, String ghichu) {
		return ds.datsan(mataikhoan, masanbong, tennguoidat, ngay, batdau, lienhe, ghichu);
	}
	public void xoadatsan(String mataikhoan, String masanbong, String ngay, String batdau) {
		ds.xoadatsan(mataikhoan, masanbong, ngay, batdau);
	}
}
