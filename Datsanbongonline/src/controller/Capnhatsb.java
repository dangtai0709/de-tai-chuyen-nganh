package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Capnhatsb
 */
public class Capnhatsb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Capnhatsb() {
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
		String Id= request.getParameter("Id");
		String loaisan=request.getParameter("loaisan");
		String ten= request.getParameter("ten");
		String khuvuc=request.getParameter("khuvuc");
		String anhdaidien= request.getParameter("anhdaidien");
		String gia1=request.getParameter("gia1");
		String gia2=request.getParameter("gia2");
		String gia3=request.getParameter("gia3");
		String gia4=request.getParameter("gia4");
		String gia5=request.getParameter("gia5");
		String sosan= request.getParameter("sosan");
		String gioithieu= request.getParameter("gioithieu");
	}

}
