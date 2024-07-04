package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;

/**
 * Servlet implementation class L5Controller
 */
@WebServlet("/L5Controller")
public class L5Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getServletPath();
		String view = null;
		boolean redirect = false;
		
		Command code = null;
		
		//제조사조회 화면 요청
		if(uri.equals("/searach.l5")) {
			//응답화면 연결
			view = "l5/search.html";
		}
		if(redirect)
			response.sendRedirect(view);
		else
			request.getRequestDispatcher(view).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
