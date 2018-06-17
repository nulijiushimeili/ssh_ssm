package spring.dao;

import spring.moduel.User;

public class UserDao implements IUser {
    @Override
    public void add(User user) {
        System.out.println("添加了" + user);
    }
}
