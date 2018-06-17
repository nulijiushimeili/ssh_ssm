package test;

import com.ibeifeng.hibernate.moduels.User;
import org.hibernate.Session;
import org.junit.Test;
import util.HibernateUtil;

public class TestStatus {

    @Test
    public void test01(){
        Session session = null;
        try{
            session = HibernateUtil.getSession();
            session.beginTransaction();

            //瞬时状态
            User user = new User();
            user.setName("xiaobushi");
            //持久状态
            session.save(user);
            session.getTransaction().commit();
        }catch(Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
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

            //此时处于持久状态,通过load() 得到的user 被session管理
            User user1 = session.load(User.class,4);
            User user = new User();
            user.setName("xiaobushi");
            //持久状态
            session.save(user);
            session.delete(user1);
            //delete后,处于游离状态
            session.getTransaction().commit();
        }catch(Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            HibernateUtil.close(session);
            //此时已不受session管理,处于离线状态
        }
    }

    @Test
    public void test03(){
        Session session = null;
        try{
            session = HibernateUtil.getSession();
            session.beginTransaction();
            User user = session.get(User.class,3);

            user.setName("kongkong");
            //只要事物提交l,了就会检测session和数据库的值,不相同的情况下会执行update语句
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }finally{
            HibernateUtil.close(session);
        }
    }

    @Test
    public void test04(){
        Session session = null;
        try{
            session = HibernateUtil.getSession();
            session.beginTransaction();
            User user = session.load(User.class,4);
            //此时的user是受session管理的,属于持久化状态
            //只要事物提交的时候,检测到当前的对象与session中的对象不一样的时候,就会发SQL语句
            user.setName("zhubajie");
            session.getTransaction().commit();
            //当session提交后会执行clear(),所以下面语句会报错
           // user.setName("huibaocuo");
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }finally{
            HibernateUtil.close(session);
        }
    }
}
