package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Taikhoan;
import model.bo.DoibongBO;
import model.bo.TaikhoanBO;

/**
 * Servlet implementation class Capnhattk
 */
public class Capnhattk extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Capnhattk() {
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
	
		
		 TaikhoanBO tk= new TaikhoanBO();
			String ten= request.getParameter("ten");
			String email= request.getParameter("email");
			String id= request.getParameter("Id");
			String anh= request.getParameter("anhdaidien");
			String matkhau= request.getParameter("matkhau");
			String sdt= request.getParameter("sdt");

				tk.capnhattaikhoan(id, email, matkhau, anh, ten);
				session.setAttribute("taikhoan", tk.thongtintaikhoan(sdt, matkhau));
				response.sendRedirect("Quanlitaikhoan");
	}

}
