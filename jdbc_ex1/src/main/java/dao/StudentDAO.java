package dao;

import java.util.List;
import java.util.Map;

import dto.StudentDTO;

public interface StudentDAO {
  List<StudentDTO> getStudentList(Map<String, Object> params); // boardDTO가 여러개 담겨있는 list
 

  void close() throws Exception; // close 작업
  
}
