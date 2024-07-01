<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>사원목록</h2>
<button onclick="location='register.do'">신규사원</button>

<table border="1">
<tr><th>사번</th><th>성명</th><th></th></tr>
<c:forEach items="${ list }" var="dto" >
<tr><td>${ dto.employee_id }</td>
	<td><a href="info.do?id=${dto.employee_id}">${ dto.last_name } ${dto.first_name }</a></td>
	<td><a href="delete.do?id=${dto.employee_id}">삭제</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>