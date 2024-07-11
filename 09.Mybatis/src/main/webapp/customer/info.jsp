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
<h3>고객정보</h3>

<table border="1">
<colgroup>
	<col width="200px">
	<col width="300px">
</colgroup>
<tr><th>고객명</th>
	<td>${ dto.name }</td>
</tr>
<tr><th>성별</th>
	<td>${ dto.gender }</td>
</tr>
<tr><th>이메일</th>
	<td>${ dto.email }</td>
</tr>
<tr><th>전화번호</th>
	<td>${ dto.phone }</td>
</tr>
</table>

<a href="modify.cu?id=${ dto.id }">수정하기</a>
<a href="">삭제하기</a>
</body>
</html>