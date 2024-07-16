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

<h3>제품코드 수정</h3>

<form method="post" action="update.l5">
<input type="hidden" name="code" value="${ dto.code }">
<table border="1">
<colgroup>
	<col width="200px">
	<col width="400px">
</colgroup>
<tr><th>제품코드</th>
	<td>${ dto.code }</td>
</tr>
<tr><th>제조사명</th>
	<td><input type="text" name="maker" value="${ dto.maker }"></td>
</tr>
</table>
<button>저장하기</button>
<button type="button" onclick="location='list.l5' ">취소하기</button>
</form>

</body>
</html>