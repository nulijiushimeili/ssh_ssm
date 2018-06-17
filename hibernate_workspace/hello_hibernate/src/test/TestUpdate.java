package test;

import com.ibeifeng.hibernate.moduels.User;
import org.hibernate.Session;
import org.junit.Test;
import util.HibernateUtil;

public class TestUpdate {

    @Test
    public void testUpdate(){
        Session session = null;
        try{
            session = HibernateUtil.getSession();
            session.beginTransaction();
            User user = new User();
            user.setId(2);
            user.setName("lihei");
            session.update(user);
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            HibernateUtil.close(session);
        }
    }

    @Test
    public void testSaveOrUpdate(){
        Session session = null;
        try{
            session = HibernateUtil.getSession();
            session.beginTransaction();
            User user = new User();
            //user.setId(8);
            user.setName("luban7hao");
            session.saveOrUpdate(user);
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            HibernateUtil.close(session);
        }
    }
}
