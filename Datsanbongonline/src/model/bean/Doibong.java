package model.bean;

public class Doibong {
private String madoibong,mataikhoan,tendoi,khuvuc,trinhdo,anh,timdoi,cosan,thoigianthuongda,gioithieu;
public Taikhoan doitruong;
public String getMadoibong() {
	return madoibong;
}
public void setMadoibong(String madoibong) {
	this.madoibong = madoibong;
}
public String getMataikhoan() {
	return mataikhoan;
}
public void setMataikhoan(String mataikhoan) {
	this.mataikhoan = mataikhoan;
}
public String getTendoi() {
	return tendoi;
}
public void setTendoi(String tendoi) {
	this.tendoi = tendoi;
}
public String getKhuvuc() {
	return khuvuc;
}
public void setKhuvuc(String khuvuc) {
	this.khuvuc = khuvuc;
}
public String getTrinhdo() {
	return trinhdo;
}
public void setTrinhdo(String trinhdo) {
	this.trinhdo = trinhdo;
}
public String getAnh() {
	return anh;
}
public void setAnh(String anh) {
	this.anh = anh;
}
public String getTimdoi() {
	return timdoi;
}
public void setTimdoi(String timdoi) {
	this.timdoi = timdoi;
}
public String getCosan() {
	return cosan;
}
public void setCosan(String cosan) {
	this.cosan = cosan;
}
public String getThoigianthuongda() {
	return thoigianthuongda;
}
public void setThoigianthuongda(String thoigianthuongda) {
	this.thoigianthuongda = thoigianthuongda;
}
public String getGioithieu() {
	return gioithieu;
}
public void setGioithieu(String gioithieu) {
	this.gioithieu = gioithieu;
}
public Taikhoan getDoitruong() {
	return doitruong;
}
public void setDoitruong(Taikhoan doitruong) {
	this.doitruong = doitruong;
}
public Doibong() {
	super();
}
public Doibong(String madoibong, String mataikhoan, String tendoi, String khuvuc, String trinhdo, String anh,
		String timdoi, String cosan, String thoigianthuongda, String gioithieu, Taikhoan doitruong) {
	super();
	this.madoibong = madoibong;
	this.mataikhoan = mataikhoan;
	this.tendoi = tendoi;
	this.khuvuc = khuvuc;
	this.trinhdo = trinhdo;
	this.anh = anh;
	this.timdoi = timdoi;
	this.cosan = cosan;
	this.thoigianthuongda = thoigianthuongda;
	this.gioithieu = gioithieu;
	this.doitruong = doitruong;
}
@Override
public String toString() {
	return "Doibong [madoibong=" + madoibong + ", mataikhoan=" + mataikhoan + ", tendoi=" + tendoi + ", khuvuc="
			+ khuvuc + ", trinhdo=" + trinhdo + ", anh=" + anh + ", timdoi=" + timdoi + ", cosan=" + cosan
			+ ", thoigianthuongda=" + thoigianthuongda + ", gioithieu=" + gioithieu + ", doitruong=" + doitruong + "]";
}



}
