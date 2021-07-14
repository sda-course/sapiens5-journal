package pl.sda.sapiens5.journal.repository;

import pl.sda.sapiens5.journal.model.Student;

import java.util.*;

public enum StudentRepositoryMap implements StudentRepository{
    INSTANCE;
    StudentRepositoryMap() {
        students = new HashMap<>();
    }

    public static StudentRepositoryMap getInstance(){
        return INSTANCE;
    }

    private final Map<UUID, Student> students;

    @Override
    public Student findById(String uuid) {
        return students.get(UUID.fromString(uuid));
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students.values());
    }

    @Override
    public Student registerStudent(Student student) {
        return students.put(student.getId(), student);
    }
}
