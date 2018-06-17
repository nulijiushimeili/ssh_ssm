package util;
/**
 * hibernate util
 * get session
 */

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private static SessionFactory factory = null ;
    static{
        //注册标准服务
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        //创建SessionFactory
        factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    //获取Session
    public static Session getSession(){
        return factory.openSession();
    }

    //销毁Session
    public static void close(Session session){
        if(session != null) session.close();
    }
}

















