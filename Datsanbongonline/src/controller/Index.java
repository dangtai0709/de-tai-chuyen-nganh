package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.TaikhoanBO;
import model.bo.ThongbaoBO;

/**
 * Servlet implementation class Index
 */
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Index() {
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

		String Name, sdt, Password;
		Name = request.getParameter("Name");
		sdt = request.getParameter("sdt");
		Password = request.getParameter("Password");
		TaikhoanBO tk = new TaikhoanBO();
		String loi =(String) request.getAttribute("loi");
		
		
		if ((null != Name) && (null != sdt)) {
			if (tk.taotaikhoan(Name, sdt, Password)) {
				session.setAttribute("taikhoan", tk.thongtintaikhoan(sdt, Password));
				response.sendRedirect("Quanli");
				return;
			} else {

				loi = " <div class='alert alert-danger'> <strong>Lỗi</strong>Tài khoản đã tồn tại </div>";
			}
		}if(null!=loi) {
		request.setAttribute("loi", loi);
		}
		ThongbaoBO tb = new ThongbaoBO();
		request.setAttribute("thongbao", tb.dsthongbao());
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);

	}

}
