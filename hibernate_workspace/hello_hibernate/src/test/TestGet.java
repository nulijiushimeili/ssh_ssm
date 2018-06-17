package test;

import com.ibeifeng.hibernate.moduels.User;
import org.hibernate.Session;
import org.junit.Test;
import util.HibernateUtil;

public class TestGet {

    /**
     * 在打印结果之前打印了SQL语句
     * get()方法没有缓存
     * 无论查找什么都会发SQL去数据库查找
     */
    @Test
    public void testGet02(){
        Session session = null;
        try{
            session = HibernateUtil.getSession();
            User user = session.get(User.class,6);
            System.out.println(user.getId());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            HibernateUtil.close(session);
        }
    }
}
