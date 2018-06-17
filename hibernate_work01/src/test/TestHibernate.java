package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Test;

public class TestHibernate {
//    @Test
//    public void testJunit(){
//        System.out.println("test junit");
//    }

    // the function testTable() build table in database
    @Test
    public void testTable(){
        SessionFactory sessionFactory = null;
        Session session = null;
        // registory  standard service
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try{
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();

            session.getTransaction().commit();
        }catch(Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }finally{
            StandardServiceRegistryBuilder.destroy(registry);
            if(session != null)session.close();
        }
    }
}
