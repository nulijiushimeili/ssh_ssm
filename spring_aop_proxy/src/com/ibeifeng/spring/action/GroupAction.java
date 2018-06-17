package com.ibeifeng.spring.action;

import com.ibeifeng.spring.model.Group;
import com.ibeifeng.spring.service.GroupService;
import com.ibeifeng.spring.service.IGroupService;
import com.ibeifeng.spring.service.IUserService;
import org.springframework.stereotype.Component;
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
