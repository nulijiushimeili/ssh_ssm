package learn.spring.dao;

import learn.spring.model.Group;
import org.springframework.stereotype.Repository;

@Repository("groupDao")
public class GroupDao implements IGroupDao {
    @Override
    public void add(Group group) {
//        System.out.println(1/0);
        System.out.println("添加了:"+group);
    }

    @Override
    public Group load() {
        System.out.println("查找到了Group");
        return null;
    }
}
