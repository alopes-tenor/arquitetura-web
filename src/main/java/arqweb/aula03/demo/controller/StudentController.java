package arqweb.aula03.demo.controller;

import arqweb.aula03.demo.service.StudentService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import arqweb.aula03.demo.model.Student;
import java.util.List;

@RestController
@RequestMapping("/Students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @PostMapping("/add")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @DeleteMapping("/{id}")
    public Student deleteStudentById(@PathVariable int id) {
        return studentService.deleteStudentById(id);
    }

    @PutMapping("/{id}")
    public Student updateStudentById(@PathVariable int id, @RequestBody Student updateStudent){
        return studentService.updateStudentById(id, updateStudent);
    }

}





