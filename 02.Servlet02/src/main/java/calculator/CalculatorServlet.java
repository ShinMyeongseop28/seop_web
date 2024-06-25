package calculator;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Calculator;

@WebServlet("/calculator")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//화면에서 입력한 두 수와 선택한 연산자를 가져오기
		//String --> int 
		int no1 = Integer.parseInt( request.getParameter("no1") );
		int no2 = Integer.valueOf( request.getParameter("no2") );
		String operator = request.getParameter("operator");
		
		//연산처리: 비지니스로직
//		int result = calculate(no1, no2, operator);
		Calculator c = new Calculator(no1, no2, operator);
		
		//응답할 화면에서 출력에 사용할 데이터가 있다면
		//request 영역에 저장하기
		request.setAttribute("no1", no1);
		request.setAttribute("no2", no2);
		request.setAttribute("operator", operator);
		request.setAttribute("result", c.getResult());
		
		//응답할 화면(View) - 프리젠테이션로직
//		RequestDispatcher rd = request.getRequestDispatcher("forwardView");
//		rd.forward(request, response);
		
		response.sendRedirect("redirectView");
	}

//	int calculate(int no1, int no2, String operator) {
//		int result = 0;
//		switch( operator ) {
//		case "+":
//				 result = no1 + no2;
//				 break;
//		case "-":
//				result = no1 - no2;
//				break;
//		case "*":
//				result = no1 * no2;
//				break;
//		default :
//				result = no1 / no2;
//				break;
//		}
//		return result;
//	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
