package pkg06_redirect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Destination1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   request.setCharacterEncoding("UTF-8");
	   String luggage = request.getParameter("luggage");
	   System.out.println("Destination1 :" + luggage);
	    
	   //redirect  ( 요청 파라미터가 전달되지 않는다.  원한다면 아래 주석과 같이 다시 요청해야 한다.)
	   response.sendRedirect("/servlet/destination2"); // ("/servlet/destination2?luggage=" + luggage)
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
