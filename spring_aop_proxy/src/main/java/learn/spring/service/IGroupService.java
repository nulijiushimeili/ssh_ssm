package learn.spring.service;

import learn.spring.model.Group;

/**
 * Created by zmzy on 2017/2/15.
 */
public interface IGroupService {
    public void save(Group group);
    public Group load();
}
