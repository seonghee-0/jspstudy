package com.sh.app.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/* DTO : Data Transfer Object */

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BoardDTO {
  private int board_no;
  private String title;
  private String contents;
  private Date create_dt;
  private Date modify_dt;
}
