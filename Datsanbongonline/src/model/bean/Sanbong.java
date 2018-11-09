package model.bean;

public class Sanbong {
private String masanbong,mataikhoan,loaisan,tensan,anh,thongtin,khuvuc;
private String sosan,gia1,gia2,gia3,gia4,gia5,sosantrong;
private Taikhoan chusan;
public Taikhoan getChusan() {
	return chusan;
}
@Override
public String toString() {
	return "Sanbong [masanbong=" + masanbong + ", mataikhoan=" + mataikhoan + ", loaisan=" + loaisan + ", tensan="
			+ tensan + ", anh=" + anh + ", thongtin=" + thongtin + ", khuvuc=" + khuvuc + ", sosan=" + sosan + ", gia1="
			+ gia1 + ", gia2=" + gia2 + ", gia3=" + gia3 + ", gia4=" + gia4 + ", gia5=" + gia5 + ", sosantrong="
			+ sosantrong + ", chusan=" + chusan + "]";
}
public void setChusan(Taikhoan chusan) {
	this.chusan = chusan;
}
public String getSosantrong() {
	return sosantrong;
}
public void setSosantrong(String sosantrong) {
	this.sosantrong = sosantrong;
}
public String getMasanbong() {
	return masanbong;
}
public void setMasanbong(String masanbong) {
	this.masanbong = masanbong;
}
public String getMataikhoan() {
	return mataikhoan;
}
public void setMataikhoan(String mataikhoan) {
	this.mataikhoan = mataikhoan;
}
public String getLoaisan() {
	return loaisan;
}
public void setLoaisan(String loaisan) {
	this.loaisan = loaisan;
}
public String getTensan() {
	return tensan;
}
public void setTensan(String tensan) {
	this.tensan = tensan;
}
public String getAnh() {
	return anh;
}
public void setAnh(String anh) {
	this.anh = anh;
}
public String getThongtin() {
	return thongtin;
}
public void setThongtin(String thongtin) {
	this.thongtin = thongtin;
}
public String getKhuvuc() {
	return khuvuc;
}
public void setKhuvuc(String khuvuc) {
	this.khuvuc = khuvuc;
}
public String getSosan() {
	return sosan;
}
public void setSosan(String sosan) {
	this.sosan = sosan;
}
public String getGia1() {
	return gia1;
}
public void setGia1(String gia1) {
	this.gia1 = gia1;
}
public String getGia2() {
	return gia2;
}
public void setGia2(String gia2) {
	this.gia2 = gia2;
}
public String getGia3() {
	return gia3;
}
public void setGia3(String gia3) {
	this.gia3 = gia3;
}
public String getGia4() {
	return gia4;
}
public void setGia4(String gia4) {
	this.gia4 = gia4;
}
public String getGia5() {
	return gia5;
}
public void setGia5(String gia5) {
	this.gia5 = gia5;
}
public Sanbong(String masanbong, String mataikhoan, String loaisan, String tensan, String anh, String thongtin,
		String khuvuc, String sosan, String gia1, String gia2, String gia3, String gia4, String gia5) {
	super();
	this.masanbong = masanbong;
	this.mataikhoan = mataikhoan;
	this.loaisan = loaisan;
	this.tensan = tensan;
	this.anh = anh;
	this.thongtin = thongtin;
	this.khuvuc = khuvuc;
	this.sosan = sosan;
	this.gia1 = gia1;
	this.gia2 = gia2;
	this.gia3 = gia3;
	this.gia4 = gia4;
	this.gia5 = gia5;
}
public Sanbong() {
	super();
}

}