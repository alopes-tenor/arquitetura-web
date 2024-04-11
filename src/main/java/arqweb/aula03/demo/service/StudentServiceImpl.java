package arqweb.aula03.demo.service;

import arqweb.aula03.demo.model.Students;
import arqweb.aula03.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @Override
    public List<Students> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Students getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Students createStudent(Long id, Students student) {
        student.setRegister(student.getRegister());
        return studentRepository.save(id, student);
    }

    @Override
    public Students deleteStudentById(Long id) {
        return studentRepository.delete(id);
    }

    @Override
    public Students updateStudentById(Long id, Students student) {

        return studentRepository.save(id, student);
    }
}