<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
  request.setCharacterEncoding("UTF-8");
  String mobile = request.getParameter("mobile");
  String email  = request.getParameter("email");
  String ip     = request.getRemoteAddr();
  request.getRequestDispatcher("/ex02_builtin_object/confirm.jsp").forward(request,response);
  
%>

</body>
</html>