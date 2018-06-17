package spring.dao;

import spring.moduel.Group;

public interface IGroupDao {
    public void add(Group group);

    public Group load();
}
