package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.l3")
public class L3Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getServletPath();
		String view = null;
		boolean forward = true;
		
		//l3문제 목록화면 요청
		if(uri.equals("/list.l3")) {
			//응답화면
			view = "l3/list.jsp";
		}
		else if(uri.equals("register.l3")) {
			//비지니스 로직
			
			//응답화면
			view = "l3/modify.jsp";
		}
		
		if(forward) 
			request.getRequestDispatcher(view).forward(request, response);
		else
			response.sendRedirect(view);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
