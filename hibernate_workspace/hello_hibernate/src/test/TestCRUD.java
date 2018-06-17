package test;

import com.ibeifeng.hibernate.moduels.User;
import org.hibernate.Session;
import org.junit.Test;
import util.HibernateUtil;

import java.util.List;

public class TestCRUD {
    @Test
    public void testAdd(){
        Session session = null;
        try{
            session = HibernateUtil.getSession();
            session.beginTransaction();
            User user = new User(0,"yase","123456","11236885412","sese","yes");
            session.save(user);
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            HibernateUtil.close(session);
        }

    }

    @Test
    public void testUpdate(){
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            User user = new User();
            user.setId(3);
            user.setName("pujing");
            session.update(user);

            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
        }finally {
            HibernateUtil.close(session);
        }
    }

    @Test
    public void testDel(){
        Session session = null;
        try{
            session = HibernateUtil.getSession();
            session.beginTransaction();
            User user = new User();
            user.setId(1);
            session.delete(user);
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            HibernateUtil.close(session);
        }
    }

    @Test
    public void testLoad(){
        Session session = null;
        try{
            session = HibernateUtil.getSession();
            User user = session.get(User.class,5);
            System.out.println(user);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            HibernateUtil.close(session);
        }
    }

    @Test
    public void testList(){
        Session session = null ;
        try{
            session = HibernateUtil.getSession();
            List<User> users = session.createQuery("from User").list();
            for (User user : users
                 ) {
                System.out.println(user);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            HibernateUtil.close(session);
        }
    }

}
