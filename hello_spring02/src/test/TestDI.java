package test;

import moduel.Group;
import moduel.User;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestDI {

    //数组属性注入
    @Test
    public void test01(){
        BeanFactory factory = new ClassPathXmlApplicationContext("spring.xml");
        User user = factory.getBean("user",User.class);
        String[] names = user.getNames();

        for ( String name : names          ) {
            System.out.println(name);
        }
    }

    //list集合注入
    @Test
    public void test02(){
        BeanFactory factory = new ClassPathXmlApplicationContext("spring.xml");
        User user = factory.getBean("user" , User.class);
        List<Group> groups = user.getGroups();
        for (Group g : groups             ) {
            System.out.println(g.getName());
        }
    }

    //map 集合注入
    @Test
    public void test03(){
        BeanFactory factory = new ClassPathXmlApplicationContext("spring.xml");
        User user = factory.getBean("user",User.class);
        Map<String , Group> maps = user.getMaps();
        Set<String> setKeys = maps.keySet();
        for (String s : setKeys             ) {
            Group group = maps.get(s);
            System.out.println(s + " : " + group.getName());
        }
    }

}
