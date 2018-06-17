package test;

import com.ibeifeng.hibernate.moduels.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

public class HibernateTest {
    @Test
    public void test(){
        System.out.println("测试Junit");
    }
    @Test
    public void testBase(){
        SessionFactory sessionFactory = null;
        Session session = null;
        //注册标准服务
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try {
            //创建SessionFactory
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            //通过SessionFactory创建session
            session = sessionFactory.openSession();
            //开始事物
            session.beginTransaction();
            //创建User对象
            User user = new User(2,"Aobama","123456","12345678910","aoao","no");
            //保存用户
            session.save(user);
            //提交事物
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            //回滚事物
            session.getTransaction().rollback();
            //销毁标准服务
            StandardServiceRegistryBuilder.destroy(registry);
        }finally {
            //释放资源
            if(session != null ) session.close();
        }

    }

    @Test
    public void testBase_copy(){
        SessionFactory sessionFactory = null;
        Session session = null;
        // A SessionFactory is set up once for an application!
        //注册标准服务
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();// configures settings from hibernate.cfg.xml
        try {
            //创建SessionFactory
            sessionFactory = new MetadataSources(registry)
                    .buildMetadata().buildSessionFactory();
            //通过sessionFactory创建session
            session = sessionFactory.openSession();
            //开始事务
            session.beginTransaction();
            //创建User对象
            //User user = new User("老李","123","15900561234","li","N");
            //保存用户
            //session.save(user);
            //提交事务
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            //回滚事务
            session.getTransaction().rollback();
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy( registry );
        } finally{
            //释放资源
            if(session != null) session.close();
        }
    }

}
