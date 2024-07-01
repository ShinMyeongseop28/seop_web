<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>신규사원등록</h2>

<form method="post" action="insert.do">
<table border="1">
<tr><th>성명</th>
	<td><input type="text" name="last_name" placeholder="성">
		<input type="text" name="first_name" placeholder="명"> 
	</td> 
</tr>
<tr><th>이메일</th>
	<td><input type="text" name="email"></td> 
</tr>
<tr><th>입사일자</th>
	<td><input type="date" name="hire_date"></td> 
</tr>
<tr><th>업무</th>
	<td><input type="text" name="job_id"></td> 
</tr>
</table>

<button>저장하기</button>
<button type="button" onclick="location='select.do'">취소하기</button>
</form>
</body>
</html>