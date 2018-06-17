package spring.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import spring.moduel.Group;

@Repository("groupHibernateDao")
public class GroupHibernateDao implements IGroupDao {
    @Override
    public void add(Group group) {
        System.out.println("使用hibernate添加了" + group);
    }

    @Override
    public Group load() {
       return null;
    }
}
