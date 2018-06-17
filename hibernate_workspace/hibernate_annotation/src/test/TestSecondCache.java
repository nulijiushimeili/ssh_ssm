package test;

import moduels.Emp;
import org.hibernate.Session;
import org.junit.Test;
import util.HibernateUtil;

public class TestSecondCache {

    @Test
    public void test01(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Emp emp = (Emp)session.get(Emp.class,2);
        System.out.println(emp);
        session.getTransaction().commit();
        session.close();

        Session session1 = HibernateUtil.getSession();
        session.beginTransaction();
        Emp emp1 = (Emp)session.get(Emp.class,2);
        System.out.println(emp1.getEmpName());

        Emp emp2 = (Emp)session.get(Emp.class,2);
        System.out.println(emp2);

        session1.getTransaction().commit();
        session1.close();

    }
}
