package test;

import moduels.Emp;
import org.hibernate.Session;
import org.junit.Test;
import util.HibernateUtil;

//public class TestInsertData {
//
//    @Test
//
//    public void test01(){
//        Session session = null;
//        try{
//            session = HibernateUtil.getSession();
//            session.beginTransaction();
//
//            Emp emp1 = new Emp("亚瑟","上路");
//            Emp emp2 = new Emp("安其拉","中单");
//            Emp emp3 = new Emp("后裔","下路");
//
//            session.save(emp1);
//            session.save(emp2);
//            session.save(emp3);
//
//            session.getTransaction().commit();
//
//        }catch(Exception e){
//            session.getTransaction().rollback();
//            e.printStackTrace();
//        }finally{
//            if(session != null)session.close();
//        }
//    }
//}
