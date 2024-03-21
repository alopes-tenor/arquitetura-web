package arqweb.aula03.demo.repository;

import org.springframework.stereotype.Repository;
import arqweb.aula03.demo.model.Student;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    private final List<Student> students = new ArrayList<>();
    private int nextId;

    public StudentRepositoryImpl() {
        students.add(new Student(1, "Amanda Lopes"    , "222296", 19 , "ADS"));
        students.add(new Student(2, "Sofia Belon" , "222716", 21 , "ADS"));
        students.add(new Student(3, "Paulo Magro"   , "191004", 23 , "ENG. ELÉTRICA"));
        students.add(new Student(4, "Gustavo de Almeida", "222597", 20, "ENG. COMPUTAÇÃO"));
        students.add(new Student(5, "Luiz Obara"  , "222252", 21 , "ADS"));
        nextId = 6;
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public Student findById(int id) {
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Student save(Student student) {
        if (student.getId() == null) {
            student.setId(nextId++);
            students.add(student);
        } else {
            students.removeIf(t -> t.getId().equals(student.getId()));
            students.add(student);
        }
        return student;
    }

    @Override
    public Student delete(int id){
        Student deletedStudent = this.findById(id);
        if (deletedStudent != null) {
            students.removeIf(student -> student.getId().equals(id));
        }
        return deletedStudent;
    }

    @Override
    public Student update(int id, Student student){
        Student updateStudent = this.findById(id);
        if (updateStudent != null) {
            students.set(students.indexOf(updateStudent), student);
        }
        return student;
    }
}/
