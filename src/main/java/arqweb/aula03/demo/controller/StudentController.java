package arqweb.aula03.demo.controller;

import arqweb.aula03.demo.service.StudentService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import arqweb.aula03.demo.model.Students;
import java.util.List;

@RestController
@RequestMapping("/Students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Students> getAllStudents() {

        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Students getStudentById(@PathVariable Long id) {

        return studentService.getStudentById(id);
    }

    @PostMapping("/add")
    public Students createStudent(@RequestBody Students student) {
        Long id = null;
        return studentService.createStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public Students deleteStudentById(@PathVariable Long id) {

        return studentService.deleteStudentById(id);
    }

    @PutMapping("/{id}")
    public Students updateStudentById(@PathVariable Long id, @RequestBody Students updateStudent){
        return studentService.updateStudentById(id, updateStudent);
    }

}





