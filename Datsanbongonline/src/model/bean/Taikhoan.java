package model.bean;

public class Taikhoan {
private String mataikhoan,ten,email,sdt,logo,matkhau;

public String getMataikhoan() {
	return mataikhoan;
}

public void setMataikhoan(String mataikhoan) {
	this.mataikhoan = mataikhoan;
}

public String getTen() {
	return ten;
}

public void setTen(String ten) {
	this.ten = ten;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getSdt() {
	return sdt;
}

public void setSdt(String sdt) {
	this.sdt = sdt;
}

public String getLogo() {
	return logo;
}

public void setLogo(String logo) {
	this.logo = logo;
}

public String getMatkhau() {
	return matkhau;
}

public void setMatkhau(String matkhau) {
	this.matkhau = matkhau;
}

public Taikhoan(String mataikhoan, String ten, String email, String sdt, String logo, String matkhau) {
	super();
	this.mataikhoan = mataikhoan;
	this.ten = ten;
	this.email = email;
	this.sdt = sdt;
	this.logo = logo;
	this.matkhau = matkhau;
}

public Taikhoan() {
	super();
}

@Override
public String toString() {
	return "Taikhoan [mataikhoan=" + mataikhoan + ", ten=" + ten + ", email=" + email + ", sdt=" + sdt + ", logo="
			+ logo + ", matkhau=" + matkhau + "]";
}


}
