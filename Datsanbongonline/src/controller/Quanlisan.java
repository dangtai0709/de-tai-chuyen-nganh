package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Xuli;
import model.bean.Taikhoan;
import model.bo.DatsanBO;
import model.bo.SanbongBO;

/**
 * Servlet implementation class Quanlisan
 */
public class Quanlisan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Quanlisan() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if (session.getAttribute("taikhoan") == null) {
			response.sendRedirect("Index");
			return;
			
		}
		DatsanBO ds = new DatsanBO();
		Taikhoan tk1 = (Taikhoan) session.getAttribute("taikhoan");
		String ma= request.getParameter("mataikhoan");
		String masanbong = request.getParameter("masanbong");
		String ngay = request.getParameter("ngay");
		String batdau = request.getParameter("batdau");
		if (null != ngay) {
			ds.xoadatsan(ma, masanbong, ngay, batdau);
		}

		request.setAttribute("dsdatsan", ds.dsdatsana(Xuli.masanbong(tk1.getMataikhoan())));
		SanbongBO sb= new SanbongBO();
		//request.setAttribute("sanbong", sb.sanbonga(Xuli.masanbong(tk1.getMataikhoan())));//chua them vaof view
		request.setAttribute("sanbong", sb.sanbonga(tk1.getMataikhoan()));// chua them nut luu
		RequestDispatcher rd = request.getRequestDispatcher("user/quanli_san.jsp");
		rd.forward(request, response);

	}

}
