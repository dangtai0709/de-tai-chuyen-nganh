package model.bo;

import java.util.ArrayList;

import model.bean.Sanbong;
import model.dao.SanbongDAO;

public class SanbongBO {
SanbongDAO DAO= new SanbongDAO();
public ArrayList<Sanbong> dssanbong(String khuvuc,String ngay){
	return DAO.dssanbong(khuvuc, ngay);
}
public ArrayList<Sanbong> dssanbong(){
	return DAO.dssanbong();
}
public Sanbong sanbong( String masanbong) {
	return DAO.sanbong(masanbong);
}
public Sanbong sanbonga( String masanbong) {
	return DAO.sanbonga(masanbong);
}
public Sanbong sanbong(String masanbong,String ngay) {
	return DAO.sanbong(masanbong, ngay);
}
}
