package test;

import moduels.Dept;
import moduels.Emp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Test;

public class testM2O {

    @Test
    public void generate_table(){
        SessionFactory sessionFactory = null;
        Session session = null;
        //注册标准服务
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try{
            //创建SessionFactory
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            //根据sessionFactory创建session
            session = sessionFactory.openSession();
            session.beginTransaction();
            Emp emp = new Emp("0001","马云");
            session.save(emp);
            session.getTransaction().commit();
        }catch(Exception e){
            session.getTransaction().rollback();
            //销毁标准服务
            StandardServiceRegistryBuilder.destroy(registry);
            e.printStackTrace();
        }finally{
            if(session != null)session.close();
        }

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

            Dept dept1 = new Dept("01","研发部");
            Dept dept2 = new Dept("02","测试部");
            session.save(dept1);
            session.save(dept2);

            Emp emp1 = new Emp("0001","马云");
            Emp emp2 = new Emp("0002","吴云");
            emp1.setDept(dept1);
            emp2.setDept(dept2);
            //保存用户
            session.save(emp1);
            session.save(emp2);
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
    public void testM2O01(){

    }


}
