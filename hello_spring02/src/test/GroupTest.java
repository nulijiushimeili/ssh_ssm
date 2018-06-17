package test;

import action.GroupAction;
import moduel.Group;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GroupTest {

    @Test
    public void test01(){
        BeanFactory factory = new ClassPathXmlApplicationContext("spring.xml");
        GroupAction groupAction = factory.getBean("groupAction",GroupAction.class);
        //groupAction.save();
        Group group1 = factory.getBean("grp1",Group.class);
        group1.setName("研发组");
        Group group2 = factory.getBean("grp1",Group.class);
        group2.setName("财务组");
        System.out.println(group1 == group2);    //默认是单例模式,true
        System.out.println(group1);             //  Group{id=1, name='财务组'}

        //在spring.xml文件中配置grp1 设置scope = "prototype"  就会变为多例模式
        //在对象经常发生改变的情况下,使用多例模式

    }
}
