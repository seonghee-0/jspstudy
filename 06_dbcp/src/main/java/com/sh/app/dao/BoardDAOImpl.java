package com.sh.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sh.app.dto.BoardDTO;

public class BoardDAOImpl implements BoardDAO {
  
  /* Connection pool 관리를 데이터 소스라는 인터페이스가 함
     (생성자에서 context.xml 의 내용을 읽어서 dataSource 객체를 생성한다) */
  private DataSource dataSource;
  
  /* Singleton Pattern */
  private BoardDAOImpl() {
    try {
      Context ctx = new InitialContext();
      Context env = (Context)ctx.lookup("java:comp/env"); // context 찾는 환경이 Container(tomcat)이다
      dataSource = (DataSource)env.lookup("jdbc/myoracle"); // 이 이름의 리소스를 읽으면 반환되는 타입이 dataSource이다.
    }catch(Exception e) {
      e.printStackTrace();
    }
  }
  private static BoardDAO boardDAO = new BoardDAOImpl(); // static 처리가 되어있지않으면 호출이 안되기때문에 static 처리 해줘야함
  public static BoardDAO getInstance() {
    return boardDAO;
  }

  /* Field */
  private Connection conn;
  private PreparedStatement ps;
  private ResultSet rs;

  @Override
public List<BoardDTO> getBoardList(Map<String, Object> params) {
    
    List<BoardDTO> boardList = new ArrayList<BoardDTO>();
    try {
      
      conn = dataSource.getConnection();
      // DriverManager 와 다르게 dataSource 는 여러개를 가질 수 있다.
      
      
      StringBuilder builder = new StringBuilder();
      builder.append("SELECT board_no, title, contents, create_dt, modify_dt");
      builder.append("  FROM(SELECT ROW_NUMBER() OVER(ORDER BY board_no " + params.get("sort") + ") AS rnum, board_no, title, contents, create_dt, modify_dt");
      builder.append("    FROM board_t)");
      builder.append("  WHERE rnum BETWEEN ? AND ?");
      String sql = builder.toString(); 
      ps = conn.prepareStatement(sql); // 쿼리문 전달
      ps.setInt(1, (int)params.get("begin")); // params 에 숫자 두개가 들어가있는걸 begin 으로 받아옴
      ps.setInt(2, (int)params.get("end")); // params 에 숫자 두개가 들어가있는걸 end 로 받아옴
      // object 값을 int 로 가지고오기 위해 (int)캐스팅
      rs = ps.executeQuery();
      
      while(rs.next()) {
        BoardDTO board = BoardDTO.builder()
            .board_no(rs.getInt(1))
            .title(rs.getString(2))
            .contents(rs.getString(3))
            .create_dt(rs.getDate(4))
            .modify_dt(rs.getDate(5))
            .build();
        boardList.add(board); // 5개의 값을 꺼내와서 boardList 에 모아주기
       }
      close();
    }catch(Exception e) {
      e.printStackTrace();
    }
    
    return boardList;
  }

  @Override
  public int getBoardCount() { 
    int count = 0;
    try {
      conn = dataSource.getConnection();
      String sql="SELECT COUNT(*) FROM board_t";
      ps = conn.prepareStatement(sql);
      rs = ps.executeQuery();
      // connection 의 실행 결과는 rs 가 받는다
      
      if(rs.next()) // (rs.next 커서 다음줄로 옮기기) 데이터가 하나밖에 없기 때문에 while 문이 아닌 if 사용
        count = rs.getInt(1);
      close();
    }catch(Exception e) {
      e.printStackTrace();
    }

    return count;
  }

  @Override
  public BoardDTO getBoardByNo(int board_no) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int insertBoard(BoardDTO board) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int updateBoard(BoardDTO board) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int deleteBoard(int board_no) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public void close() throws Exception {
    if(conn != null) conn.close();
    if(ps != null) ps.close();
    if(rs != null) rs.close();
  }

}

