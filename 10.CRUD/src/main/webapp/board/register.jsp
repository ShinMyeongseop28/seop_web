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

<form method="post" action="insert.bo">
<%-- <input type="hidden" name="numb" value="${ dto.numb }"> --%>
<table border="1">
<colgroup>
	<col width="200px">
	<col width="800px">
</colgroup>
<tr><th>제목</th>
	<td><input type="text" name="subject"></td>
</tr>
<tr><th>작성자</th>
	<td><input type="text" name="name"></td>
</tr>
<tr><th>E-Mail</th>
	<td><input type="text" name="email"></td>
</tr>
<tr><th>작성일자</th>
	<td><input type="date" name="nalja"></td>
</tr>
<tr><th>내용</th>
	<td><input type="text" name="content" style="width:400px; height: 200px"></td>
</tr>
<tr><th>패스워드</th>
	<td><input type="password" name="password">
	(게시물 수정 및 삭제시 필요!!)</td>
</tr>
</table>
<button>등록하기</button>
<button>다시입력</button>
<button type="button" onclick="location='list.bo'">작성취소</button>
</form>

</body>
</html>