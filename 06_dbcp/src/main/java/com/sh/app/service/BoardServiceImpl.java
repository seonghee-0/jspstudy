package com.sh.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.sh.app.common.ActionForward;
import com.sh.app.dao.BoardDAO;
import com.sh.app.dao.BoardDAOImpl;
import com.sh.app.dto.BoardDTO;
import com.sh.app.utils.PageUtils;

import jakarta.servlet.http.HttpServletRequest;

public class BoardServiceImpl implements BoardService {

  
  //Field
  private BoardDAO boardDAO = BoardDAOImpl.getInstance();
  private PageUtils pageUtils = new PageUtils();
  
  
  @Override
  public ActionForward getBoardList(HttpServletRequest request) {
    //
    int total = boardDAO.getBoardCount();
    
    // pageUtils display
    Optional<String> optDisplay = Optional.ofNullable(request.getParameter("display")); // null 이 가능한 파라미터를 감싸기때문에 ofNullable 사용
    int display = Integer.parseInt(optDisplay.orElse("20")); // 요청 파라미터가 있으면 그 값을 꺼내고 없으면 20을 꺼내라. (string 이기때문에 정수 파싱까지해주기)

    
    // pageUtils display
    Optional<String> optPage = Optional.ofNullable(request.getParameter("page")); // null 이 가능한 파라미터를 감싸기때문에 ofNullable 사용
    int page = Integer.parseInt(optPage.orElse("1")); // page 파라미터가 전달되지않으면 1을 쓴다
    
    
    // PageUtils' begin / end 계산
    pageUtils.setPaging(total, display, page); 
    
    // sort 
    Optional<String> optSort = Optional.ofNullable(request.getParameter("sort")); // null 이 가능한 파라미터를 감싸기때문에 ofNullable 사용
    String sort = optSort.orElse("DESC"); // sort 파라미터가 전달되지않으면 DEXC을 쓴다
    
    
    // 데이터베이스로 보낼 Map<String, Object> params 생성
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("begin", pageUtils.getBegin());
    params.put("end", pageUtils.getEnd());
    params.put("sort", sort);
    
    // 데이터베이스에서 목록 가져오기
    List<BoardDTO> boardList = boardDAO.getBoardList(params);
    
    // /board/list.jsp 로 보낼 데이터 저장하기
    request.setAttribute("total", total);
    request.setAttribute("boardList", boardList);
    
    // SELECT 이후에는 forward 로 이동한다.
    return new ActionForward("/board/list.jsp", false);
    
  }
  
  @Override
  public ActionForward getBoardByNo(HttpServletRequest request) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ActionForward registerBoard(HttpServletRequest request) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ActionForward modifyBoard(HttpServletRequest request) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ActionForward removeBoard(HttpServletRequest request) {
    // TODO Auto-generated method stub
    return null;
  }

}
