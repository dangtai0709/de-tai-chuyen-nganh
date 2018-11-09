package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Doibong;
import model.bean.Taikhoan;
import model.bo.DoibongBO;
import model.bo.TaikhoanBO;

/**
 * Servlet implementation class Quanli
 */
public class Quanli extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Quanli() {
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

		Taikhoan tk1 = (Taikhoan) session.getAttribute("taikhoan");
		DoibongBO db = new DoibongBO();
		Doibong db1 = db.thongtin(tk1.getMataikhoan());
		if (db1.getTrinhdo() == null) {
			db1.setTrinhdo("1");
			db1.setCosan("on");
			db1.setTimdoi("on");
			db1.setAnh("./images/team/sport.png");
		}
		request.setAttribute("doibong", db1);

		RequestDispatcher rd = request.getRequestDispatcher("user/quanli.jsp");
		rd.forward(request, response);

	}

}
