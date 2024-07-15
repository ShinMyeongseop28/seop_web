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

<h3>L3-회원정보</h3>
<table border="1">
<colgroup>
	<col width="200px">
	<col width="300px">
</colgroup>
<tr><th>아이디</th>
	<td>${ dto.p_id }</td>
</tr>
<tr><th>비밀번호</th>
	<td>${ dto.p_pw }</td>
</tr>
<tr><th>이름</th>
	<td>${ dto.c_name }</td>
</tr>
<tr><th>이메일</th>
	<td>${ dto.c_email }</td>
</tr>
<tr><th>전화번호</th>
	<td>${ dto.c_tel }</td>
</tr>
</table>

<a href="modify.l3?id=${ dto.p_id }">수정하기</a>
<a href="delete.l3?id=${ dto.p_id }">삭제하기</a>


</body>
</html>