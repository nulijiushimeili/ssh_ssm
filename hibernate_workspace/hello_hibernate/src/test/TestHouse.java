package test;

import com.ibeifeng.hibernate.moduels.House;
import org.hibernate.Session;
import org.junit.Test;
import util.HibernateUtil;

import java.util.Date;

public class TestHouse {

    @Test
    public void test01(){
        Session session = HibernateUtil.getSession();
        try{
            session.beginTransaction();
            House house1 = new House("南天门","天界入口",20000,new Date(),99,"太白金星");
            session.save(house1);
            session.getTransaction().commit();


        }catch(Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            HibernateUtil.close(session);
        }
    }
}
