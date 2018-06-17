package com.ibeifeng.spring.dao;

import com.ibeifeng.spring.log.Logger;
import com.ibeifeng.spring.model.Group;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by zmzy on 2017/2/16.
 */
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
