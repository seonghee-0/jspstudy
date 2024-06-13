package pkg03_ajax;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;


public class Accident extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	request.setCharacterEncoding("UTF-8");
	
  String siDo = request.getParameter("siDo");
  String guGun = request.getParameter("guGun");
	
	StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552061/AccidentDeath/getRestTrafficAccidentDeath");
	urlBuilder.append("?serviceKey=").append("v%2FeJIea5ZORxgTJ8GmtuGGQnexOMWNy4GMIzYz13fDbTOJvf39wI%2FyQAtnzFvfxkUyL%2BZBCox%2FAlTkEVFmBIhQ%3D%3D");
	 urlBuilder.append("&siDo=").append(siDo);
   urlBuilder.append("&guGun=").append(guGun);
   urlBuilder.append("&searchYear=").append("2022");
   urlBuilder.append("&numOfRows=").append("15");
   urlBuilder.append("&pageNo=").append("1");
   urlBuilder.append("&type=").append("json");
	
   URL url = URI.create(urlBuilder.toString()).toURL();
   HttpURLConnection con = (HttpURLConnection) url.openConnection();
   BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
   StringBuilder sb = new StringBuilder();
   
  // 응답 결과
  
   String line = null;
   while((line = in.readLine()) != null) {
     sb.append(line);
   }
   String responseText = sb.toString();
   
   response.setContentType("application/json; charset=UTF-8");
   PrintWriter out = response.getWriter();
   out.println(responseText);
    out.close(); //스트림 닫기 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
