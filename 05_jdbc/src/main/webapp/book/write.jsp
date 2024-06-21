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
  <div>
  
    <form action="${contextPath}/register.do" method="post"> 
      <div><input type="text" name="title" placeholder="제목"></div>
      <div><input type="text" name="author" placeholder="저자"></div>
      <div><input type="text" name="price" placeholder="가격"></div>
      <button type="submit"> 등록하기</button>
    </form>
  </div>
</body>
<script type="text/javascript">
/*
 * 작성해야하는 페이지는 다 form 메소드 post처리
 * input name 값 => 파라미터
 */
 
 const registerForm = document.getElementById('register-form');
 const title = document.getElementById('title');
 const price = document.getElementById('price');
 
 const checkSubmit = ()=>{      
   registerForm.addEventListener('submit', (evt)=>{
     if(title.value === ''){
       alert('제목은 반드시 입력해야 합니다.');
       title.focus();
       evt.preventDefault();
       return;
     }
     const regPrice = /^$|[^0-9]/;
     if(regPrice.test(price.value)){
       alert('가격은 숫자만 입력할 수 있습니다.');
       price.focus();
       evt.preventDefault();
       return;
     }
   })
 }
 
 checkSubmit();
 
</script>
</html>
