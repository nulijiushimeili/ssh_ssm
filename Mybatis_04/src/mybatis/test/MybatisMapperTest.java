package mybatis.test;

import mybatis.mapper.UserMapper;
import mybatis.moduel.Blog;
import mybatis.moduel.User;
import mybatis.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        User user = new User("明珠","48752");
        session.getMapper(UserMapper.class).add(user);
        session.commit();
        session.close();
    }

    @Test
    public void testBlogAdd(){
        SqlSession session = MybatisUtil.getSession();
        Blog blog = new Blog("富春山居图","打打杀杀");
        User user = session.getMapper(UserMapper.class).load(5);
        blog.setUser(user);
        session.insert(Blog.class.getName() + ".add",blog);
        session.commit();
        session.close();
    }


//    在没有添加对象属性与表的属性的映射的情况下,若两者不一致,会取不到属性,
    @Test
    public void testBlogList(){
        SqlSession session = MybatisUtil.getSession();
        List<Blog> list = session.selectList(Blog.class.getName() + ".list");
        for (Blog b : list             ) {
            System.out.println(b);
//            Blog{id=1, title='null', content='小偷的世界', user=null}
        }

    }

//    添加对象属性映射和表中字段的映射后,得到结果集
    @Test
    public void testBlogList02(){
        SqlSession session = MybatisUtil.getSession();
        List<Blog> list = session.selectList(Blog.class.getName() + ".blogList");
        for(Blog b : list){
            System.out.println(b);
        }
    }

    @Test
    public void testUserList(){
        SqlSession session = MybatisUtil.getSession();
        List<User> users = session.selectList(User.class.getName()+".list");
        for (User u : users) {
            System.out.println(u);
        }
    }

    @Test
    public void testUserList02(){
        SqlSession session = MybatisUtil.getSession();
        List<User> users = session.selectList(User.class.getName()+".userList");
        for (User u : users) {
            System.out.println(u);
        }
    }

    @Test
    public void testBlogIf(){
        SqlSession session = MybatisUtil.getSession();
        Map<String,Object> params = new HashMap<>();
        //params.put("title"," ");
        params.put("content","小%");
        List<Blog> blogs = session.selectList(Blog.class.getName()+".blogIf",params);
        for (Blog blog : blogs             ) {
            System.out.println(blog);
        }
    }

//    使用foreach批量修改数据
    @Test
    public void testBatchUpdate(){
        SqlSession session = MybatisUtil.getSession();
        int[] params = {8,9,10};
        session.update(User.class.getName()+".batchUpdate",params);
        session.commit();
        session.close();

    }
}
