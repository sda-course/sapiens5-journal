package pl.sda.sapiens5.journal.repository;

import pl.sda.sapiens5.journal.model.Student;

import java.util.List;

public interface StudentRepository {
    Student findById(String uuid);
    List<Student> findAll();
    Student registerStudent(Student student);
}
