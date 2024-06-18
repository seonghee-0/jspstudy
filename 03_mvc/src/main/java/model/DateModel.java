package model;

import java.time.LocalDate;
import jakarta.servlet.http.HttpServletRequest;

public class DateModel {

  // 현재날짜를 구한 뒤 요청에 저장하고 응답할 JSP 경로를 반환하는 메소드
  
  public String execute(HttpServletRequest request) { //Controller 부터 요청(request)을 받는다
    request.setAttribute("today", LocalDate.now()); // today 라는 이름으로 request 에 저장
    return "/views/date.jsp"; // 메소드를 호출 한 곳으로 돌아감 
    
  
  }
  
}
