package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import custom_01.CustomInfo;
import custom_01.CustomList;
import custom_01.CustomUpdate;

@WebServlet("*.l3")
public class L3Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getServletPath();
		String view = null;
		Command custom = null;
		
		//회원목록 조회 요청
		if(uri.equals("/list.l3")) {
			//비지니스로직
			custom = new CustomList();
			custom.execute(request, response);
			
//			CustomList custom = new CustomList();
			
			//응답화면
			view = "custom/list.jsp";
		}
		
		//회원정보 조회 요청
		else if(uri.equals("/info.l3")) {
			//비지니스로직
			custom = new CustomInfo();
			custom.execute(request, response);
			
			//응답화면
			view = "custom/info.jsp";
		}
		
		//회원정보 수정 요청
		else if(uri.equals("/modify.l3")) {
			custom = new CustomInfo();
			custom.execute(request, response);
			
			view = "custom/modify.jsp";
		}
		
		//회원정보 업데이트
		else if(uri.equals("/update.l3")) {
			custom = new CustomUpdate();
			custom.execute(request, response);
			
			view = "info.l3?id=" + request.getParameter("p_id");
		}
		
		request.getRequestDispatcher(view).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
