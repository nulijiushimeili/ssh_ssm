package spring.other;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.moduel.Group;
import spring.moduel.User;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class TestSpring {

    //test get bean from spring.xml
    @Test
    public void test02(){
        BeanFactory beanFactory= new ClassPathXmlApplicationContext("spring.xml");
        HelloSpring helloSpring = beanFactory.getBean("hello",HelloSpring.class);
        System.out.println(helloSpring.getName());;
    }

    @Test
    public void test03(){
        PlayMusic playMusic1 = PlayMusic.getInstance();
        PlayMusic playMusic2 = PlayMusic.getInstance();
        System.out.println(playMusic1 == playMusic2);

    }

    //单例模式联系
    @Test
    public void testSit(){
        Sit sit1 = Sit.getInstance();
        Sit sit2 = Sit.getInstance();
        sit2.sit("小明");
        System.out.println(sit1 == sit2);
    }

    //数组注入
    @Test
    public void testArrayDI(){
        BeanFactory factory = new ClassPathXmlApplicationContext("spring.xml");
        User user = factory.getBean("user",User.class);
        String[] names = user.getNames();
        for (String name :names             ) {
            System.out.println(name);
        }
    }

    //测试list注入
    @Test
    public void testListDI(){
        BeanFactory factory = new ClassPathXmlApplicationContext("spring.xml");
        User user = factory.getBean("user",User.class);
        List<Group> groups = user.getList();
        for (Group g : groups             ) {
            System.out.println(g);
        }
    }

    //测试set注入
    @Test
    public void testSetDI(){
        BeanFactory factory = new ClassPathXmlApplicationContext("spring.xml");
        User user = factory.getBean("user",User.class);
        Set<Group> sets = user.getSets();
        for (Group g : sets             ) {
            System.out.println(g.toString());
        }
    }

    //test map 注入
    @Test
    public void testMap(){
        BeanFactory factory = new ClassPathXmlApplicationContext("spring.xml");
        User user = factory.getBean("user",User.class);
        Map<String , Group> maps = user.getMaps();
        for (String key : maps.keySet()) {
            System.out.println(key + "---" + maps.get(key));
        }
    }

    //使用iterate遍历map集合
    @Test
    public void testMap2(){
        BeanFactory factory = new ClassPathXmlApplicationContext("spring.xml");
        User user = factory.getBean("user",User.class);
        Map<String,Group> maps = user.getMaps();
        Set<String> keys = maps.keySet();
        Iterator<String> its = keys.iterator();
        while(its.hasNext()){
            String key = its.next();
            Group group = maps.get(key);
            System.out.println(key + " ----" + group.toString());
        }
    }

}
