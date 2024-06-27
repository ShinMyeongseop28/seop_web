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
<div><a href="../">홈으로</a></div>
<hr>
<h2>조건문: choose</h2>
<c:set var="score" value="78" />
<c:choose>
	<c:when test="${ score-90 >= 0 }"><c:set var="grade" value="A" /></c:when>
	<c:when test="${ score-80 >= 0 }"><c:set var="grade" value="B" /></c:when>
	<c:when test="${ score-70 >= 0 }"><c:set var="grade" value="C" /></c:when>
	<c:when test="${ score-60 >= 0 }"><c:set var="grade" value="D" /></c:when>
	<c:otherwise><c:set var="grade" value="F" /></c:otherwise>
</c:choose>
<div>성적: ${score } ${grade }학점</div>

<h2>조건문: if</h2>
<c:set var="no1" value="10" />
<c:set var="no2" value="20" />
<div>${ no1 } 과 ${ no2 } 중 더 큰 수 :
	<c:if test="${ no1 - no2 gt 0 }">${no1}</c:if>
	<c:if test="${ no1 - no2 lt 0 }">${no2}</c:if>
</div>

<h2>변수선언</h2>
<c:set var="name" value="홍길동" />
<div>이름: ${name}</div>

<c:remove var="name"/>
<div>이름: ${name}</div>

</body>
</html>