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

<h3>제품코드 조회결과</h3>
<table border="1">
<colgroup>
	<col width="200px">
	<col width="400px">
</colgroup>
<tr><th colspan="2">제조사 조회 결과</th>
</tr>

<c:if test="${ not empty dto }">
<tr><th>제품코드</th>
	<td>${ dto.code }</td>
</tr>
<tr><th>제조사명</th>
	<td>${ dto.maker }</td>
</tr>
<tr><th>등록일자</th>
	<td>${ dto.reg_date }</td>
</tr>
</c:if>

<c:if test="${ empty dto }">
<tr><th>제품코드</th>
	<td>${ code }</td>
</tr>
<tr><th>제조사명</th>
	<td>등록되지 않은 제품입니다.</td>
</tr>
<tr><th>조회일시</th>
	<td>${ today }</td>
</tr>
</c:if>

</table>
<a href="search.l5">제품코드 조회</a>
<a href="list.l5">제품코드 목록</a>
</body>
</html>