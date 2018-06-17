package spring.dao;

import org.springframework.stereotype.Component;
import spring.moduel.Group;

@Component("groupDao")
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
