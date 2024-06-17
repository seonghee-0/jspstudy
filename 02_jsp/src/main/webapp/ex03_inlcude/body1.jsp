<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%--
  <jsp:include> => JSP 액션 태그
   =>동적(내용이 변하는)페이지를 포함할 때 사용한다.
     (포함하는 체이지에 인자값을 전달할 수 있다)
--%>
<jsp:include page="header.jsp">
  <jsp:param value="정치" name="title"/>
</jsp:include>

    <h1>body1</h1>  

<%--
  include 지시어(directive)
   =>정적(내용이 변하지 않는)페이지를 포함할 때 사용한다.

--%>


<%@ include file="footer.jsp"%>