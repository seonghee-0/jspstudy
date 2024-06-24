package com.sh.app.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter

public class PageUtils {
  private int total;     // 전체개수 ( 데이터 베이스에서 구하는 정보)
  private int display;   // 한 페이지에 표시할 개수 ( 요청파라미터 , 디폴트 : 20개 - 파라미터 전달 안할 때 | 사용자측에서 변경할 수 있는 정보이기때문에 요청 parameter 로 처리 가능)
  private int page;      // 페이지 번호 ( 요청파라미터 , 디폴트 1 - 파라미터 전달 안할 때) | 어느 페이지를 누를지 파라미터 받아옴) 
  private int begin;     // 각 페이지에 표시할 시작 번호 (계산, setPaging() 메소드)
  private int end;       // 각 페이지에 표시할 종료 번호 (계산, setPaging() 메소드)
  
  private int totalPage;          // 전체 페이지의 개수 (계산, setPaging() 메소드)
  private int pagePerBlock = 10;  // 한 블록에 표시할 페이지의 개수 (결정한다.)
  private int beginPage;          // 한 블록에 표시할 시작 페이지 (계산, setPaging() 메소드)
  private int endPage;            // 한 블록에 표시할 종료 페이지 (계산, setPaging() 메소드)
  
  public void setPaging(int total, int display, int page) { // 필요한 세가지 정보
   // 전달받은 3가지 정보는 setter 작업
    this.total = total;
    this.display = display;
    this.page = page;
     
    begin = (page - 1) * display + 1; // 1페이지는 1번부터 보여줌 , 2페이지는 21번부터 보여줌
    end   = begin + display - 1;
   
    totalPage = (int)Math.ceil((double)total / display); // total 을 소수점으로 바꿔주기 (하나만 바꿔줘도 전체 소수점계산을함)
    beginPage = ((page - 1) / pagePerBlock) * pagePerBlock + 1;
    endPage = Math.min(beginPage + pagePerBlock - 1, totalPage);
  }
  
  public String getPaging( String requestURI , String sort, int display ) {
    
    StringBuilder builder = new StringBuilder();
     
    // <div>
    builder.append("<div class=\"paging\">");  
    
    // < (이전 block)
    if(beginPage == 1) 
      builder.append("<button type=\"button\" style=\"color:silver;\">&lt;</button>");
    else 
      builder.append("<button type=\"button\" onclick=\"location.href='"+ requestURI +"?page="+(beginPage-1)+"&sort="+sort+"&display="+display+"'\">&lt;</button>"); // on... => event 속성( 내부는 자바스크립트)

    // 1 2 3 4 5 6 7 8 9 10
    for(int p  = beginPage; p <= endPage; p++ ) {
      if(p==page) {
        builder.append("<button type=\"button\" style=\"color:limegreen;\" onclick=\"location.href='"+ requestURI +"?page="+(p)+"&sort="+sort+"&display="+display+"'\">"+p+"</button>"); 
      }else {
        builder.append("<button type=\"button\" onclick=\"location.href='"+ requestURI +"?page="+(p)+"&sort="+sort+"&display="+display+"'\">"+p+"</button>");
      }
    }
    
    // > (다음 block)
    if(endPage == totalPage) {
      builder.append("<button type=\"button\" style=\"color: silver;\">&gt;</button>");
    } else {
      builder.append("<button type=\"button\" onclick=\"location.href='"+requestURI+"?page="+(endPage+1)+"&sort="+sort+"&display="+display+"'\">&gt;</button>");
    }
    
    // </div>
    builder.append("</div>");
    
    return builder.toString();
  }
  
  
  

}
