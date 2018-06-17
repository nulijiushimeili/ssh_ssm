package mybatis.test;

import mybatis.moduel.User;
import mybatis.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TestRead {

//    单条记录查询
    @Test
    public void testLoad(){
        SqlSession session = MybatisUtil.getSession();
        User user = session.selectOne(User.class.getName() + ".load",5);
        System.out.println(user);
    }

//    多条记录查询
    @Test
    public void testList(){
        SqlSession session = MybatisUtil.getSession();
        List<User> users = session.selectList(User.class.getName() + ".list");
        for (User u : users             ) {
            System.out.println(u);
        }
    }


//    分页查询
    @Test
    public void testPage(){
        SqlSession session = MybatisUtil.getSession();
        Map<String,Object> params = new HashMap<>();
        params.put("pageOffset",0);
        params.put("pageSize",3);
        List<User> users = session.selectList(User.class.getName()+".page",params);
        for (User u : users             ) {
            System.out.println(u);
        }

    }

//    带参查询
    @Test
    public void testParam(){
        SqlSession session = MybatisUtil.getSession();
        Map<String ,Object> params = new HashMap<>();
        params.put("name","%洪%");
        List<User> users = session.selectList(User.class.getName() + ".param",params);
        for (User u : users) {
            System.out.println(u);
        }
    }

    //排序
    @Test
    public void testOrder(){
        SqlSession session = MybatisUtil.getSession();
        Map<String , Object > params = new HashMap<>();
        params.put("name","name");
        params.put("sort","desc");
        List<User> users = session.selectList(User.class.getName() + ".order" ,params);
        for (User u : users) {
            System.out.println(u);
        }

    }

}
