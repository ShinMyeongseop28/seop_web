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

<h3>게시판 조회</h3>
<table border="1">
<colgroup>
	<col width="100px">
	<col width="500px">
	<col width="100px">
	<col width="200px">
	<col width="100px">
</colgroup>
<tr><th>번호</th><th>제목</th><th>작성자</th><th>작성일</th><th>조회수</th>
</tr>
</table>
</body>
</html>