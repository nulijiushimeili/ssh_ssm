package mybatis.test;

import mybatis.moduel.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {

//    插入数据
    @Test
    public void testAdd(){
        try {
            //        1.创建mybatis配置文件输入流
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            // 2. 创建SqlSessionFactory
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            // 3 . 获取SqlSession
            SqlSession session = factory.openSession();
            //4.进行保存操作
            User user = new User("宋小宝宝","123");
            session.insert("mybatis.moduel.User.add",user);
            //5. 提交事物
            session.commit();
            //6. 关闭session
            session.close();



        } catch (IOException e) {
            e.printStackTrace();
        }

    }

//    更新数据
    @Test
    public void testUpdate(){
        try {
//            1.创建mybatis配置文件输入流
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
//            2.创建SqlSessionFactory
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
//            3.获取SqlSession
            SqlSession session = factory.openSession();
//            4.更新数据
            User user = new User("奥巴马","456");
            user.setId(1);
            session.update("mybatis.moduel.User.update",user);
//            5.提交事物
            session.commit();
//            6.关闭session
            session.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    删除数据

    @Test
    public void testDelete() throws IOException {
//        1.创建mybatis配置文件输入流
          InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//        2.创建SqlSessionFactory
           SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
//          3.获取SqlSession
           SqlSession session = factory.openSession();
//        4.delete datas
          User user = new User();
          user.setId(2);
          session.delete(User.class.getName() + ".delete",user);
//        5.commit datas
            session.commit();
//         6.close session
        session.close();


    }
}
