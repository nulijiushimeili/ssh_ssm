package test;

import com.ibeifeng.hibernate.moduels.User;
import org.hibernate.Session;
import org.junit.Test;
import util.HibernateUtil;

/**
 * hiberbate get & load  的区别
 */
public class TestLoadAndGet {

    @Test
    public void testGet(){
        Session session = null;
        try{
            session = HibernateUtil.getSession();
            User user = session.get(User.class,6);
            System.out.println(user);
        }catch (Exception e){
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
            User user = session.load(User.class,6);
            System.out.println(user);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            HibernateUtil.close(session);
        }
    }
}
