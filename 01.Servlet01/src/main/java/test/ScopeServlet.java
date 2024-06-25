package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/scope")
public class ScopeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//애플리케이션(context)정보
		ServletContext context = getServletContext();
		//application scope에 저장
		context.setAttribute("app", "Application Scope Data");
		
		//세션정보
		HttpSession session = request.getSession();
		//session scope에 저장
		session.setAttribute("session", "Session Scope Data");
		
		//request scope에 저장
		request.setAttribute("request", "Request Scope Data");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<h2>Scope 정보</h2>");
		out.printf("<div>Request: %s</div>", request.getAttribute("request"));
		out.printf("<div>Session: %s</div>", session.getAttribute("session"));
		out.printf("<div>Application: %s</div>", context.getAttribute("app"));
		
		out.print("</body>");
		out.print("</html>");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}