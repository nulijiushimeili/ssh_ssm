package mybatis.test;

import mybatis.mapper.UserMapper;
import mybatis.moduel.Blog;
import mybatis.moduel.User;
import mybatis.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MybatisMapperTest {

    @Test
    public void testLoad(){
        SqlSession session = MybatisUtil.getSession();
        User user = session.getMapper(UserMapper.class).load(5);
        System.out.println(user);
    }

    @Test
    public void testAdd(){
        SqlSession session = MybatisUtil.getSession();
        User user = new User("和珅","48752");
        session.getMapper(UserMapper.class).add(user);
        session.commit();
        session.close();
    }




}
