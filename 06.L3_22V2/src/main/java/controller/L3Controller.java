package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import custom_01.CustomDelete;
import custom_01.CustomInfo;
import custom_01.CustomInsert;
import custom_01.CustomList;
import custom_01.CustomUpdate;

@WebServlet("*.l3")
public class L3Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getServletPath();
		String view = null;
		Command custom = null;
		boolean redirect = false;
		
		//신규회원 등록처리 요청
		if(uri.equals("/insert.l3")) {
			//비지니스로직
			custom = new CustomInsert();
			custom.execute(request, response);
			//응답화면
			redirect = true;
			view = "list.l3";
		}
		
		//신규회원 등록화면 요청
		else if(uri.equals("/register.l3")) {
			//응답화면
			view = "custom/register.jsp";
		}
		
		//회원목록 화면 요청
		else if(uri.equals("/list.l3")) {
			//비지니스로직
			custom = new CustomList();
			custom.execute(request, response);
			
//			CustomList custom = new CustomList();
			
			//응답화면
			view = "custom/list.jsp";
		}
		
		//회원정보 화면 요청
		else if(uri.equals("/info.l3")) {
			//비지니스로직
			custom = new CustomInfo();
			custom.execute(request, response);
			
			//응답화면
			view = "custom/info.jsp";
		}
		
		//회원정보 수정화면 요청
		else if(uri.equals("/modify.l3")) {
			//비지니스로직
			custom = new CustomInfo();
			custom.execute(request, response);
			
			//응답화면
			view = "custom/modify.jsp";
		}
		
		//회원정보 변경저장처리 요청
		else if(uri.equals("/update.l3")) {
			//비지니스로직
			custom = new CustomUpdate();
			custom.execute(request, response);
			
			//응답화면
			view = "info.l3?id=" + request.getParameter("p_id");
			redirect = true;
		}
		
		//회원정보 삭제처리 요청
		else if(uri.equals("/delete.l3")) {
			//비지니스로직
			custom = new CustomDelete();
			custom.execute(request, response);
			
			//응답화면
			view = "list.l3";
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
