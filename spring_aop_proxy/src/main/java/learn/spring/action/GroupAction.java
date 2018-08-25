package learn.spring.action;

import learn.spring.model.Group;
import learn.spring.service.IGroupService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by zmzy on 2017/2/15.
 */
@Controller("groupAction")
public class GroupAction {

    private IGroupService groupService;
    private Group group;

    public String save(Group group){
        groupService.save(group);
        return "success";
    }

    @Resource
    public void setGroupService(IGroupService groupService) {
        this.groupService = groupService;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
