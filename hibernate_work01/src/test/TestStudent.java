package test;

import moduel.Student;
import org.hibernate.Session;
import org.junit.Test;
import util.HibernateUtil;

public class TestStudent {

    //insert
    @Test
    public void test01(){
        Session session = null;
        try{
            session = HibernateUtil.getSession();
            session.beginTransaction();
            Student student = new Student(1,"huamulan","woman",22);
            session.save(student);
            session.getTransaction().commit();
        }catch(Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }finally{
            HibernateUtil.close(session);
        }
    }

    @Test
    public void test02(){
        Session session = null;
        try{
            session = HibernateUtil.getSession();
            session.beginTransaction();
            Student student = new Student();
            student.setId(1);
            student.setName("xiaoqiao");
            session.saveOrUpdate(student);
            session.getTransaction().commit();
        }catch(Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }finally{
            HibernateUtil.close(session);
        }
    }

    @Test
    public void test03(){
        for (int i = 0; i < 10 ; i++) {
            test01();
        }
    }
}
