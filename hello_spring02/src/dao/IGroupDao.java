package dao;

import moduel.Group;

public interface IGroupDao {
    public void add(Group group);

    public Group load();
}
