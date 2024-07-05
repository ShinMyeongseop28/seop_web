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
<h2>제품코드 조회 결과</h2>
<table border="1">
<colgroup>
<col width="200px">
<col width="400px">
</colgroup>
<tr><th colspan="2">제조사 조회 결과</th>
</tr>
<c:if test="${empty dto}">
<tr><td colspan="2">해당 제품은 등록되지 않은 제품입니다</td></tr>
</c:if>

<c:if test="${! empty dto}">
<tr><th>제품코드</th>
	<td>${ empty dto ? param.code : dto.code }</td>
</tr>
<tr><th>제조사명</th>
	<td>${ empty dto ? "등록되지 않은 제품입니다" : dto.maker }</td>
</tr>
<tr><th>등록일시</th>
	<td>${ dto.reg_date }</td>
</tr>
</c:if>
</table>
<a href="search.l5">제조사 조회</a>
<a href="register.l5">제조사 등록</a>
<a href="modify.l5?code=${dto.code}">제조사 수정</a>
</body>
</html>