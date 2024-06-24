package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HobbyServlet
 */
@WebServlet("/choice")
public class HobbyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//전달된 파라미터가 한글이 있다면 한글이 깨지지 않도록 처리하기
		request.setCharacterEncoding("utf-8");
		
		//주소창을 통해 전달된 파라미터 가져오기
		String gender = request.getParameter("gender");
		System.out.println(gender);
		String[] hobby = request.getParameterValues("hobby");
		if(hobby !=null) {
			for(String h : hobby) {
				System.out.println(h);
				}
			}
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.append("<html>")
		.append("<body>")
		.append("<ul>")
		.append("<li><a href='index.html'>홈으로</a></li>")
		.append("<li><a href='choice.html'>선택화면</a></li>")
		.append("</ul>")
		.append("<hr>")
		.append("<h2>선택화면</h2>")
		.append("</body>")
		.append("</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
