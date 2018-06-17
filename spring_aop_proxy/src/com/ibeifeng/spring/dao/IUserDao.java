package com.ibeifeng.spring.dao;

import com.ibeifeng.spring.annotation.Log;
import com.ibeifeng.spring.model.User;

/**
 * Created by zmzy on 2017/2/16.
 */
public interface IUserDao {
    @Log("执行了添加用户操作")
    void add(User user);
}
