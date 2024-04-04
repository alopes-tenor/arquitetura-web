package arqweb.aula03.demo.service;

import arqweb.aula03.demo.model.Student;
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
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student createStudent(Long id, Student student) {
        student.setRegister(student.getRegister());
        return studentRepository.save(id, student);
    }

    @Override
    public Student deleteStudentById(Long id) {
        return studentRepository.delete(id);
    }

    @Override
    public Student updateStudentById(Long id, Student student) {

        return studentRepository.save(id, student);
    }
}