package test;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.BookDAO;
import dto.BookDTO;

public class BookDAOTest {

  BookDAO bookDAO = BookDAO.getInstance();

  @Test
  public void 책넣기테스트() {
      
    BookDTO book = BookDTO.builder()
        .title("제목1")
        .author("저자1")
        .price(10)
        .build();
     
    // bookDAO.insertBook(book) 결과가 1이면 테스트를 성공한다.
    assertEquals(1, bookDAO.insertBook(book));
    
  }

  @Test
  public void 책수정테스트() {
    
    BookDTO book = BookDTO.builder()
        .book_no(1)
        .title("어린왕자")
        .author("생텍쥐베리")
        .price(135)
        .build();
    
    assertEquals(1, bookDAO.updateBook(book));
    
  }
  
  @Test
  public void 책삭제테스트() {
    int book_no = 6;
    assertEquals(1, bookDAO.deleteBook(book_no));
  }
  
  @Test
  public void 모든책조회테스트() {
    bookDAO.getBooks();
    assertEquals(5,bookDAO.getBooks().size()); // 목록에있는 책의 개수가 5개 이길 기대한다.
  }
  
  @Test
  public void 특정책조회테스트() {
    int book_no = 3; //3번 책 조회
    
    //결과가 NotNull이면 테스트를 성공한다.
    assertNotNull(bookDAO.getBookByNo(book_no)); 
  }
}