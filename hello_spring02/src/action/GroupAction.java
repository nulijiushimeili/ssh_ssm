package action;

import moduel.Group;
import service.GroupService;

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

    public void setGroupService(GroupService groupService) {
        this.groupService = groupService;
    }


}
