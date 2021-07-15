package pl.sda.sapiens5.journal.repository;

import java.time.LocalDate;
import java.util.List;

public interface JournalRepository {
    public List<LocalDate> findAllDates();
    public List<String> findByDate(LocalDate date);
    public void save(String[] names, LocalDate date);
}
