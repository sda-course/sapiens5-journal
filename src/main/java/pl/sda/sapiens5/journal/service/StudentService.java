package pl.sda.sapiens5.journal.service;

import pl.sda.sapiens5.journal.model.Student;
import pl.sda.sapiens5.journal.model.StudentGroup;

import java.time.LocalDate;
import java.util.List;

public interface StudentService {
    void registerStudent(String firstName, String lastName, LocalDate birthDate);
    Student findById(String studentId);
    List<StudentGroup> findStudentGroupsById(String studentId);
    boolean registerStudentToGroup(String studentId, String groupName);
}
