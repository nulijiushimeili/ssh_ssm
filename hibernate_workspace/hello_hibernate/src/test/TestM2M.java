package test;

import moduels.Admin;
import moduels.Role;
import org.hibernate.Session;
import org.junit.Test;
import util.HibernateUtil;

public class TestM2M {

    @Test
    public void test01(){

        Session session = null;

        try{
            session = HibernateUtil.getSession();
            session.beginTransaction();

            Admin admin1 = new Admin("小明");
            Admin admin2 = new Admin("小刚");
            Admin admin3 = new Admin("小红");

            Role role1 = new Role("孙斌");
            session.save(role1);
            Role role2 = new Role("荆轲");
            session.save(role2);

            admin1.addRoles(role1);
            admin2.addRoles(role1);
            admin3.addRoles(role2);
            admin1.addRoles(role2);

            session.save(admin1);
            session.save(admin2);
            session.save(admin3);



            session.getTransaction().commit();

        }catch(Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            HibernateUtil.close(session);
        }
    }

}
