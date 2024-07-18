package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.DeleteBoard;
import board.InfoBoard;
import board.InsertBoard;
import board.ListCommand;
import board.UpdateBoard;

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
		
		//게시판 세부내용 조회화면 요청
		else if(uri.equals("/info.bo")) {
			//비지니스 로직
			new InfoBoard().execute(request, response);
			
			//응답화면
			view = "board/info.jsp";
		}
		
		//게시판 수정화면 요청
		else if(uri.equals("/modify.bo")) {
			//비지니스 로직
			new InfoBoard().execute(request, response);
			
			//응답화면
			view = "board/modify.jsp";
		}
		
		//게시판 수정처리 저장요청
		else if(uri.equals("/update.bo")) {
			//비지니스 로직
			new UpdateBoard().execute(request, response);
			
			//응답화면
			view = "info.bo?id=" + request.getParameter("numb");
			redirect = true;
		}
		
		//게시판 삭제처리 요청
		else if(uri.equals("/delete.bo")) {
			//비지니스 로직
			new DeleteBoard().execute(request, response);
			
			//응답화면
			view = "list.bo";
		}
		
		//게시판 글쓰기 요청
		else if(uri.equals("/register.bo")) {
			//비지니스 로직
			
			//응답화면
			view = "board/register.jsp";
		}
		
		//게시판 글쓰기 저장처리 요청
		else if(uri.equals("/insert.bo")) {
			//비지니스 로직
			new InsertBoard().execute(request, response);
			
			//응답화면
			view = "list.bo";
			redirect = true;
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
