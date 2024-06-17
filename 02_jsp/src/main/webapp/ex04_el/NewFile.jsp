<%@page import="java.util.Map"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.BookVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
h1{font-size:16px;}
</style>
</head>
<body>

<%--
  EL
  1. Expression Language(표현 언어)
  2. JSP 스크립트 요소 중에서 표현식(<%=값%>) 을 대체할 수 있다.
  3. Data Bind 영역에 저장된 값만 EL로 나타낼 수 있다.
    1) pageContext  : NewFile_jsp (this) => 현재 페이지에서만 접근이 가능  
        ㄴ 호출방법 : ${값} 또는 ${pageScope.값}           
    2) request      : HttpServletRequest => 요청 후 응답 전까지만 접근 가능
        ㄴ 호출방법 : ${값} 또는 ${requestScope.값}           
    3) session      : HttpSession        => 브라우저 닫기 전까지만 접근 가능
        ㄴ 호출방법 : ${값} 또는 ${sessionScope.값}  
    4) application  : ServletContext     => 애플리케이션(서비스) 종료 전까지만 접근 가능
        ㄴ 호출방법 : ${값} 또는 ${applicationScope.값}  
--%>

<%
  pageContext.setAttribute("a",1); // a라는 이름으로 값을 1 저장
  request.setAttribute("b",2);     // b라는 이름으로 값을 2 저장
  session.setAttribute("c",3);     // c라는 이름으로 값을 3 저장
  application.setAttribute("d",4); // d라는 이름으로 값을 4 저장
%>

<h1>pageContext'a : ${a}</h1>
<h1>request'b : ${b}</h1>
<h1>session'c : ${c}</h1>
<h1>application'd : ${d}</h1>

<%
  pageContext.setAttribute("x",1);
  request.setAttribute("x",2);
  session.setAttribute("x",3);
  application.setAttribute("x",4);
%>

<h1>high priority : shortest life cycle : pageContext : ${x}</h1> 
<!-- 같은이름(x)이 있으면 life cycle 이 가장 작은 값이나옴 --> 
<h1>pageContext'x : ${pageScope.x}</h1>
<h1>request'x : ${requestScope.x}</h1>
<h1>session'x : ${sessionScope.x}</h1>
<h1>application'x : ${applicationScope.x}</h1>
   
   
   
<%
BookVO book =  new BookVO();
book.setTitle("홍길동전");
book.setAuthor("허균");
book.setPrice(10000);
pageContext.setAttribute("book",book);
%>  
<h1>${book.getTitle()}</h1>
<h1>${book.getAuthor()}</h1>
<h1>${book.price}</h1>


<%
/*   BookVO[] books = new BookVO[]{
      new BookVO("책1", "저자1",1),
      new BookVO("책2", "저자2",2)
  }; */
  List<BookVO> books = Arrays.asList(
      new BookVO("책1", "저자1",1),
      new BookVO("책2", "저자2",2)
  );
  
 pageContext.setAttribute("books",books);

%>
<h1>${books.get(0).title}</h1> <!-- 자바코드에서 list 불러오는 방식 -->
<h1>${books[0].author}</h1>
<h1>${books[0].price}</h1>
<h1>${books[1].title}</h1>
<h1>${books[1].author}</h1>
<h1>${books[1].price}</h1>

<%
 //Immutable 한 map(저장된 Entry 가 바뀔 수 없다.)

  Map<String, Object> map = Map.of("title", "책", "author", "저자", "price", 1); //<키, 값(모든지 저장할수있게 Object)>
  Map<String, Object> bookss = Map.of("title", "어린왕자", "price", 10000); 
  bookss.put("title", "제목");
  pageContext.setAttribute("map", map);
  
%>
<h1>${map.title}</h1>
<h1>${map.get("title")}</h1> <!-- 자바코드에서 map 불러오는방식 -->
<h1>${map.author}</h1>
<h1>${map.price}</h1>





   
</body>
</html>