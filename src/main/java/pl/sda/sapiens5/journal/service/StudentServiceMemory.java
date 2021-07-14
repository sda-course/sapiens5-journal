package pl.sda.sapiens5.journal.service;

import pl.sda.sapiens5.journal.model.Student;
import pl.sda.sapiens5.journal.model.StudentGroup;
import pl.sda.sapiens5.journal.repository.StudentGroupRepository;
import pl.sda.sapiens5.journal.repository.StudentGroupRepositoryMap;
import pl.sda.sapiens5.journal.repository.StudentRepository;
import pl.sda.sapiens5.journal.repository.StudentRepositoryMap;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StudentServiceMemory implements StudentService{
    private final StudentRepository studentRepository = StudentRepositoryMap.getInstance();
    private final StudentGroupRepository studentGroupRepository = StudentGroupRepositoryMap.getInstance();

    @Override
    public void registerStudent(String firstName, String lastName, LocalDate birthDate) {
        Student student = studentRepository.registerStudent(new Student(firstName, lastName, birthDate));
    }

    @Override
    public Student findById(String studentId) {
        return studentRepository.findById(studentId);
    }

    @Override
    public List<StudentGroup> findStudentGroupsById(String studentId) {
        return studentGroupRepository.findAll()
                .stream()
                .filter(studentGroup -> studentGroup.getStudents().anyMatch(s -> Objects.equals(s.getId(), studentId)))
                .collect(Collectors.toList());
    }

    @Override
    public boolean registerStudentToGroup(String studentId, String groupName) {
        Student student = studentRepository.findById(studentId);
        if (student != null) {
            studentGroupRepository.findByName(groupName).addStudent(student);
            return true;
        } else{
            return false;
        }

    }
}
