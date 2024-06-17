package vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 값(value)을 저장하는 object = vo

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookVO {
  private String title;
  private String author;
  private int price;

}


