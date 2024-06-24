package com.sh.app.dao;

import java.util.List;
import java.util.Map;

import com.sh.app.dto.BoardDTO;

public interface BoardDAO {
  List<BoardDTO> getBoardList(Map<String, Object> params); // boardDTO가 여러개 담겨있는 list
  int getBoardCount(); // 파라미터 없는 방식으로 처리함
  BoardDTO getBoardByNo(int board_no);
  int insertBoard(BoardDTO board);
  int updateBoard(BoardDTO board); // 수정할 정보가 담겨있는 DTO
  int deleteBoard(int board_no); // 삭제할땐 모든 정보가 아닌 번호만 필요하기때문에 board_no받아오기
  int deleteBoardList(String board_no_list); // 문자열로 board_no_list를 받아옴
  void close() throws Exception; // close 작업
  
}
