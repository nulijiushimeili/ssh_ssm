package test;

import moduels.Dept;
import moduels.Emp;
import org.hibernate.Session;
import org.junit.Test;
import util.HibernateUtil;

import java.util.Iterator;
import java.util.List;


public class TestCache {

    @Test
    public void testAdd(){

        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();

            Emp emp1 = new Emp("1001","小王");
            Emp emp2 = new Emp("1002","项斌");

            Dept dept1 = new Dept();
            dept1.setDeptNo("02");
            dept1.setDeptName("消防队");

            Dept dept2 = new Dept();
            dept2.setDeptNo("01");
            dept2.setDeptName("救援队");

            session.save(dept1);
            session.save(dept2);

            emp1.setDept(dept1);
            emp2.setDept(dept2);

            session.save(emp1);
            session.save(emp2);

            session.getTransaction().commit();
        }catch(Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            HibernateUtil.close(session);
        }

    }

    @Test
    public void testList(){

        Session session = null;
        session = HibernateUtil.getSession();
        String hql = "from Emp";
        List<Emp> list = session.createQuery(hql).list();
        for (Emp e : list             ) {
            System.out.println(e.getEmpName());
        }
    }

    @Test
    public void testIterator(){
        Session session = HibernateUtil .getSession();
        Iterator<Emp> es = session.createQuery("from Emp").iterate();
        while(es.hasNext()){
            Emp e = es.next();
            System.out.println(e.getEmpName());
        }

    }
}
