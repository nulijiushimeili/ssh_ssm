package learn.spring.service;

import learn.spring.dao.IGroupDao;
import learn.spring.model.Group;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("groupService")
public class GroupService implements IGroupService {
    private IGroupDao groupDao;

    @Override
    public void save(Group group) {
        groupDao.add(group);
    }

    @Override
    public Group load() {
        return groupDao.load();
    }

    @Resource(name="groupDao")
    public void setGroupDao(IGroupDao groupDao) {
        this.groupDao = groupDao;
    }
}
