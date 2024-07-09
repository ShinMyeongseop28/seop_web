package Controller;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.DeleteCommand;
import customer.InfoCommand;
import customer.ListCommand;
import customer.UpdateCommand;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet("*.do")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getServletPath();
		String view = null;
		boolean redirect = false;
		
		//고객관리화면(고객목록화면) 요청
		if(uri.equals("/list.do")) {
			// 비지니스 로직
			new ListCommand().execute(request, response);
			
			// 응답화면
			view = "customer/list.jsp";
		}
		//고객정보화면 요청
		else if(uri.equals("/info.do")) {
			//비지니스 로직
			new InfoCommand().execute(request, response);
			
			//응답화면
			view = "customer/info.jsp";
		}
		//고객정보 수정화면 요청
		else if(uri.equals("/modify.do")) {
			//비지니스 로직
			new InfoCommand().execute(request, response);
			
			//응답화면
			view = "customer/modify.jsp";
		}
		//고객정보 수정저장 처리 요청
		else if(uri.equals("/update.do" )) {
			//비지니스 로직
			new UpdateCommand().execute(request, response);
			
			//응답화면
			view = "info.do?id=" + request.getParameter("id");
			redirect = true;
		}
		//고객정보 삭제처리 요청
		else if(uri.equals("/delete.do")) {
			//비지니스 로직
			new DeleteCommand().execute(request, response);
			
			//응답화면
			view = "list.do";
			redirect = true;
		}
		
		if (redirect) {
			response.sendRedirect(view);
		} else
			request.getRequestDispatcher(view).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
