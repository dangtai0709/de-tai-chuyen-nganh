package model.bean;

public class Datsan {
	private String mataikhoan, masanbong, tennguoidat, ngay, batdau, lienhe, ghichu, trangthai;

	public Datsan() {
		super();
	}

	@Override
	public String toString() {
		return "Datsan [mataikhoan=" + mataikhoan + ", masanbong=" + masanbong + ", tennguoidat=" + tennguoidat
				+ ", ngay=" + ngay + ", batdau=" + batdau + ", lienhe=" + lienhe + ", ghichu=" + ghichu + ", trangthai="
				+ trangthai + "]";
	}

	public Datsan(String mataikhoan, String masanbong, String tennguoidat, String ngay, String batdau, String lienhe,
			String ghichu, String trangthai) {
		super();
		this.mataikhoan = mataikhoan;
		this.masanbong = masanbong;
		this.tennguoidat = tennguoidat;
		this.ngay = ngay;
		this.batdau = batdau;
		this.lienhe = lienhe;
		this.ghichu = ghichu;
		this.trangthai = trangthai;
	}

	public String getMataikhoan() {
		return mataikhoan;
	}

	public void setMataikhoan(String mataikhoan) {
		this.mataikhoan = mataikhoan;
	}

	public String getMasanbong() {
		return masanbong;
	}

	public void setMasanbong(String masanbong) {
		this.masanbong = masanbong;
	}

	public String getTennguoidat() {
		return tennguoidat;
	}

	public void setTennguoidat(String tennguoidat) {
		this.tennguoidat = tennguoidat;
	}

	public String getNgay() {
		return ngay;
	}

	public void setNgay(String ngay) {
		this.ngay = ngay;
	}

	public String getBatdau() {
		return batdau;
	}

	public void setBatdau(String batdau) {
		this.batdau = batdau;
	}

	public String getLienhe() {
		return lienhe;
	}

	public void setLienhe(String lienhe) {
		this.lienhe = lienhe;
	}

	public String getGhichu() {
		return ghichu;
	}

	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}

	public String getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}
}
