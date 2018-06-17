package test;

import moduels.Emp;
import org.hibernate.Session;
import org.junit.Test;
import util.HibernateUtil;

import java.util.List;

public class TestFetch {

    @Test
    public void test01(){
        Session session = null;
        try{
            session = HibernateUtil.getSession();

            Emp emp = session.load(Emp.class , 2);

            System.out.println(emp.getEmpName());
            System.out.println(emp.getDept().getDeptName());
            //以上会发两条SQL,

            //<many-to-one name="dept" column="dept_id" fetch="join"/>
            //在many-to-one的属性中添加fetch="join",  进行优化 ,之后会只发一条SQL


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            HibernateUtil.close(session);
        }
    }

    //如果不适用load加载的话,.fetch = "join" 设置不设置都是无所谓的
    //该发多少条SQL还是发几条SQL
    @Test
    public void test02(){
        Session session = null;
        try{
            session = HibernateUtil.getSession();

            String hql = "from Emp";
            List<Emp> list = session.createQuery(hql).list();

            for (Emp e : list                 ) {
                System.out.println(e.getEmpName() + "----" + e.getDept().getDeptName());
            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            HibernateUtil.close(session);
        }
    }

    //自己写连接查询,提高查询的效率
    @Test
    public void test03(){
        Session session = null;
        try{
            session = HibernateUtil.getSession();
            String hql = "from Emp e join Dept d on e.dept.id = d.id";

//            List<Emp> list = session.createQuery(hql).list();
//
//            for ( Emp e : list                 ) {
//                System.out.println(e.getEmpName() + " " + e.getDept().getDeptName());
//            }
            //上面的代码会出现类型转换异常

            //返回类型是两个对象数组
            List<Object[]> os = session.createQuery(hql).list();

            for ( Object[] o : os                 ) {
                System.out.println(o[0] + " " + o[1]);
            }



        }catch (Exception e){
            e.printStackTrace();
        }finally {
            HibernateUtil.close(session);
        }
    }

    //
    @Test
    public void test04(){
        Session session = null;
        try{
            session = HibernateUtil.getSession();

            //这样写SQL,也是只发一条SQL就会查询出数据,
            String hql = "from Emp e join fetch e.dept";
            //可以用fetch一直连接下去,同样是只发一条SQL就能查出关联表的数据
            //String hql1 = "from Emp e join fetch e.dept d fetch d.company fetch ...";
            //返回的是Emp对象
            List<Emp> list = session.createQuery(hql).list();

            for ( Emp e : list                 ) {
                System.out.println(e.getEmpName() + " " + e.getDept().getDeptName());
            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            HibernateUtil.close(session);
        }
    }

}
