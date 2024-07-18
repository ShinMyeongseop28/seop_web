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

<h3>${ dto.subject }</h3>
<table border="1">
<colgroup>
	<col width="100px">
	<col width="400px">
	<col width="100px">
	<col width="400px">
</colgroup>
<tr><th>작성자</th>
	<td colspan="3">${ dto.name }</td>
</tr>
<tr><th>등록일</th>
	<td>${ dto.nalja }</td>
	<th>조회수</th>
	<td>${ dto.check_num }</td>
</tr>
</table>
<p>${ dto.content }</p>
<hr>
<button type="button" onclick="location='modify.bo?id=${ dto.numb }'">수정</button>
<button type="button" onclick= "javascript: if( confirm('정말 [${dto.subject}] 게시판을 삭제하시겠습니까?')) {location='delete.bo?id=${ dto.numb }'}">삭제</button>
</body>
</html>