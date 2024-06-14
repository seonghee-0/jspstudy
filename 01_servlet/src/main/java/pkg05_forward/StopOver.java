package pkg05_forward;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StopOver extends HttpServlet {
  
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String luggage = request.getParameter("luggage");
		System.out.println("StopOver: " + luggage);
		
		// forward ( 전달 : 요청 파라미터가 자동으로 전달된다. 응답)
		request.getRequestDispatcher("/destination").forward(request, response);
		                              // ㄴ 전달지 
	
		    
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
