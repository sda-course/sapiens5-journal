package pl.sda.sapiens5.journal.service;

import pl.sda.sapiens5.journal.model.StudentGroup;
import pl.sda.sapiens5.journal.repository.StudentGroupRepository;
import pl.sda.sapiens5.journal.repository.StudentGroupRepositoryMap;

public class GroupServiceMemory implements GroupService{
    private final StudentGroupRepository groupRepository= StudentGroupRepositoryMap.getInstance();
    @Override
    public void saveGroup(String groupName) {
        groupRepository.registerGroup(new StudentGroup(groupName));
    }
}
