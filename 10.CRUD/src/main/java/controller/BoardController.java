package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.ListCommand;

@WebServlet("*.bo")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getServletPath();
		String view = null;
		boolean redirect = false;
		
		//게시판 조회화면 요청
		if(uri.equals("/list.bo")) {
			//비지니스 로직
			new ListCommand().execute(request, response);
			
			//응답화면
			view = "board/list.jsp";
		}
		
		if (redirect)
			response.sendRedirect(view);
		else
			request.getRequestDispatcher(view).forward(request, response);
	}
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
