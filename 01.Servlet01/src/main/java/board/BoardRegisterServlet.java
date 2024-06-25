package board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/register")
public class BoardRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	System.out.println("board/register");
	
		//게시글쓰기 화면에서 입력한 정보로 
		//응답화면 만들기
		//전달된 파라미터의 한글값이 깨지지 않도록 처리
//		request.setCharacterEncoding("utf-8");
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
	
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<ul>");
		out.print("<li><a href='../index.html'>홈으로</a></li>");
		out.print("<li><a href='register.html'>게시글쓰기화면</a></li>");
		out.print("</ul>");
		
		out.print("<h2>게시글정보</h2>");
		out.printf("<div>작성자: %s</div>", writer);
		out.printf("<div>제목: %s</div>", title);
		out.printf("<div>내용: %s</div>", content);
		
		out.print("</body>");
		out.print("<html>");
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}