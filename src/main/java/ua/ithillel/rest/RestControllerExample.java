package ua.ithillel.rest;

import org.springframework.web.bind.annotation.*;
import ua.ithillel.dao.student.StudentDto;
import ua.ithillel.dao.student.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestControllerExample {
    private final StudentService studentService;

    public RestControllerExample(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<StudentDto> getStudents() {
        return studentService.findAll();
    }

    @GetMapping("/students/{id}")
    public StudentDto getStudent(@PathVariable("id") Long studentId) {
        return studentService.findById(studentId).orElseThrow();
    }

    @PostMapping("/students")
    public StudentDto createStudent(@RequestBody StudentDto request) {
        return studentService.persist(request);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable("id") Long studentId) {
        studentService.delete(studentId);
    }

    @PutMapping("/students/{id}")
    public StudentDto updateStudent(@PathVariable("id") Long studentId, @RequestBody StudentDto request) {
        return studentService.update(studentId, request);
    }


}
