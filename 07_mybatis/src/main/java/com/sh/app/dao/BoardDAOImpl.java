package com.sh.app.dao;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sh.app.dto.BoardDTO;

public class BoardDAOImpl implements BoardDAO {
  
  /* MyBatis Framework 사용 시 SqlSessionFactory 객체 선언 (Connection / PreparedStatement / ResultSet 대신 활용) */
  // field 선언
  private SqlSessionFactory factory;   
  
  // Singleton Pattern
  private BoardDAOImpl() {
    // SqlSessionFactory factory Build
    try {
      String resource = "com/sh/app/config/mybatis-config.xml";
      InputStream inputStream = Resources.getResourceAsStream(resource);
      factory = new SqlSessionFactoryBuilder().build(inputStream); //SqlSession 객체를 만드는 factory 가 있어야 호출 가능
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  private static BoardDAO boardDAO = new BoardDAOImpl();
  public static BoardDAO getInstance() { // 반환타입 BoardDAO
    return boardDAO;
  }
  
  private final String NS = "com.sh.app.dao.BoardMapper.";

  @Override
  public int getBoardCount() {
    SqlSession ss = factory.openSession();
    int count = ss.selectOne(NS + "getBoardCount");
    return count;
  }

  @Override
  public List<BoardDTO> getBoardList(Map<String, Object> params) {
    SqlSession ss = factory.openSession();
    List<BoardDTO> boardList = ss.selectList(NS+"getBoardList",params);
    ss.close();
    return boardList;
  }

  @Override
  public BoardDTO getBoardByNo(int boardNo) {
    SqlSession ss = factory.openSession();
    BoardDTO board = ss.selectOne("com.sh.app.dao.BoardMapper.getBoardByNo", boardNo);
    ss.close();
    return board; // 결과를 받아와서 리턴
    
  }

  @Override
  public int insertBoard(BoardDTO board) {
    SqlSession ss = factory.openSession(false); // autoCommit = false 
    int result = ss.insert(NS + "insertBoard",board);
    if(result == 1) ss.commit();
    ss.close();
    return result;
  }

  @Override
  public int updateBoard(BoardDTO board) {
    SqlSession ss = factory.openSession(false);
    int result = ss.update(NS + "updateBoard", board);
    if(result > 0) ss.commit();
    ss.close();
    return result;
  }

  @Override
  public int deleteBoard(int boardNo) {
    SqlSession ss = factory.openSession(false);
    int result = ss.delete(NS + "deletBoard", boardNo);
    if(result > 0) ss.commit();
    ss.close();
    return result;
  }

}
