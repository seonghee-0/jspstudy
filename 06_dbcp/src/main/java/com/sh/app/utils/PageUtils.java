package com.sh.app.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter

public class PageUtils {
  private int total;  // 전체개수 ( 데이터 베이스에서 구하는 정보)
  private int display;// 한 페이지에 표시할 개수 ( 요청파라미터 , 디폴트 : 20개 - 파라미터 전달 안할 때 | 사용자측에서 변경할 수 있는 정보이기때문에 요청 parameter 로 처리 가능)
  private int page;   // 페이지 번호 ( 요청파라미터 , 디폴트 1 - 파라미터 전달 안할 때) | 어느 페이지를 누를지 파라미터 받아옴) 
  private int begin;  // 각 페이지에 표시할 시작 번호 (계산, setPaging() 메소드)
  private int end;    // 각 페이지에 표시할 종료 번호 (계산, setPaging() 메소드)

  
  public void setPaging(int total, int display, int page) { // 필요한 세가지 정보
   // 전달받은 3가지 정보는 setter 작업
    this.total = total;
    this.display = display;
    this.page = page;
     
    begin = (page - 1) * display + 1; // 1페이지는 1번부터 보여줌 , 2페이지는 21번부터 보여줌
    end   = begin + display - 1;
    
  }

}
