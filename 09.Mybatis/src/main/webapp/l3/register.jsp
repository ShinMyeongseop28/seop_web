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
<jsp:include page="/include/header.jsp"/>

<h3>신규회원등록</h3>
<form method="post" action="insert.l3">
<table border="1">
<colgroup>
	<col width="200px">
	<col width="300px">
</colgroup>
<tr><th>아이디</th>
<td><input type="text" name="p_id"></td>
</tr>
<tr><th>비밀번호</th>
<td><input type="password" name="p_pw"></td>
</tr>
<tr><th>이름</th>
<td><input type="text" name="c_name"></td>
</tr>
<tr><th>이메일</th>
<td><input type="text" name="c_email"></td>
</tr>
<tr><th>전화번호</th>
<td><input type="text" name="c_tel"></td>
</tr>
</table>

<button>저장하기</button>
<button type="button" onclick="location=list.l3">취소하기</button>
</form>

</body>
</html>