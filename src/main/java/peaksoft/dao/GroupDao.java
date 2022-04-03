package peaksoft.dao;
import peaksoft.entity.Group;

import java.util.List;

public interface GroupDao {

    List<Group> groupList();

    void saveGroup(Group group);

    Group findId(Long id);

    void update(Group group);

    void delete(Long id);
}
