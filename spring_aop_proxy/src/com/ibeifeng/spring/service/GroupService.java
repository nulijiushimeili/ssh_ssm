package com.ibeifeng.spring.service;

import com.ibeifeng.spring.dao.IGroupDao;
import com.ibeifeng.spring.dao.IUserDao;
import com.ibeifeng.spring.model.Group;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zmzy on 2017/2/15.
 */
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
