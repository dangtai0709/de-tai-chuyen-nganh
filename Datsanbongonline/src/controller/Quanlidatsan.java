package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Taikhoan;
import model.bo.DatsanBO;

/**
 * Servlet implementation class Quanlidatsan
 */
public class Quanlidatsan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Quanlidatsan() {
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
		String masanbong = request.getParameter("masanbong");
		String ngay = request.getParameter("ngay");
		String batdau = request.getParameter("batdau");
		if (null != ngay) {
			ds.xoadatsan(tk1.getMataikhoan(), masanbong, ngay, batdau);
		}

		request.setAttribute("dsdatsan", ds.dsdatsan(tk1.getMataikhoan()));

		RequestDispatcher rd = request.getRequestDispatcher("user/quanli_datsan.jsp");
		rd.forward(request, response);

	}

}
