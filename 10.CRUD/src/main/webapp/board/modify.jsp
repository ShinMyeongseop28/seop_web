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

<form method="post" action="update.bo">
<input type="hidden" name="name" value="${ dto.name }">
<input type="hidden" name="numb" value="${ dto.numb }">
<table border="1">
<colgroup>
	<col width="200px">
	<col width="800px">
</colgroup>
<tr><th>제목</th>
	<td><input type="text" name="subject" value="${ dto.subject }"></td>
</tr>
<tr><th>작성자</th>
	<td>${ dto.name }</td>
</tr>
<tr><th>E-Mail</th>
	<td><input type="text" name="email" value="${ dto.email }"></td>
</tr>
<tr><th>내용</th>
	<td><input type="text" name="content" value="${ dto.content }" style="width:400px; height: 200px"></td>
</tr>
<tr><th>패스워드</th>
	<td><input type="password" name="password" value="${ dto.password }">
	(게시물 수정 및 삭제시 필요!!)</td>
</tr>
</table>
<button>수정하기</button>
<button type="button" onclick="location='info.bo?id=${ dto.numb }'">수정취소</button>
</form>

</body>
</html>