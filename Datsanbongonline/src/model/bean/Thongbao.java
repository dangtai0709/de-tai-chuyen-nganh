package model.bean;

public class Thongbao {
	private String mataikhoan, mathongbao, noidung;

	public Thongbao() {
		super();
	}

	public Thongbao(String mataikhoan, String mathongbao, String noidung) {
		super();
		this.mataikhoan = mataikhoan;
		this.mathongbao = mathongbao;
		this.noidung = noidung;
	}

	@Override
	public String toString() {
		return "Thongbao [mataikhoan=" + mataikhoan + ", mathongbao=" + mathongbao + ", noidung=" + noidung + "]";
	}

	public String getMataikhoan() {
		return mataikhoan;
	}

	public void setMataikhoan(String mataikhoan) {
		this.mataikhoan = mataikhoan;
	}

	public String getMathongbao() {
		return mathongbao;
	}

	public void setMathongbao(String mathongbao) {
		this.mathongbao = mathongbao;
	}

	public String getNoidung() {
		return noidung;
	}

	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}
}
