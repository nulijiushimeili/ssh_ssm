package spring.action;

import org.springframework.stereotype.Component;
import spring.moduel.Group;
import spring.service.GroupService;

import javax.annotation.Resource;

@Component("groupAction")
public class GroupAction {
    //GroupService groupService = new GroupService();

    private GroupService groupService;

    private Group group;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void save(){
        groupService.save(group);
    }

    public GroupService getGroupService() {
        return groupService;
    }

    @Resource(name = "groupService")
    public void setGroupService(GroupService groupService) {
        this.groupService = groupService;
    }


}
