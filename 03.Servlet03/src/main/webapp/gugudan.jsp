<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div><a href='./'>홈으로</a></div>
<hr>
<h2>구구단 3단 출력</h2></h2>

<%
int dan = 3;
out.println("<div>" + dan + "단" + "</div>");
for(int no=1; no<10; no++) {
	out.println("<div>" + dan + " X " + no + " = " + (dan*no) + "</div>");
}
%>
</body>
</html>