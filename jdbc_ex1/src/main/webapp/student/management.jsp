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
  <h1>학생 관리</h1>
  <div>
    <button type="button" onclick="location.href='${contextPath}/write.do'">신규 학생 등록</button>
  </div>
  <hr/>
  <div>
      <span>평균</span>
      <input type="number" name="ave1" id="ave1" value="">
      <input type="number" name="ave2" id="ave2" value="">
      <button>조회</button> <button>전체조회</button>
    </div>
  <hr/>
  
  <script>
    const display = document.getElementById('display');
    display.value = ${display}; // display option 값을 넘어온 display 값으로 바꿔줌
    display.addEventListener('change', evt=>{
      location.href = '${contextPath}/list.do?page=1&sort=${sort}&display=' + display.value;
    })
  </script>
  <form action="${contextPath}/list.do" method="post"> <!-- action 선택삭제 눌렀을 때 할 일 -->
    <table border="1">
    <caption>전체 학생 0명</caption>
      <thead>
        <tr>
          <th>학번</th>
          <th>성명</th>
          <th>국어</th>
          <th>영어</th>
          <th>수학</th>
          <th>평균</th>
          <th>학점</th>
          <th>버튼</th>
        </tr>
      </thead>
      <tbody>
       <%--  <c:forEach items="${studentList}" var="student">  --%>
          <tr>
             <td colspan="8">등록된 학생이 없습니다.</td>
          </tr>
          <tr>
            <td colspan="5">전체평균</td>
            <td>0.00</td>
            <td colspan="2">-</td>
          </tr>
        <%--</c:forEach>--%>
        <!-- 리스트 items 하나씩 빼는 var -->
      </tbody>
      <tfoot>
        
      </tfoot>
    </table>
  </form>
  <script>
    if('${registerMessage}' !== '')
      alert('${registerMessage}');
    
    if('${removeMessage}' !== '')
      alert('${removeMessage}');
    
    if('${modifyMessage}' !== '')
      alert('${modifyMessage}');
    
  </script>

</body>
</html>