package peaksoft.service;

import peaksoft.entity.Group;

import java.util.List;

public interface GroupService {

    List<Group> groupList();

    void saveGroup(Group group);

    Group findId(Long id);

    void update(Group group);

    void delete(Long id);

}
