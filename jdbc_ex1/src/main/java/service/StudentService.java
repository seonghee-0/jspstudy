package service;

import common.ActionForward;
import jakarta.servlet.http.HttpServletRequest;


public interface StudentService {
  ActionForward getStudentList(HttpServletRequest request);
}