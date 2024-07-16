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

<h3>제조사명 조회</h3>

<form method="post" action="search.l5">
<table border="1">
<colgroup>
	<col width="200px">
	<col width="400px">
</colgroup>

<tr><th colspan="2">제품코드(4) 입력</th></tr>
<tr><th>제품코드</th>
	<td><input type="text" name="code"></td>
</tr>
<tr><th colspan="2"><button>확인</button></th>
</tr>
</table>
</form>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script>
<c:if test="${ ! empty param.code }">
	$("[name=code]").val( "${param.code}")
	$("form").submit()
	// $("button").trigger("click")
</c:if>
</script>

</body>
</html>