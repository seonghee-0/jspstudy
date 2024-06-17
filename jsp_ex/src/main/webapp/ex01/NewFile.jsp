<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연습문제</title>
<% 
  String contextPath = request.getContextPath(); 
%>
<script src="<%=contextPath%>/assets/lib/jquery-3.7.1.min.js"></script> 
</head>
<style>
label{    display: block;}
form > div + div{padding-top: 20px}
</style>

<body>
<div style="display:inline-block;border:1px solid #888; padding:10px;">
  <form action="" id ="signup_frm">
    <div>
      <label for="id">아이디</label>
      <input type="text" name="id" id="id"><span>@naver.com</span>  
    </div>
    <div>
      <label for="pw">비밀번호</label>
      <input type="text" name="pw" id="pw">
    </div>
    <div>
      <label for="pw">비밀번호 재확인</label>
      <input type="text" name="pw">
    </div>
    <div>
      <label for="name">이름</label>
      <input type="text" name="name">
    </div>
     <div>
      <label for="birth">생년월일</label>
      <input type="text" name="birth" placeholder="년(4자)" maxlength="4">
      <select name="birth">
        <option>1월</option>
        <option>2월</option>
        <option>3월</option>
        <option>4월</option>
        <option>5월</option>
        <option>6월</option>
        <option>7월</option>
        <option>8월</option>
        <option>9월</option>
        <option>10월</option>
        <option>11월</option>
        <option>12월</option>
      </select>
      <input type="text" name="birth" placeholder="일"  maxlength="2">
    </div>
    <div>
      <label for="email">본인 확인 이메일(선택)</label>
      <input type="text" name="birth" placeholder="선택입력" >
     
    </div>
    <div>
      <label for="birth">휴대전화</label>
      <input type="tel" placeholder="전화번호 입력">
      <button type="">인증번호 받기</button><br>
      <input type="text" placeholder="인증번호를 입력하세요">
    </div>
    <div>
      <button id="signupBtn">가입하기</button>
    </div>
  </form>
</div>
<script>
  const id = $('#id');
  const pw = $('#pw');
  const signForm = $('#signup_frm');
  const signBtn = $('#signupBtn');
  /* signForm.addEventListener('submit', function(evt){ */
     signForm.addEventListener('submit', function(evt){
    if( id.value === ''){
      console.log('dd');
      alert('아이디는 필수입니다.');
      id.focus();
      evt.preventDefault();
      return;
    }
   /*  if(pw.value === ''){ 
      alert('비밀번호를 입력하세요');
      pw.focus();
      return;
    } */
  })
  


</script>
</body>
</html>