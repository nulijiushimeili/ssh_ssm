package test;

import moduels.Emp;
import org.hibernate.Session;
import org.junit.Test;
import util.HibernateUtil;

public class TestLazy {

    @Test
    public void test01(){
        Session session = null;

        session = HibernateUtil.getSession();

        Emp emp = session.load(Emp.class , 2);
        System.out.println(emp.getEmpName());
    }

}
