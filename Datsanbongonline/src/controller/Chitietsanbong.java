package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.DatsanBO;
import model.bo.SanbongBO;

/**
 * Servlet implementation class Chitietsanbong
 */
public class Chitietsanbong extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Chitietsanbong() {
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

		String masanbong = request.getParameter("masanbong");
		String ngay = request.getParameter("ngay");
		SanbongBO sb = new SanbongBO();
		DatsanBO ds = new DatsanBO();
		request.setAttribute("sanbong", sb.sanbong(masanbong, ngay));
		request.setAttribute("ngay", ngay);
		request.setAttribute("santrong", ds.dadat(masanbong, ngay));

		String mataikhoan = request.getParameter("idtk");
		String tennguoidat = request.getParameter("ten");

		String batdau = request.getParameter("batdau");

		if ((null != mataikhoan) && (null != tennguoidat) && (null != ngay) && (null != batdau)) {
			String lienhe = request.getParameter("sdt");
			String ghichu = request.getParameter("ghichu");
			String idsan = request.getParameter("idsan");
			if (ds.datsan(mataikhoan, idsan, tennguoidat, ngay, batdau, lienhe, ghichu)) {

				request.setAttribute("thongbao", "<script>alert('Đã đặt sân thành công');</script>");

			} else {

				request.setAttribute("thongbao", "<script>alert('Đặt sân thất bại');</script>");

			}
			RequestDispatcher rd = request.getRequestDispatcher("Datsannhanh");
			rd.forward(request, response);
			return;
		}

		RequestDispatcher rd = request.getRequestDispatcher("/chitietsanbong.jsp");
		rd.forward(request, response);

	}

}
