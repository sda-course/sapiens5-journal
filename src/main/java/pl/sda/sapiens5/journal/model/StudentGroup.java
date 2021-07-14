package pl.sda.sapiens5.journal.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StudentGroup {
    private final List<Student> students;
    private final String name;

    public StudentGroup(String name) {
        this.students = new ArrayList<>();
        this.name = name;
    }

    public Stream<Student> getStudents() {
        return students.stream();
    }

    public String getName() {
        return name;
    }

    public void addStudent(Student student){
        students.add(student);
    }
}
