package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import level5.DeleteLevel5;
import level5.InsertLevel5;
import level5.ListLevel5;
import level5.SearchLevel5;
import level5.UpdateLevel5;

@WebServlet("*.l5")
public class L5Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getServletPath();
		String view = null;
		boolean redirect = false;
		
		//제조사명 조회화면 요청
		if(uri.equals("/search.l5")) {
			
			//응답화면
			view = "level5/search.jsp";
		}
		
		//제품코드 목록화면 요청
		else if( uri.equals("/list.l5")) {
			//비지니스로직
			new ListLevel5().execute(request, response);		
					
			//응답화면
			view = "level5/list.jsp";
		}
		
		//제품코드 수정화면 요청
		else if(uri.equals("/modify.l5")) {
			//비지니스로직
			new SearchLevel5().execute(request, response);
			
			//응답화면
			view = "level5/modify.jsp";
		}
		
		//제품코드 삭제처리 요청
		else if(uri.equals("/delete.l5")) {
			//비지니스 로직
			new DeleteLevel5().execute(request, response);
			
			//응답화면
			view = "list.l5";
			redirect = true;
		}
		
		//제품코드 등록화면 요청
		else if(uri.equals("/register.l5")) {
			
			//응답화면
			view = "level5/register.jsp";
		}
	
		if( redirect )
			response.sendRedirect(view);
		else
			request.getRequestDispatcher(view).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getServletPath();
		String view = null;
		boolean forward = true;
		
		//제조사명 조회처리 요청
		if(uri.equals("/search.l5")) {
			//비지니스 로직
			new SearchLevel5().execute(request, response);
			
			//응답화면
			view = "level5/result.jsp";
		}
		
		//제품코드에 대한 제조사명 변경저장 처리요청
		else if(uri.equals("/update.l5")) {
			//비지니스로직
			new UpdateLevel5().execute(request, response);
			
			//응답화면
			forward = false;
			view = "search.l5?code=" + request.getParameter("code");
		}
		
		//제품코드 신규등록 처리요청
		else if(uri.equals("/insert.l5")) {
			//비지니스 로직
			new InsertLevel5().execute(request, response);
			
			//응답화면
			forward = false;
			view = "list.l5";
		}
		
		
		if( forward )
			request.getRequestDispatcher(view).forward(request, response);
		else
			response.sendRedirect(view);
	}

}
