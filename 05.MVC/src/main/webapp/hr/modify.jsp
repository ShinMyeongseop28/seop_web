<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>사원정보 수정</h2>
<form method="post" action="update.do">
<input type="hidden" name="employee_id" value="${dto.employee_id }">
<table border="1">
<tr><th>사번</th>
<td>${dto.employee_id}</td>
</tr>
<tr><th>성</th>
<td><input type="text" value="${dto.last_name }" name="last_name"></td>
</tr>
<tr><th>명</th>
<td><input type="text" value="${dto.first_name }" name="first_name"></td>
</tr>
</table>

<button>저장하기</button>
<button type="button"
onclick="location='info.do?id=${dto.employee_id}'">취소하기</button>
</form>
</body>
</html>