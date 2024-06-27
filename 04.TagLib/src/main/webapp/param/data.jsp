<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div><a href="../">홈으로</a></div>
<hr>
<h2>파라미터 출력</h2>
<div>이름: <%=request.getParameter("name") %></div>
<div>아이디: ${ param.id }</div>
<div>비번: ${ param.pw }</div>
<div>전화번호: ${ param.phone }</div>
<div>성별: ${ param.gender }</div>
<div>취미: ${ paramValues.hobby[0] }
${ paramValues.hobby[1] }
${ paramValues.hobby[2] }
</div>

</body>
</html>