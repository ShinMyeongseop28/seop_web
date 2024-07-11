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

<jsp:include page="/include/header.jsp"></jsp:include>

<h3>고객목록</h3>
<table border="1">
<colgroup>
	<col width="200px">
	<col width="300px">
</colgroup>
<tr><th>고객명</th>
 	<th>이메일</th>
</tr>

<c:forEach items="${ list }" var="dto">
<tr><td><a href="info.cu?id=${ dto.id }"> ${ dto.name }</a></td>
 	<td>${ dto.email }</td>
</tr>
</c:forEach>
</table>

</body>
</html>