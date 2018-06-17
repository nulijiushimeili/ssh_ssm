package test;

import moduel.HelloSpring;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    @Test
    public void test01(){
        HelloSpring hs = new HelloSpring();
        System.out.println(hs.getName());
    }

    //IoC 创建bean
    @Test
    public void test02(){
        //加载spring.xml 文件
        //ApplicationContext加载spring.xml的时候就创建了bean
        //ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        //BeanFactory 在使用到某个bean的时候,才会创建(延迟加载)
        BeanFactory factory = new ClassPathXmlApplicationContext("spring.xml");
        //
        //HelloSpring helloSpring = (HelloSpring) factory.getBean("hello");
        //推荐写法
        HelloSpring helloSpring = factory.getBean("hello",HelloSpring.class);
        //helloSpring.setName("小明");
        System.out.println(helloSpring.getName());

    }

    @Test
    public void test03(){
        BeanFactory factory = new ClassPathXmlApplicationContext("spring.xml");
        HelloSpring helloSpring1 = factory.getBean("hello",HelloSpring.class);
        HelloSpring helloSpring2 = factory.getBean("hello",HelloSpring.class);
        System.out.println(helloSpring1 == helloSpring2);    //true
        //在spring.xml文件中配置的bean,默认是单例的 scope = "singleton"
        //通过修改scope的属性值可以设置多例模式 scope = "prototype" ,当作用于为多例模式的时候,创建的bean就是new出来的

    }



}
