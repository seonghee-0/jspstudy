package service;



import common.ActionForward;
import dao.StudentDAO;
import dao.StudentDAOImpl;
import jakarta.servlet.http.HttpServletRequest;

public class StudentServiceImpl implements StudentService {

  //Field
  private StudentDAO studentDAO = StudentDAOImpl.getInstance();

  
@Override
public ActionForward getStudentList(HttpServletRequest request) {
	// TODO Auto-generated method stub
	return null;
}
  
  
  


}
