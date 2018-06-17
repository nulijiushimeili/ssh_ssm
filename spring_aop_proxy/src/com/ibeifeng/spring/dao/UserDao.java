package com.ibeifeng.spring.dao;

import com.ibeifeng.spring.model.User;
import org.springframework.stereotype.Repository;

/**
 * Created by zmzy on 2017/2/16.
 */
@Repository
public class UserDao implements IUserDao {
    @Override
    public void add(User user) {
        System.out.println("添加了:"+user);
    }
}
