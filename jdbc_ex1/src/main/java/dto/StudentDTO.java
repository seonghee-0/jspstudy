package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/* DTO : Data Transfer Object */

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDTO {
  private int stu_no;
  private String name;
  private int kor;
  private int eng;
  private int math;
  private int ave;
  private int mark;
}

