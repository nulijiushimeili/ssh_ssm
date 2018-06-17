package dao;

import moduel.Group;

public class GroupDao implements IGroupDao {
    @Override
    public void add(Group group) {
        System.out.println("添加了" + group);
    }

    @Override
    public Group load() {
        return null;
    }
}
