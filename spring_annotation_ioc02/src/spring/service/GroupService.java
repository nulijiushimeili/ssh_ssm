package spring.service;

import org.springframework.stereotype.Component;
import spring.dao.GroupDao;
import spring.moduel.Group;

import javax.annotation.Resource;

@Component("groupService")
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
    @Resource(name = "groupDao")
    public void setGroupDao(GroupDao groupDao) {
        this.groupDao = groupDao;
    }
}
