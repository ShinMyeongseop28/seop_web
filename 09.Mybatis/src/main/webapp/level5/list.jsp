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

<h3>제품코드 목록</h3>

<a href="register.l5">등록하기</a>
<table border="1">
<colgroup>
	<col width="200px">
	<col width="300px">
	<col width="100px">
	<col width="100px">
</colgroup>
<tr><th>제품코드</th><th>제조사명</th><th></th><th></th></tr>
<c:if test="${ empty list }">
<tr><td colspan="4">제품코드 정보가 없습니다</td></tr>
</c:if>

<c:forEach items="${ list }" var="dto">
<tr><td>${ dto.code }</td><td>${ dto.maker }</td>
	<td><a href="modify.l5?code=${ dto.code }">수정하기</a></td>
	<td><a href="javascript: if( confirm('정말 제품 [${ dto.code }] 삭제?') ) { location='delete.l5?code=${ dto.code }' }" >삭제하기</a></td>
</tr>
</c:forEach>
</table>

</body>
</html>