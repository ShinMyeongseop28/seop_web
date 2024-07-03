<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원정보 수정</h2>
<form method="post" action="update.l3">
<table border="1">
<tr><th>아이디</th>
<td><input type="text" value="${ dto.p_id }" name="p_id" readonly="readonly"> </td>
</tr>
<tr><th>이름</th>
<td><input type="text" value="${ dto.c_name }" name="c_name"> </td>
</tr>
<tr><th>이메일</th>
<td><input type="text" value="${ dto.c_email }" name="c_email"> </td>
</tr>
<tr><th>연락처</th>
<td><input type="text" value="${ dto.c_tel }" name="c_tel"> </td>
</tr>
</table>
<button>저장하기</button>
<button type="button" onclick="location='info.l3?id=${dto.p_id}'">취소하기</button>
</form>
</body>
</html>