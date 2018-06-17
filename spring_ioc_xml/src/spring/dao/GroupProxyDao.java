package spring.dao;

import org.springframework.stereotype.Repository;
import spring.log.Logger;
import spring.moduel.Group;

import javax.annotation.Resource;

@Repository
public class GroupProxyDao implements IGroupDao {

    public IGroupDao getGroupDao() {
        return groupDao;
    }

    @Resource
    public void setGroupDao(IGroupDao groupDao) {
        this.groupDao = groupDao;
    }

    private IGroupDao groupDao;

    @Override
    public void add(Group group) {
        Logger.log("新增日志");
        System.out.println("添加了group dao");
    }

    @Override
    public Group load() {

        System.out.println(" 加载 group");
        return null;
    }
}
