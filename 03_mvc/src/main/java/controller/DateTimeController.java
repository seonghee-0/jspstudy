package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DateModel;
import model.TimeModel;


public class DateTimeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  //요청인코딩
	  request.setCharacterEncoding("UTF-8");
		
	  //요청 확인(요청 파라미터 type 확인)
	  String type = request.getParameter("type");
	  String path = null;
	  //요청에 따른 비즈니스 로직처리
	  switch(type) {
	  case "date":
	    DateModel dateModel = new DateModel();
	    path = dateModel.execute(request);//Model 에 요청을(request)을 전달한다.
	    //request 인자 =>  HttpServletRequest request 매개변수
	    break;
	  case "time":
	    TimeModel timeModel = new TimeModel();
	    path = timeModel.command(request);
	    break;
	  }

	  //응답(결과를 보여 줄 JSP(/views/date.jsp)로 이동하기) 
	  // =>request 에 저장된 결과를 전달하기위해서 forward 해야 함.
	  if(path!=null) {
	    request.getRequestDispatcher(path).forward(request, response);
	  }
	  
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
