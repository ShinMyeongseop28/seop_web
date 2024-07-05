<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>제조사 수정</h3>
<form method="post" action="update.l5">
<table border="1">
<colgroup>
	<col width="200px">
	<col width="400px">
</colgroup>
<tr><th>제품코드</th>
	<td><input type="text" value="${ dto.code }" name="code" readonly="readonly"></td>
</tr>
<tr><th>제조사명</th>
	<td><input type="text" value="${ dto.maker }" name="maker"></td>
</tr>
<tr><th>등록일시</th>
	<td><input type="text" value="${ dto.reg_date }" name="reg_date" readonly="readonly"></td>
</tr>
</table>
<button>저장하기</button>
<button type="button" onclick="location='reference.l5?id=${dto.code}'">취소하기</button>
</form>
</body>
</html>