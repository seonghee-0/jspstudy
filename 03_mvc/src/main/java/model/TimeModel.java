package model;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import jakarta.servlet.http.HttpServletRequest;

public class TimeModel {
  // 현재시간을 구한 뒤 요청에 저장하고 응답할 JSP 경로를 반환하는 메소드
  public String command(HttpServletRequest request) { //Controller 부터 요청(request)을 받는다
    
    LocalTime now = LocalTime.now(); 
    String timenow = DateTimeFormatter.ofPattern(" a hh시mm분ss초").format(now); 
    
    request.setAttribute("now", timenow); // now 라는 이름으로 request 에 저장
    return "/views/time.jsp"; // 메소드를 호출 한 곳으로 돌아감 
 
  }
}
