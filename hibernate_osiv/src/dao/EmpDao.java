package dao;

import moduels.Emp;
import org.hibernate.Session;
import util.HibernateUtil;

public class EmpDao {
    public Emp getEmpById(int id){
        Session session = null;
        try{
            session = HibernateUtil.getSession();
            return session.load(Emp.class,id);

        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
