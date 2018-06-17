package com.ibeifeng.spring.test;

import com.ibeifeng.spring.action.GroupAction;
import com.ibeifeng.spring.model.Group;
import com.ibeifeng.spring.model.User;
import com.ibeifeng.spring.service.GroupService;
import com.ibeifeng.spring.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zmzy on 2017/2/15.
 */
public class GroupTest {
    @Test
    public void test(){
        BeanFactory factory = new ClassPathXmlApplicationContext("spring.xml");
        GroupAction groupAction = factory.getBean("groupAction", GroupAction.class);
        Group group1 = factory.getBean("grp1",Group.class);
        group1.setName("研发组");
        groupAction.save(group1);

        GroupService groupService = factory.getBean("groupService",GroupService.class);
        groupService.load();

        UserService userService = factory.getBean("userService", UserService.class);
        User user = new User();
        userService.save(user);

    }

    @Test
    public void testAop(){
        BeanFactory factory = new ClassPathXmlApplicationContext("spring.xml");
        GroupAction groupAction = factory.getBean("groupAction", GroupAction.class);
        Group group1 = factory.getBean("grp1",Group.class);
        group1.setName("研发组");
        groupAction.save(group1);
    }
}
