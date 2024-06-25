<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var ="contextPath" value="<%=request.getContextPath()%>"/>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width='device-width', initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
  <!-- 작성은 post -->
  <%-- <form action="${contextPath}/register.do" method="post"> --%>
  <form> 
    <div>
      <label for="name">이름</label>
      <input type="text" name="name" id="name">
    </div>
    <div>
      <label for="kor">국어</label>
      <input type="number" name="kor" id="kor">
    </div>
    <div>
      <label for="eng">영어</label>
      <input type="number" name="eng" id="eng">
    </div>
    <div>
      <label for="math">수학</label>
      <input type="number" name="math" id="math">
    </div>
    <hr/>
    <div>
      <button type="submit">작성완료</button>
      <button type="reset">다시작성</button>
      <button type="button" onclick="location.href='${contextPath}/management.do'">목록</button>
    </div>
  </form>
</body>
</html>