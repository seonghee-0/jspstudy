package pkg04_file;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1
                , maxFileSize = 1024 * 1024 * 10
                , maxRequestSize = 1024 * 1024 * 100)
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	  // 올린 이미지를 저장할 경로
	  String uploadPath = request.getServletContext().getRealPath("upload_dir"); // 내부경로 찾는 코드 (중요하지않다)- 수업 test 용(spring 에서 제대로 공부할예정)
	  File uploadDir = new File(uploadPath);
	  if(!uploadDir.exists())
	    uploadDir.mkdirs();

	  
	  // 첨부 파일의 정보
	  Part part = request.getPart("profile");
	  
	  
	  // 첨부 파일의 원본 이름
	  String originalFilename = null;
	  if(part.getHeader("Content-Disposition").contains("filename")){
	    originalFilename = part.getSubmittedFileName();
	  }
	  
	  // 첨부 파일이 저장되는 이름(원본이름으로 저장되면 안됨! = 중복 방지)
	  String filesystemName = null;
	  if(originalFilename != null)
	  filesystemName = System.currentTimeMillis() + "_" + originalFilename;
	
	  // 첨부 파일 저장하기
	  if(filesystemName != null) {
	    part.write(uploadPath + "/" +filesystemName); 
	    //write(path) -- 업로드한 파일을 출력 작업해줌
	    //      ㄴ path 에는 (경로 + 파일명)이 들어가야함
	  }
	  
	  //응답
	  response.setContentType("text/html; charset=UTF-8");
	  PrintWriter out = response.getWriter();
	  
	  out.println("<a href=\"/servlet/pkg04_file/NewFile.html\">첨부 화면으로 가기</a>");
	  File[] files = uploadDir.listFiles();
    // listFiles() -- 저장된 모든 파일을 가지고옴
	  for(File file : files) {
	    String filename = file.getName();
	    out.println("<div><a href=\"/servlet/download?filename=" + filename + "\">" + filename + "</a></div>");
	  }
	  out.flush(); // for 문 돌릴 땐 flush 사용 권장
	  out.close(); // out 끝내고 닫기
	  
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
