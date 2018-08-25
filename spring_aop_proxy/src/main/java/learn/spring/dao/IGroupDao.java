package learn.spring.dao;

import learn.spring.annotation.Log;
import learn.spring.model.Group;

/**
 * Created by zmzy on 2017/2/15.
 */
public interface IGroupDao {
    @Log("执行了添加组操作")
    public void add(Group group);
    public Group load();
}
