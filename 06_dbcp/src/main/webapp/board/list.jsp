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

  <div>총 ${total}개</div>
  <div>
    <a href="${contextPath}/list.do?page=1&sort=DESC">내림차순</a>
    <span>|</span>
    <a href="${contextPath}/list.do?page=1&sort=ASC">오름차순</a>
  </div>
  <table border="1">
    <thead>
      <tr>
        <th></th>
        <th>게시글 번호</th>
        <th>제목</th>
        <th>작성일자</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${boardList}" var="board"> 
          <tr>
            <td><input type="checkbox" class="each-chk"></td>
            <td>${board.board_no}</td>
            <td>${board.title}</td>
            <td>${board.create_dt}</td>
          </tr>
      </c:forEach>
      <!-- 리스트 items 하나씩 빼는 var -->
    </tbody>
    <tfoot>
      <tr>
        <td colspan="4"> -</td>
      </tr>
    </tfoot>
  </table>
  

</body>
</html>