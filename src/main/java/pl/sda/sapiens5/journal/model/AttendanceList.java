package pl.sda.sapiens5.journal.model;
import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Stream;

public class AttendanceList {
    private final LocalDate date;
    private final StudentGroup studentGroup;
    private final Set<Student> list;

    public AttendanceList(LocalDate date, StudentGroup studentGroup, Set<Student> list) {
        this.date = date;
        this.studentGroup = studentGroup;
        this.list = list;
    }

    public LocalDate getDate() {
        return date;
    }

    public Stream<Student> getList() {
        return list.stream();
    }

    public int countPresence(){
        return list.size();
    }

    public int countAbsence(){
        return (int) (studentGroup.getStudents().count() - list.size());
    }

    public StudentGroup getStudentGroup() {
        return studentGroup;
    }
}
