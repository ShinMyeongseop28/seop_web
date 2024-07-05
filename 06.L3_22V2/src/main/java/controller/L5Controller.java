package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import custom_01.CustomUpdate;
import l5.CodeInsert;
import l5.CodeSearch;
import l5.CodeUpdate;

/**
 * Servlet implementation class L5Controller
 */
@WebServlet("*.l5")
public class L5Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getServletPath();
		String view = null;
		boolean redirect = false;
		
		Command code = null;
		
		//제조사등록 처리 요청
		if(uri.equals("/insert.l5")) {
			//비지니스 로직
			code = new CodeInsert();
			code.execute(request, response);
			
			view = "search.l5";
			redirect = true;
		}
		
		//제조사등록 화면 요청
		else if(uri.equals("/register.l5")) {
			view = "l5/register.jsp";
		}
		
		//제조사조회 화면 요청
		if(uri.equals("/search.l5")) {
			//응답화면 연결
			view = "l5/search.html";
		}
		
		//제품코드 조회 결과 화면 요청
		else if(uri.equals("/reference.l5")) {
			//비지니스 로직
			code = new CodeSearch();
			code.execute(request, response);
			
			//응답화면 연결
			view = "l5/reference.jsp";
		}
		
		//제조사 변경화면 요청
		else if(uri.equals("/modify.l5")) {
			//비지니스 로직
			code = new CodeSearch();
			code.execute(request, response);
			
			//응답화면
			view = "l5/modify.jsp";
		}
		
		//제조사 변경 저장 처리
		else if(uri.equals("/update.l5")) {
			//비지니스로직
			code = new CodeUpdate();
			code.execute(request, response);
			
			//응답화면
			view = "search.l5?id=" + request.getParameter("code");
			redirect = true;
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
