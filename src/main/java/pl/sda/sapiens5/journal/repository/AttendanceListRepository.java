package pl.sda.sapiens5.journal.repository;

import pl.sda.sapiens5.journal.model.AttendanceList;
import pl.sda.sapiens5.journal.model.StudentGroup;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface AttendanceListRepository {
    Set<AttendanceList> findByDate(LocalDate date);
    Set<AttendanceList> findByGroup(StudentGroup group);
    void registerList(AttendanceList list);
}
