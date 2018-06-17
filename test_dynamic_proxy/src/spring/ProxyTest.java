package spring;

import org.junit.Test;


public class ProxyTest {
    @Test
    public void test01(){
        UserImpl user = new UserImpl();
        user.eat("agg");
    }

//    使用静态代理模式
    @Test
    public void test02(){
        UserProxy userProxy = new UserProxy();
        userProxy.eat("apple");
    }
}
