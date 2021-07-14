package pl.sda.sapiens5.journal.repository;

import pl.sda.sapiens5.journal.model.StudentGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum StudentGroupRepositoryMap implements StudentGroupRepository{
    INSTANCE;
    public static StudentGroupRepository getInstance(){
        return INSTANCE;
    }

    private Map<String, StudentGroup> groups = new HashMap<>();

    @Override
    public StudentGroup findByName(String name) {
        return groups.get(name);
    }

    @Override
    public List<StudentGroup> findAll() {
        return new ArrayList<>(groups.values());
    }

    @Override
    public StudentGroup registerGroup(StudentGroup studentGroup) {
        return groups.put(studentGroup.getName(), studentGroup);
    }
}
