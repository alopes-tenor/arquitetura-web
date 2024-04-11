package arqweb.aula03.demo.service;

import arqweb.aula03.demo.model.Students;
import java.util.List;

public interface StudentService {
    List<Students> getAllStudents();
    Students getStudentById(Long id);
    Students createStudent(Long id, Students student);
    Students deleteStudentById(Long id);
    Students updateStudentById(Long id, Students student);
}