package learn.spring.proxy;

import learn.spring.annotation.Log;
import learn.spring.log.Logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 1.创建一个类实现InvocationHandler接口
 * Created by zmzy on 2017/2/16.
 */
public class LogProxy implements InvocationHandler {
    private LogProxy(){}
    //2.创建代理对象
    private Object target;
    //3.返回代理对象
    public static Object getInstance(Object o){  //参数o：要代理的对象
        //4.将要代理的对象赋值给代理对象
        LogProxy logProxy = new LogProxy();
        logProxy.target = o;
        /**
         * 5
         * 第一个参数：要代理对象的ClassLoader
         * 第二个参数：要代理对象的所有接口
         * 第三个参数：实现了InvocationHandler接口的类的实例
         */
        return Proxy.newProxyInstance(o.getClass().getClassLoader()
                ,o.getClass().getInterfaces()
                ,logProxy);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        System.out.println(method.getName()+"-----");
        /*if("add".equals(method.getName())) {
            Logger.log("执行了添加用户操作");
        }*/
        //判断方法上有没有加注解
        if(method.isAnnotationPresent(Log.class)){
            //得到注解对象
            Log log = method.getAnnotation(Log.class);
            Logger.log(log.value());
        }
        Object result = method.invoke(target,args);
        return result;
    }
}