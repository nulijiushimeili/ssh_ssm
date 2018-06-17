package spring.test;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.action.GroupAction;
import spring.moduel.Group;

public class GroupTest  {

    @Test
    public void testAction(){
        BeanFactory factory = new ClassPathXmlApplicationContext("spring.xml");
        GroupAction groupAction = factory.getBean("groupAction",GroupAction.class);
//        Group group = new Group();
//        group.setName("java group");
//        groupAction.save(group);
        Group grp1 = factory.getBean("grp1",Group.class);
        groupAction.save(grp1);
    }
}
