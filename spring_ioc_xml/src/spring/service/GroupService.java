package spring.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import spring.dao.GroupDao;
import spring.dao.GroupHibernateDao;
import spring.dao.IGroupDao;
import spring.moduel.Group;

import javax.annotation.Resource;

@Service("groupService")
public class GroupService implements IGroupService {
    //IGroupDao groupDao = new GroupDao();

//    将属性交给spring管理
    //IGroupDao groupDao = new GroupHibernateDao();
    private IGroupDao groupDao;

    @Override
    public void save(Group group) {
        groupDao.add(group);
    }

    public IGroupDao getGroupDao() {
        return groupDao;
    }
    //@Resource(name = "groupDao")
    @Resource(name = "logDynamicProxy")
    public void setGroupDao(IGroupDao groupDao) {
        this.groupDao = groupDao;
    }
}
