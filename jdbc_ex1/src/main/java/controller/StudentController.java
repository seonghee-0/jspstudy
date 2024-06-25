package controller;

import java.io.IOException;

import common.ActionForward;
import service.StudentService;
import service.StudentServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;





public class StudentController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
    request.setCharacterEncoding("UTF-8");
    
    String requestURI = request.getRequestURI();    /* http://localhost:9090/mvc/list.do */
    String contextPath = request.getContextPath();  /*                      /mvc         */
    int beginIndex = requestURI.indexOf(contextPath) + contextPath.length() + 1;
    String urlMapping = requestURI.substring(beginIndex);   /* list.do */
  
    StudentService studentService = new StudentServiceImpl();
    
    ActionForward actionForward = null;
    
    switch(urlMapping) {
    // db 갔다 올 필요가 없는 단순이동(서비스가 필요하지 않다!) 처리 : actionForward 만 필요
    case "write.do":
      actionForward = new ActionForward("/student/write.jsp", false);
      break;
    case "index.do":
      actionForward = new ActionForward("/index.jsp", false);
      break;
    
    case "management.do": 
      actionForward = new
     ActionForward("/student/management.jsp", false); break;
     
    
    // 비즈니스 로직 처리 (서비스가 필요하다!)
//   case "management.do": 
//     actionForward = studentService.getStudentList(request);
//     break;

	 
    }
    
    if(actionForward != null) {
      if(actionForward.isRedirect()) {
        response.sendRedirect(actionForward.getPath());
      } else {
        request.getRequestDispatcher(actionForward.getPath()).forward(request, response);
      }
    }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
