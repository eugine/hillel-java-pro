package ua.ithillel.dao.student;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StudentService {
    private final StudentDao dao;

    protected StudentService(StudentDao dao) {
        this.dao = dao;
    }

    public List<StudentDto> findAll() {
        return dao.findAll().stream()
                .map(StudentDto::from)
                .toList();
    }

    public Optional<StudentDto> findById(Long id) {
        return dao.findById(id)
                .map(StudentDto::from);
    }

    public List<StudentDto> findByName(String name) {
        return dao.findByName(name).stream()
                .map(StudentDto::from)
                .toList();
    }

    public StudentDto persist(StudentDto student) {
        dao.persist(Student.builder()
                        .name(student.name())
                        .age(Optional.ofNullable(student.age()).orElse(-1))
                        .email(student.email())
                        .major(student.major())
                        .createAt(LocalDateTime.now())
                        .updatedAt(LocalDateTime.now())
                .build());
        return findLatestByName(student);
    }

    private StudentDto findLatestByName(StudentDto student) {
        return dao.findByName(student.name()).stream()
                .max(Comparator.comparing(Student::getUpdatedAt))
                .map(StudentDto::from)
                .orElseThrow();
    }

    public StudentDto update(StudentDto student) {
        dao.update(Student.builder()
                        .id(student.id())
                        .name(student.name())
                        .email(student.email())
                        .major(student.major())
                        .age(student.age())
                        .updatedAt(LocalDateTime.now())
                .build());
        return findLatestByName(student);
    }

}
