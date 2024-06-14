package pkg08_databind;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class MyHttpSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
	  HttpSession session = request.getSession();
	  
	  session.setAttribute("a", "Httpsession");
	  
	  // 세션 유지시간
	  // 생략하면 기본 값 30분
	  session.setMaxInactiveInterval(60); // => (60초) , 초 단위임 / -1과 같은 음수 전달 시 무한으로 사용
	  
	  response.sendRedirect("/servlet/dataconfirm");
	  
	  
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
