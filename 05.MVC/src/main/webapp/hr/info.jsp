<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>사원정보</h2>
<table border="1">
<tr><th>사번</th>
<td>${dto.employee_id }</td>
</tr>
<tr><th>성</th>
<td>${dto.last_name }</td>
</tr>
<tr><th>명</th>
<td>${dto.first_name }</td>
</tr>
</table>
<button onclick="location='modify.do?id=${dto.employee_id}'">수정하기</button>
</body>
</html>