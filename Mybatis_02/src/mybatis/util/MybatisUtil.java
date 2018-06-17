package mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {
    static SqlSessionFactory factory = null;
    //获取SqlSessionFactory
    static {
        try {
//            1.创建mybatis配置文件输入流
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
//            2.创建SqlSessionFactory
           factory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    获取SqlSession
    public static SqlSession getSession(){
        return factory.openSession();
    }
//    关闭SqlSession
    public static void closeSqlSession(SqlSession sqlSession){
        if(sqlSession != null){
            sqlSession.close();
        }
    }
}
