package pl.sda.sapiens5.journal;

import java.time.LocalDate;
import java.util.*;

public enum JournalRepository {
    INSTANCE;

    public static JournalRepository getInstance(){
        return INSTANCE;
    }

    private Map<LocalDate, List<String>> journalLists = new HashMap<>();

    JournalRepository(){
        journalLists.put(LocalDate.of(2021, 7, 12),
                Arrays.asList("Ala", "Ola", "Ewa"));
        journalLists.put(LocalDate.of(2021, 7, 11),
                Arrays.asList("Ala", "Ola", "Ewa", "Karol"));
        journalLists.put(LocalDate.of(2021, 7, 9),
                Arrays.asList("Ala", "Ola", "Ewa", "Olaf"));
    }

    public List<LocalDate> findAllDates(){
        return new ArrayList<>(journalLists.keySet());
    }

    public List<String> findByDate(LocalDate date){
        return journalLists.getOrDefault(date, Collections.emptyList());
    }
}
