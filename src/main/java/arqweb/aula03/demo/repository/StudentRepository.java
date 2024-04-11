package arqweb.aula03.demo.repository;

import arqweb.aula03.demo.model.Students;

import java.util.List;

public interface StudentRepository {
    List<Students> findAll();
    Students findById(Long id);
    Students save(Long id, Students student);
    Students delete(Long id);
}
