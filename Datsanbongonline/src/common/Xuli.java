package common;

import model.bean.Sanbong;
import model.bo.SanbongBO;

public class Xuli {

	public static String timdoi(String x) {
	if(x.equals("on")) {
		return "Cần đi khách";
	}
	return "Đã có đối";
}
	public static String cosan(String x) {
	if(x.equals("on")) {
		return "Đã có sân";
	}
	return "Chưa có sân";
}
	public static String loaisan(String x) {
		if(x.equals("1"))
			return "Sân cỏ nhân tạo";
		if(x.equals("2"))
			return "Sân tự nhiên";
		return "Sân cát";
	}
	public static String trinhdo(String x) {
		if("1".equals(x)) {
			return "Mới chơi";
		}
		if("2".equals(x)) {
			return "Trung bình";
		}
		if("3".equals(x)) {
			return "Trung bình khá";
		}if("4".equals(x)) {
			return "Phủi";
		}if("5".equals(x)) {
			return "Trung bình yếu";
		}if("6".equals(x)) {
			return "Mềm";
		}if("7".equals(x)) {
			return "Rất mềm";
		}if("8".equals(x)) {
			return "Khá";
		}
		return "Khá Mạnh";
			
	}
	public static String batdau(String x) {
		if("1".equals(x)) {
			return "6h-16h";
		}
		if("2".equals(x)) {
			return "16h-17h30";
		}
		if("3".equals(x)) {
			return "17h30-19h";
		}if("4".equals(x)) {
			return "Phủi";
		}if("5".equals(x)) {
			return "19h-20h30";
		}if("6".equals(x)) {
			return "20h30-22h";
		}
		return "Khá Mạnh";
			
	}
	public static String tensan(String x) {
		SanbongBO sb= new SanbongBO();
		Sanbong sb1= sb.sanbong(x);
		return sb1.getTensan();
	}
	public static String masanbong(String x) {
		SanbongBO sb= new SanbongBO();
		Sanbong sb1= sb.sanbonga(x);
		return sb1.getMasanbong();
	}
	
		
}
