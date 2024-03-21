package arqweb.aula03.demo.service;

import arqweb.aula03.demo.model.Student;
import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(int id);
    Student createStudent(Student student);
    Student deleteStudentById(int id);
    Student updateStudentById(int id, Student student);
}