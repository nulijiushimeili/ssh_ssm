package test;

import com.ibeifeng.hibernate.moduels.User;
import org.hibernate.Session;
import org.junit.Test;
import util.HibernateUtil;

public class TestLoad {

    /**
     * 在输出结果之前没有打印SQL语句
     * load()查询结果后,会将id缓存,然后从缓存中获取
     */
    @Test
    public void testLoad02(){
        Session session = null;
        try{
            session = HibernateUtil.getSession();
            User user = session.load(User.class,6);
            System.out.println(user.getId());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            HibernateUtil.close(session);
        }
    }
}
