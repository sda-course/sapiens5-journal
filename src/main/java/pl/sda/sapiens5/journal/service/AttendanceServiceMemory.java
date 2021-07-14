package pl.sda.sapiens5.journal.service;

import pl.sda.sapiens5.journal.model.AttendanceList;
import pl.sda.sapiens5.journal.model.Student;
import pl.sda.sapiens5.journal.model.StudentGroup;
import pl.sda.sapiens5.journal.repository.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AttendanceServiceMemory implements AttendanceService{
    private final AttendanceListRepository attendanceRepository = AttendanceListRepositoryMap.getInstance();
    private final StudentRepository studentRepository = StudentRepositoryMap.getInstance();
    private final StudentGroupRepository groupRepository = StudentGroupRepositoryMap.getInstance();
    @Override
    public void saveList(Set<String> studentIds, LocalDate date, String groupName) {
        StudentGroup group = groupRepository.findByName(groupName);
        if (group != null) {
            Set<Student> set = groupRepository.findByName(groupName).getStudents()
                    .filter(s -> studentIds.contains(s.getId()))
                    .collect(Collectors.toSet());
            AttendanceList list = new AttendanceList(date, group, set);
        }
    }

    @Override
    public Set<AttendanceList> findByDate(LocalDate date) {
        return attendanceRepository.findByDate(date);
    }

    @Override
    public Set<AttendanceList> fndByGroup(String group) {
        return null;
    }
}
