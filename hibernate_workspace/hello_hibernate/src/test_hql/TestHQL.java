package test_hql;

import com.ibeifeng.hibernate.moduels.House;
import com.ibeifeng.hibernate.moduels.HouseDTO;
import com.ibeifeng.hibernate.moduels.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;
import util.HibernateUtil;

import java.util.Iterator;
import java.util.List;

public class TestHQL {

    @Test
    public void test01() throws Exception {
        Session session = null;
        try{
            session = HibernateUtil.getSession();
            String hql = "from User";
            Query query = session.createQuery(hql);

            List<User> list = query.list();
            for (User u: list
                 ) {
                System.out.println(u);
            }

        } finally {
            HibernateUtil.close(session);
        }
    }

    // use iterator form query table; it is not recomment(不推荐)
    //it will send sql too much
    @Test
    public void testIterator(){
        Session session = null;

        session = HibernateUtil.getSession();
        String hql = "from User";
        Query query = session.createQuery(hql);

        Iterator<User> its = query.iterate();

       while(its.hasNext()){
           System.out.println(its.next());
       }
    }

    //query with param
    //not recomment
    @Test
    public void testParam() {
        Session session = null;

        session = HibernateUtil.getSession();
        String hql = "from User where name = 'zhubajie'";
        Query query = session.createQuery(hql);
        List<User> users = query.list();
        for (User user : users
                ) {
            System.out.println(user);
        }
    }


    //set param
    @Test
    public void testParam02() {
        Session session = null;

        session = HibernateUtil.getSession();
        String hql = "from User where id = ?";
        Query query = session.createQuery(hql);
        List<User> users = query.setParameter(0,4).list();
        for (User user : users
                ) {
            System.out.println(user);
        }
    }

    //query many data  in
    //通过in关键字查询,不推荐
    @Test
    public void testIn(){
        Session session = null;
        session = HibernateUtil.getSession();
        String hql = "from User where id in (?,?,?)";
        Query query = session.createQuery(hql).setParameter(0,1).setParameter(1,3).setParameter(2,5);
        List<User> users = query.list();
        for (User u : users
             ) {
            System.out.println(u);
        }
    }

    //一般情况下,我们是这样写的
    @Test
    public void testIn01(){
        Session session = null;
        session = HibernateUtil.getSession();
        String hql = "from User where id in (?,?,?)";
        Query query = session.createQuery(hql).setParameterList("ids",new Integer[]{1,2,3});
        List<User> users = query.list();
        for (User u : users
                ) {
            System.out.println(u);
        }
    }

    //基于in关键字的查询
    @Test
    public void testIn02(){
        Session session = null;
        session = HibernateUtil.getSession();
        Integer[] ids = {1,3,5};
        String hql = "from User where id in (:ids)";
        Query query = session.createQuery(hql).setParameterList("ids",ids);
        List<User> users = query.list();
        for (User u : users
                ) {
            System.out.println(u);
        }
    }

    // 查找部分字段
    @Test
    public void testPartConl(){
        Session session = null;
        session = HibernateUtil.getSession();
        String hql = "select id,name from User";
        List<Object[]> list = session.createQuery(hql).list();
        for (Object[] os : list
             ) {
            System.out.println(os[0] + " : " + os[1]);
        }

    }

    //需要指定的构造函数必须预先存在
    @Test
    public void testPartConl02(){
        Session session = null;
        session = HibernateUtil.getSession();
        String hql = "select new User(id , name) from User";
        List<User> list = session.createQuery(hql).list();
        for (User u : list
             ) {
            System.out.println(u.getId() + " : " + u.getName());

        }

    }

    //uniqueResult()  唯一结果查询
    @Test
    public void testUnique(){
        Session session = null;
        session = HibernateUtil.getSession();
        String hql = "from User where id = ?" ;
        User user = (User)session.createQuery(hql).setParameter(0,6).uniqueResult();
        System.out.println(user);
    }

    //@testCount   查询记录的总数
    @Test
    public void testCount(){
        Session session = null;
        session = HibernateUtil.getSession();
        String hql = " select count(id) from User";
        long totle = (long)session.createQuery(hql).uniqueResult();
        System.out.println("记录总数为:" + totle);
    }

    //分页查询
    @Test
    public void testPage01(){
        Session session = null;
        session = HibernateUtil.getSession();
        String hql = "from User";
        List<User> list = session.createQuery(hql).setFirstResult(3).setMaxResults(3).list();
        for (User u : list) {
            System.out.println(u);
        }

    }

    //多表关联配置
    //导航查询(前奏)
    @Test
    public void testNav(){
        Session session = HibernateUtil.getSession();
        //不推荐这种SQL写法,会发很多SQL,效率不高
        String hql = "select h from House h ";
        List<House> list = session.createQuery(hql).list();
        for (House h : list    ) {
            System.out.println(h);
        }
    }

    //多表关联查询
    @Test
    public void testNav02(){
        Session session = null;
        session = HibernateUtil.getSession();
        String hql = "select h from House h where h.user.id = 6";
        List<House> list = session.createQuery(hql).list();
        for (House h : list             ) {
            System.out.println(h);
        }
    }

    //多表内连接查询
    @Test
    public void testJoin(){
        Session session = HibernateUtil.getSession();
        String hql = "select h.title,u.name from House h inner join User u on h.user.id = u.id";
        List<Object[]> list = session.createQuery(hql).list();
        for (Object[] o : list) {
            System.out.println(o[0] + " : " + o[1]);
        }
    }

    //左外链接查询
    @Test
    public void testLeft(){
        Session session = HibernateUtil.getSession();
        String hql = "select h.title,u.name from House h left join User u on h.user.id = u.id";
        List<Object[]> list = session.createQuery(hql).list();
        for (Object[] o : list) {
            System.out.println(o[0] + " : " + o[1]);
        }
    }

    //右外连接查询
    @Test
    public void testRight(){
        Session session = HibernateUtil.getSession();
        String hql = "select h.title,u.name from House h right join User u on h.user.id = u.id";
        List<Object[]> list = session.createQuery(hql).list();
        for (Object[] o : list) {
            System.out.println(o[0] + " : " + o[1]);
        }
    }

    //基于DTO查询
    //为了解决连接查询的效率问题,可以创建一个java dto 类
    //这样写可以提高查询效率
    //注意:用类全名, 显式使用 as

    @Test
    public void testDTO(){
        Session session = HibernateUtil.getSession();
        String hql = "select new com.ibeifeng.hibernate.moduels.HouseDTO(h.title as htitle ,u.name as uname) from House h right join User u on h.user.id = u.id";
        List<HouseDTO> list = session.createQuery(hql).list();
        for (HouseDTO h : list             ) {
            System.out.println(h.getName() + " : " + h.getTitle());
        }
    }

}
























