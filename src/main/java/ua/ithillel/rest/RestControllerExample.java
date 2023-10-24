package ua.ithillel.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.ithillel.dao.student.StudentDto;
import ua.ithillel.dao.student.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RestControllerExample {
    private final StudentService studentService;

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

    //update
    //delete


}
