package spring.dao;


import org.springframework.stereotype.Repository;
import spring.moduel.Group;

@Repository("groupDao")
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
