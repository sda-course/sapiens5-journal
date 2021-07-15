package pl.sda.sapiens5.journal.repository;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import java.time.LocalDate;
import java.util.*;

@Singleton
public class JournalRepositoryMem implements JournalRepository{
    private Map<LocalDate, List<String>> journalLists = new HashMap<>();

    public JournalRepositoryMem(){
    }

    @PostConstruct
    private void post(){
        journalLists.put(LocalDate.of(2021, 7, 12),
                Arrays.asList("Ala", "Ola", "Ewa"));
        journalLists.put(LocalDate.of(2021, 7, 11),
                Arrays.asList("Ala", "Ola", "Ewa", "Karol"));
        journalLists.put(LocalDate.of(2021, 7, 9),
                Arrays.asList("Ala", "Ola", "Ewa", "Olaf"));
    }

    @Override
    public List<LocalDate> findAllDates(){
        return new ArrayList<>(journalLists.keySet());
    }

    @Override
    public List<String> findByDate(LocalDate date){
        return journalLists.getOrDefault(date, Collections.emptyList());
    }

    @Override
    public void save(String[] names, LocalDate date){
        journalLists.put(date, Arrays.asList(names));
    }
}
