package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Taikhoan;
import model.bo.ThongbaoBO;

/**
 * Servlet implementation class Thongbao
 */
public class Thongbao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Thongbao() {
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
		if (session.getAttribute("taikhoan") == null) {
			response.sendRedirect("Index");
			return;
		}
		Taikhoan tk1 = (Taikhoan) session.getAttribute("taikhoan");
		String matk= request.getParameter("mataikhoan");
		String matb= request.getParameter("mathongbao");
		String noidung= request.getParameter("noidung");
		ThongbaoBO tb= new ThongbaoBO();
		tb.xoathongbao(matk, matb);
		if(null!=noidung) {
		tb.themthongbao(tk1.getMataikhoan(), noidung);
		}
		request.setAttribute("thongbao", tb.dsthongbao(tk1.getMataikhoan()));
		RequestDispatcher rd = request.getRequestDispatcher("user/thongbao.jsp");
		rd.forward(request, response);

	}

}
