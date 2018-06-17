package service;

import dao.GroupDao;
import moduel.Group;

public class GroupService implements IGroupService {
    //GroupDao groupDao = new GroupDao() ;

    private GroupDao groupDao;

    @Override
    public void save(Group group) {
        groupDao.add(group);
    }

    public GroupDao getGroupDao() {
        return groupDao;
    }

    public void setGroupDao(GroupDao groupDao) {
        this.groupDao = groupDao;
    }
}
