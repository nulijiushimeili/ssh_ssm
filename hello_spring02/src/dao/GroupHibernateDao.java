package dao;

import moduel.Group;

public class GroupHibernateDao implements IGroupDao {

    //分层架构的好处,在这个改变dao的来源,不会破坏原来的结构
    @Override
    public void add(Group group) {
        System.out.println("使用hibernate添加group" + group);
    }

    @Override
    public Group load() {
        return null;
    }
}
