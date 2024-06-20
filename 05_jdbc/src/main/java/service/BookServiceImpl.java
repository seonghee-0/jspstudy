package service;

import common.ActionForward;
import dao.BookDAO;
import dto.BookDTO;
import jakarta.servlet.http.HttpServletRequest;

public class BookServiceImpl implements BookService {

  
  // Field
  private BookDAO bookDAO = BookDAO.getInstance();
  
  @Override
  public ActionForward getBooks(HttpServletRequest request) {
   
    // 데이터베이스에서 가져온 List<BookDTO>을 JSP로 보내기 위해서 request 에 저장한 뒤 forward 한다.
    
    request.setAttribute("books", bookDAO.getBooks()); //request 에 저장 => books 라는 이름으로 bookDAO.getBooks()를 저장한다.
    
    // 삭제 후 목록보기로 갈 때 삭제 결과를 JSP로 보낸내기 위해서 request에 저장한다.
    if(request.getParameter("deleteResult") != null) {// null 값이 아니라면
      request.setAttribute("deleteResult", request.getParameter("deleteResult")); // 0 , 1 이 들어올 수 있음
    }
    
    
    return new ActionForward("/book/list.jsp",false); //false : redirect 가 아니다 
  }

  @Override
  public ActionForward getBookByNo(HttpServletRequest request) {
    
    // 전달된 bookNo 와 일치하는 책 정보를 데이터베이스로부터 가져와서 JSP 로 전달하기 위해 request 에 저장한 뒤 forward 한다.
    int bookNo = Integer.parseInt(request.getParameter("bookNo")); // 파라미터는 항상 문자로 오기때문에 숫자로 파싱해줘야함
    
    request.setAttribute("book", bookDAO.getBookByNo(bookNo));
    return new ActionForward("/book/detail.jsp",false); //false : redirect 가 아니다 
  }
  @Override
  public ActionForward registerBook(HttpServletRequest request) { 
    // 요청 파라미터 (제목, 저자, 가격)
     String title = request.getParameter("title");
     String author = request.getParameter("author");
     int price = Integer.parseInt(request.getParameter("price"));
     
     // 데이터베이스로 전달할 형식인 BookDTO 생성
     BookDTO book = BookDTO.builder()
         .title(title)
         .author(author)
         .price(price)
         .build();
 
    // 데이터베이스 실행
    int result = bookDAO.insertBook(book);    
    
    // 성공하면 : /book/list.jsp 로 가기위한 /list.do
    // 실패하면 : /index.jsp  로 가기위한 /index.do
    String path = request.getContextPath() + (result == 1 ? "/list.do" : "/index.do"); // insert 하고 path 결과가 1이면 /list.do 아니면 /index.do
        
    // 이동방식 : redirect (DML)    
    return new ActionForward(path, true);
  }
  
  @Override
  public ActionForward removeBook(HttpServletRequest request) {
    // 요청 파라미터 (삭제할 책 번호)
    int bookNo = Integer.parseInt(request.getParameter("bookNo"));
    
    // 데이터 베이스에서 삭제
    int result = bookDAO.deleteBook(bookNo);
    
    // 성공과 실패 모두 /book/list.jsp로 이동하기 위한 /list.do
    return new ActionForward(request.getContextPath() + "/list.do?deleteResult=" + result, true);
    
    
  }
}
