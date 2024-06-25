package calculator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculatorForward
 */
@WebServlet("/redirectView") //forward방식으로 응답된 화면
public class CalculatorRedirect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request에 저장된 attribute 정보 꺼내기
		String no1 = (String)request.getAttribute("no1");
		String no2 = (String)request.getAttribute("no2");
		String operator = (String)request.getAttribute("operator");
		String result = (String)request.getAttribute("result");
		
		// 프리젠테이션 로직
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<ul>");
		out.print("<li><a href='.html'>홈으로</a></li>");
		out.print("<li><a href='calculator.html'>계산기화면</a></li>");
		out.print("</ul>");
		out.print("<hr>");
		out.print("<h2>계산결과</h2>");
		out.printf("%d %s %d = %d", no1, operator, no2, result);
		out.print("</body>");
		out.print("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
