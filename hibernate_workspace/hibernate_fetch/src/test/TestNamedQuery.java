package test;

import moduels.Emp;
import org.hibernate.Session;
import org.junit.Test;
import util.HibernateUtil;



public class TestNamedQuery {

    //通过
    @Test
    public void test01(){
        Session session = null;
        try{
            session = HibernateUtil.getSession();

            Emp emp = session.createNamedQuery("findEmpById",Emp.class)
                    .setParameter("id", 2)
                    .uniqueResult();
            System.out.println(emp);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            HibernateUtil.close(session);
        }

    }

}
