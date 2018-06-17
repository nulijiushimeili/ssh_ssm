package test;

import moduels.Dept;
import moduels.Emp;
import org.hibernate.Session;
import org.junit.Test;
import util.HibernateUtil;

/**
 * 多对一关联
 */
public class TestM2O {

    @Test
    public void test01(){
        Session session = null;
        try{
            session = HibernateUtil.getSession();
            session.beginTransaction();

            Dept dept1 = new Dept("01","战士");
            session.save(dept1);
            Dept dept2 = new Dept("02","法师");
            session.save(dept2);

            Emp emp1 = new Emp("0001","亚瑟");
            emp1.setDept(dept1);
            session.save(emp1);
            Emp emp2 = new Emp("0002","曹操");
            emp2.setDept(dept1);
            session.save(emp2);
            Emp emp3 = new Emp("0003","安其拉");
            emp3.setDept(dept2);
            session.save(emp3);

            //保存五次,会发5次SQL语句

            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            if(session != null) session.getTransaction().rollback();
        }finally {
            HibernateUtil.close(session);
        }
    }

    @Test
    public void test02(){
        Session session = null;
        try{
            session = HibernateUtil.getSession();
            session.beginTransaction();

            Dept dept1 = new Dept("01","safe");
            session.save(dept1);
            Dept dept2 = new Dept("02","build");
            session.save(dept2);

            Emp emp1 = new Emp("0004","sunwukong");
            session.save(emp1);
            Emp emp2 = new Emp("0005","litangceng");
            session.save(emp2);
            Emp emp3 = new Emp("0006","liukongkong");
            session.save(emp3);

            //这样写的话会多发SQL语句   8 次
            emp1.setDept(dept2);
            emp3.setDept(dept2);
            emp2.setDept(dept2);

            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            if(session != null) session.getTransaction().rollback();
        }finally {
            HibernateUtil.close(session);
        }
    }



}
