package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


import com.sh.app.dto.StudentDTO;

public class StudentDAOImpl implements StudentDAO {
  
  /* Connection pool 관리를 데이터 소스라는 인터페이스가 함
     (생성자에서 context.xml 의 내용을 읽어서 dataSource 객체를 생성한다) */
  private DataSource dataSource;
  
  /* Singleton Pattern */
  private StudentDAOImpl() {
    try {
      Context ctx = new InitialContext();
      Context env = (Context)ctx.lookup("java:comp/env"); // context 찾는 환경이 Container(tomcat)이다
      dataSource = (DataSource)env.lookup("jdbc/myoracle"); // 이 이름의 리소스를 읽으면 반환되는 타입이 dataSource이다.
    }catch(Exception e) {
      e.printStackTrace();
    }
  }
  private static StudentDAO studentDAO = new StudentDAOImpl(); // static 처리가 되어있지않으면 호출이 안되기때문에 static 처리 해줘야함
  public static StudentDAO getInstance() {
    return studentDAO;
  }

  /* Field */
  private Connection conn;
  private PreparedStatement ps;
  private ResultSet rs;

  @Override
public List<StudentDTO> getStudentList(Map<String, Object> params) {
    
    List<StudentDTO> studentList = new ArrayList<StudentDTO>();
    try {
      
      conn = dataSource.getConnection();
      // DriverManager 와 다르게 dataSource 는 여러개를 가질 수 있다.
      
      
      StringBuilder builder = new StringBuilder();
      builder.append("");
      String sql = builder.toString(); 
      ps = conn.prepareStatement(sql); // 쿼리문 전달
      ps.setInt(1, (int)params.get("begin")); // params 에 숫자 두개가 들어가있는걸 begin 으로 받아옴
      ps.setInt(2, (int)params.get("end")); // params 에 숫자 두개가 들어가있는걸 end 로 받아옴
      // object 값을 int 로 가지고오기 위해 (int)캐스팅
      rs = ps.executeQuery();
      
      
      close();
    }catch(Exception e) {
      e.printStackTrace();
    }
    
    return studentList;
  }

  
  @Override
  public void close() throws Exception {
    if(conn != null) conn.close();
    if(ps != null) ps.close();
    if(rs != null) rs.close();
  }

  

}

