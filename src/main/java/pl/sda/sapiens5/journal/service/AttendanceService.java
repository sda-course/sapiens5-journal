package pl.sda.sapiens5.journal.service;

import pl.sda.sapiens5.journal.model.AttendanceList;
import pl.sda.sapiens5.journal.model.Student;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface AttendanceService {
    void saveList(Set<String> studentIds, LocalDate date, String groupName);
    Set<AttendanceList> findByDate(LocalDate date);
    Set<AttendanceList> fndByGroup(String group);
}
