package pkg03_ajax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Accident extends HttpServlet {
  
  private static final long serialVersionUID = 1L;
       
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
    request.setCharacterEncoding("UTF-8");
    
    String siDo = request.getParameter("siDo");
    String guGun = request.getParameter("guGun");
    
    StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552061/AccidentDeath/getRestTrafficAccidentDeath");
    urlBuilder.append("?serviceKey=").append(URLEncoder.encode("bEQBRPHjt0tZrc7EsL0T8usfsZ1+wT+5jqamBef/ErC/5ZO6N7nYdRmrwR91bh5d3I1AQeY5qdbJOF6Kv0U1CQ==", "UTF-8"));
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
    String line = null;
    while((line = in.readLine()) != null) {
      sb.append(line);
    }
    String responseText = sb.toString();
    
    response.setContentType("application/json; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println(responseText);
    out.close();
    
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

}
