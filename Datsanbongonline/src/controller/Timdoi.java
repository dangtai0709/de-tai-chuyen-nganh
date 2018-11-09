package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.DoibongBO;

/**
 * Servlet implementation class Timdoi
 */
public class Timdoi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Timdoi() {
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
		String khuvuc= request.getParameter("khuvuc");
		DoibongBO db= new DoibongBO();
		if(null!=khuvuc) {
		request.setAttribute("danhsach", db.dsdoibong(khuvuc,"on"));
		}else {
		request.setAttribute("danhsach", db.dsdoibong("on"));
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("tim-doi-da-bong.jsp");
		rd.forward(request, response);
	}

}
