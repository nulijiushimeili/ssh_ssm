package test;

import org.hibernate.Session;
import org.junit.Test;
import util.HibernateUtil;

import javax.persistence.Table;

public class TestAnnotation {

    @Test
    public void test01(){
        Session session = null;

        try{
            session = HibernateUtil.getSession();
            session.beginTransaction();

            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            //HibernateUtil.close(session);
        }
    }
}
