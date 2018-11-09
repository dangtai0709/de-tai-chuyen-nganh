package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.SanbongBO;

/**
 * Servlet implementation class Datsannhanh
 */
public class Datsannhanh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Datsannhanh() {
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
		
		SanbongBO sb= new SanbongBO();
		String khuvuc=request.getParameter("khuvuc");
		String ngay=request.getParameter("ngay");
		if((null!=khuvuc)&&(null!=ngay)) {
			request.setAttribute("dssb", sb.dssanbong(khuvuc, ngay));
		}
			
		request.setAttribute("dssb", sb.dssanbong());
		RequestDispatcher rd = request.getRequestDispatcher("dat-san-nhanh.jsp");
		rd.forward(request, response);
	}

}
