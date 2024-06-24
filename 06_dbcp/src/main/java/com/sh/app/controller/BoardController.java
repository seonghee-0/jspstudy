package com.sh.app.controller;

import java.io.IOException;

import com.sh.app.common.ActionForward;
import com.sh.app.service.BoardService;
import com.sh.app.service.BoardServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;




public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 request.setCharacterEncoding("UTF-8");
    
    String requestURI = request.getRequestURI();    /* http://localhost:9090/mvc/list.do */
    String contextPath = request.getContextPath();  /*                      /mvc         */
    int beginIndex = requestURI.indexOf(contextPath) + contextPath.length() + 1;
    String urlMapping = requestURI.substring(beginIndex);   /* list.do */
  
    BoardService boardService = new BoardServiceImpl();
    
    ActionForward actionForward = null;
    
    switch(urlMapping) {
    // db 갔다 올 필요가 없는 단순이동(서비스가 필요하지 않다!) 처리 : actionForward 만 필요
    case "write.do":
      actionForward = new ActionForward("/board/write.jsp", false);
      break;
    
    
    // 비즈니스 로직 처리 (서비스가 필요하다!)
    case "list.do":
      actionForward = boardService.getBoardList(request);
      break;
    case "register.do":
      actionForward = boardService.registerBoard(request);
      break;
    case "removeBoardList.do":
      actionForward = boardService.removeBoardList(request);
      break;
    case "detail.do":
      actionForward = boardService.getBoardByNo(request);
      break;
    case "modify.do":
      actionForward = boardService.modifyBoard(request);
      break;
    case "removeBoard.do":
      actionForward = boardService.removeBoard(request);
      break;
    }
    
    if(actionForward != null) {
      if(actionForward.isRedirect()) {
        response.sendRedirect(actionForward.getPath());
      } else {
        request.getRequestDispatcher(actionForward.getPath()).forward(request, response);
      }
    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
