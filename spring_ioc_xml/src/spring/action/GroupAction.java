package spring.action;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import spring.moduel.Group;
import spring.service.GroupService;
import spring.service.IGroupService;

import javax.annotation.Resource;

@Controller("groupAction")
public class GroupAction {
    private IGroupService groupService ;//= new GroupService();

    private Group group;

    public IGroupService getGroupService() {
        return groupService;
    }

    @Resource
    public void setGroupService(IGroupService groupService) {
        this.groupService = groupService;
    }

    public String save(Group group){
        groupService.save(group);
        return "success";
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
