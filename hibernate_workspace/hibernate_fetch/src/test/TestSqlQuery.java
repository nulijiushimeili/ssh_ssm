package test;

import org.hibernate.Session;
import org.junit.Test;
import util.HibernateUtil;

import java.util.HashMap;

public class TestSqlQuery {

    @Test
    public void test01(){
        Session session = null;
        try{
            session = HibernateUtil.getSession();
            String sql = "";
            //过时了.不推荐使用

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            HibernateUtil.close(session);
        }
    }
}
