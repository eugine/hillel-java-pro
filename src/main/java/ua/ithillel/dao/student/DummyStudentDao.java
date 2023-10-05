package ua.ithillel.dao.student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.toMap;

public class DummyStudentDao implements StudentDao {

    private final Map<Long, Student> students;

    public DummyStudentDao(List<Student> students) {
        this.students = new HashMap<>(students.stream().collect(toMap(Student::getId, x -> x)));
    }

    @Override
    public List<Student> findAll() {
        return students.values().stream().toList();
    }

    @Override
    public Optional<Student> findById(Long id) {
        return Optional.ofNullable(students.get(id));
    }

    @Override
    public List<Student> findByName(String name) {
        return students.values().stream()
                .filter(student -> student.getName().equals(name))
                .toList();
    }

    @Override
    public void persist(Student student) {
        students.put(student.getId(), student);
    }

    @Override
    public void update(Student student) {
        if (students.containsKey(student.getId())) {
            students.put(student.getId(), student);
        }
    }

    @Override
    public boolean delete(Long id) {
        return students.remove(id) != null;
    }
}
