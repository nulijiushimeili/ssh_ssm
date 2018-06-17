package mybatis.test;

import mybatis.moduel.User;
import mybatis.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MybatisUtilTest {

    @Test
    public void testAdd(){
        SqlSession session = MybatisUtil.getSession();
        User user = new User("洪气功","789789");
        session.insert(User.class.getName() + ".add" ,user);
        session.commit();
        MybatisUtil.closeSqlSession(session);

    }


    @Test
    public void testUpdate(){
        SqlSession session = MybatisUtil.getSession();
        User user = new User("葫芦娃","12345");
        user.setId(3);
        session.update(User.class.getName() + ".update" ,user);
        session.commit();
        MybatisUtil.closeSqlSession(session);
    }

    @Test
    public void testDelete(){
        SqlSession session = MybatisUtil.getSession();
        session.delete(User.class.getName() + ".delete" ,3);
        session.commit();
        MybatisUtil.closeSqlSession(session);
    }
}
