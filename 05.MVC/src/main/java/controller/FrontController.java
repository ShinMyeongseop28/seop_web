package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import hr.EmployeeListCommand;
import model.EmployeeDTO;
import model.HrDAO;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//주소의 요청 확인
		String uri = request.getServletPath();
		String view = "";
		boolean redirect = false;
		
		if( uri.equals("/select.do")) {
			//비지니스 로직
			Command command = new EmployeeListCommand();
			command.execute(request, response);

			//응답화면 연결
			view = "hr/list.jsp";
			
		}else if (uri.equals("/insert.do")) {
			//비지니스 로직
			
			//응답화면 연결
			view = "";
			redirect = true;
			
		}else if (uri.equals("/update.do")) {
			//비지니스 로직
			
			//응답화면 연결
			view = "";
			redirect = true;
			
		}else if (uri.equals("/delete.do")) {
			//비지니스 로직
			//DB에서 삭제처리
			System.out.println("삭제처리");
			
			//응답화면 연결
			view = "hr/list.jsp";
			redirect = true;
			
		}
		if( redirect ) {
			response.sendRedirect(view);
		}else {
			request.getRequestDispatcher(view).forward(request, response);			
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
