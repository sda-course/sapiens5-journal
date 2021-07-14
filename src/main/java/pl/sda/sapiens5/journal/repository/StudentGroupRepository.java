package pl.sda.sapiens5.journal.repository;

import pl.sda.sapiens5.journal.model.StudentGroup;

import java.util.List;

public interface StudentGroupRepository {
    StudentGroup findByName(String name);
    List<StudentGroup> findAll();
    StudentGroup registerGroup(StudentGroup studentGroup);
}
