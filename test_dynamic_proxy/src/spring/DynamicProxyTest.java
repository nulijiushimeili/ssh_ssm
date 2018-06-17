package spring;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {
    @Test
    public void test01(){
        Iuser iuser = new UserImpl();
        InvocationHandler invocationHandler = new DynamicProxy(iuser);
        Iuser proxy = (Iuser) Proxy.newProxyInstance(Iuser.class.getClassLoader(),new Class[]{Iuser.class},invocationHandler);
        proxy.eat("苹果");
    }
}
