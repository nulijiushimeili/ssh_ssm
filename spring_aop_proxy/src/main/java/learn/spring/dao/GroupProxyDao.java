package learn.spring.dao;

import learn.spring.log.Logger;
import learn.spring.model.Group;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;


@Repository
public class GroupProxyDao implements IGroupDao {
    private IGroupDao groupDao;

    @Resource
    public void setGroupDao(IGroupDao groupDao) {
        this.groupDao = groupDao;
    }

    @Override
    public void add(Group group) {
        Logger.log("执行了新增操作");
        groupDao.add(group);
    }

    @Override
    public Group load() {
        return null;
    }
}
