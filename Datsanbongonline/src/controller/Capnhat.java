package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Taikhoan;
import model.bo.DoibongBO;

/**
 * Servlet implementation class Capnhat
 */
public class Capnhat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Capnhat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		DoibongBO db = new DoibongBO();
		Taikhoan tk1 = (Taikhoan) session.getAttribute("taikhoan");
		String tendoi = request.getParameter("inpName");
		String khuvuc = request.getParameter("khuvuc");
		String trinhdo = request.getParameter("trinhdo");
		String anh = request.getParameter("anh");
		String timdoi = request.getParameter("timdoi");
		String cosan = request.getParameter("cosan");
		String thoigian = request.getParameter("thoigian");
		String gioithieu = request.getParameter("gioithieu");
		db.capnhat(tk1.getMataikhoan(), tendoi, khuvuc, trinhdo, anh, timdoi, cosan, thoigian, gioithieu);
		response.sendRedirect("Quanli");
	}

}
