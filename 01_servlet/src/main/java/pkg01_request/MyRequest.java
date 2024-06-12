package pkg01_request;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class MyRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
	  // 1. 요청 정보 인코딩(UTF-8)
	  request.setCharacterEncoding("UTF-8");
	  
	  // 2. 요청 파라미터
	  //   1) 모든 요청 파라미터는 String 타입이다.
	  //   2) 파라미터가 없으면 null 값이 변환된다.
	  //     (1) if 문으로 null 처리를 할 수 있다. 
	  //     (2) Optional 클래스로 null 처리를 할 수 있다 (최신!)
	  
	  /* if 문으로 null 처리 */
	  /*
	  String strAge = request.getParameter("age");
	  int age = 0; // 디폴트 값 (파라미터 age 가 전달되지 않았을 때 사용할 값임)
	  if(strAge != null) // strAge 값이 null 이 아니라면
	    age = Integer.parseInt(strAge);
	  */
	  
	  /* Optional<T> 클래스로 null 처리 */
	  Optional<String> opt = Optional.ofNullable(request.getParameter("age"));
	  int age = Integer.parseInt(opt.orElse("0")); // 안들어있으면 0을 쓰겠다.
	  //파라미터가 있으면 있는걸 꺼냄, 안들어있거나 null 이면 other 값 꺼내줌
	  
	  String name = request.getParameter("name");
	  
		response.getWriter().append("Served at: ").append("age :" + age +", name:" + name);
		//request.getContextPath()
		System.out.println("age :" + age +", name:" + name);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  //요청 정보 인코딩(UTF-8)
	  request.setCharacterEncoding("UTF-8");
	  
	  // 요청 파라미터
	  String id = request.getParameter("id");
	  String pw = request.getParameter("pw");
	  String intro = request.getParameter("intro");
	  System.out.println(id +"/"+ pw +"/"+ intro);
	  
	  String gender = request.getParameter("gender");
	  System.out.println(gender);
	  
	  String yellow = request.getParameter("yellow");
	  String green = request.getParameter("green");
	  String blue = request.getParameter("blue");
	  System.out.println(yellow +"/"+ green +"/"+ blue);
	  
	  String[] hobbies = request.getParameterValues("hobbies"); 
	  Arrays.stream(hobbies).forEach(hobby ->{ // stream 공부하려면 람다식 먼저 공부 후 하기
	    System.out.println(hobby);
	  });
	  
	  String region = request.getParameter("region");
	  String host = request.getParameter("host");
	  System.out.println(region +"/"+ host);
	  
	  String charencoding = request.getParameter("charencoding");
	  String author = request.getParameter("author");
	  System.out.println(charencoding +"/"+ author);
	  
	}

}
