<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8R">
<title>Insert title here</title>
</head>
<body>
<%
  // 여기는 Java 구역
  LocalDateTime now = LocalDateTime.now();
  String strNow = DateTimeFormatter.ofPattern("yyyy-MM-dd a hh:mm:ss.SSS").format(now);
%>
<%--
  JSP 스크립트 요소-3: 표현식
  1. Java 변수 값을 나타낼 때 사용한다.
  2. 형식
    <%=값%>  
--%>
<h1><%=strNow%></h1>
<%--
  Java 와 JavaScript
  1. Java 변수를 JavaScript에서 사용할 수 있다.
     ㄴ반대는 안된다!!
--%>
<!-- 1~10 화면에 출력하기 -->
<% for(int i=1; i<=10; i++){ %>
  <div><%=i%></div>
  <% } %>
<script>
 alert('<%=strNow%>')
</script>
 
</body>
</html>