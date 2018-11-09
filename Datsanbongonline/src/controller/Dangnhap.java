package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.TaikhoanBO;

/**
 * Servlet implementation class Dangnhap
 */
public class Dangnhap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dangnhap() {
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

		String Password = request.getParameter("Password");
		TaikhoanBO tk = new TaikhoanBO();
	
		String ten = request.getParameter("UserName");
		if (tk.checkLogin(ten, Password)) {
			session.setAttribute("taikhoan", tk.thongtintaikhoan(ten, Password));
			response.sendRedirect("Quanli");
			return;
		} else {
			   
			     String loi = "<script>alert('Đăng nhập không thành công! Kiểm tra lại');</script>";
			     request.setAttribute("loi", loi);
	    	
		   
			RequestDispatcher rd = request.getRequestDispatcher("Index");
			rd.forward(request, response);
		}

	}
	

}
