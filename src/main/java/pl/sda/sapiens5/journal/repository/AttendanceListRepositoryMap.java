package pl.sda.sapiens5.journal.repository;

import pl.sda.sapiens5.journal.model.AttendanceList;
import pl.sda.sapiens5.journal.model.StudentGroup;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public enum AttendanceListRepositoryMap implements AttendanceListRepository {
    INSTANCE;

    public static AttendanceListRepository getInstance(){
        return INSTANCE;
    }

    private final Map<LocalDate, Set<AttendanceList>> lists = new HashMap<>();

    @Override
    public Set<AttendanceList> findByDate(LocalDate date) {
        return lists.get(date);
    }

    @Override
    public Set<AttendanceList> findByGroup(StudentGroup group) {
        return lists.values()
                .stream()
                .filter(list -> list.stream().anyMatch(a -> Objects.equals(a.getStudentGroup(), group)))
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }

    @Override
    public void registerList(AttendanceList list) {
        lists.putIfAbsent(list.getDate(), new HashSet<>());
        lists.computeIfPresent(list.getDate(), (key, oldValue) -> {
            oldValue.add(list);
            return oldValue;
        });
    }
}
