package arqweb.aula03.demo.service;

import arqweb.aula03.demo.model.Student;
import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student createStudent(Long id, Student student);
    Student deleteStudentById(Long id);
    Student updateStudentById(Long id, Student student);
}