<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div><a href="./">홈으로</a></div> 
<hr>
<h2>출력하기</h2>
<div>1~10 출력</div>

<%
for(int no=1; no<=10; no++){
%>
	<div><%=no %></div>
	<%
}
	%>
<hr>
<%
for(int no=1; no<=10; no++){
	out.print("<div>"+ no + "</div>");
}

%>
<!-- <div>1</div> -->
<!-- <div>10</div> -->
</body>
</html>