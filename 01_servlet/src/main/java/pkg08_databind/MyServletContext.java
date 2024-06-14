package pkg08_databind;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class MyServletContext extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
	  // (구하기)
	  ServletContext application = request.getServletContext();
	  
	  // (저장)
	  application.setAttribute("a", "ServletContext"); // ("저장할 이름","저장할 값")
	  
	  // 리다이렉트 (이동)
	  response.sendRedirect("/servlet/dataconfirm");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
