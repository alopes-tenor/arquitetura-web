package arqweb.aula03.demo.repository;

import arqweb.aula03.demo.model.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> findAll();
    Student findById(int id);
    Student save(Student student);
    Student delete(int id);

    Student update(int id, Student student);
}