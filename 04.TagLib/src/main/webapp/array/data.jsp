<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>배열출력</h2>
<%
ArrayList<String> list = new ArrayList<String>();
list.add("자바");
list.add("View");
list.add("Oracle");
session.setAttribute("subjects", list);

HashMap<String, String> map = new HashMap<String, String>();
map.put("홍길동", "062-974-5632");
map.put("심청", "02-176-1587");
map.put("박문수", "010-1657-5357");
session.setAttribute("phones", map);
%>
<div>${ subjects[0]}</div>
<div>${ subjects[1]}</div>
<div>${ subjects[2]}</div>
<div>${ subjects[3]}</div>

</body>
</html>