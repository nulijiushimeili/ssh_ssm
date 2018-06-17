package test;

import moduels.Content;
import moduels.Message;
import org.hibernate.Session;
import org.junit.Test;
import util.HibernateUtil;

public class TestO2M {

    //one to many 向表中插入数据
    @Test
    public void test01(){
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();

            Message message1 = new Message("美国恐怖袭击");
            Message message2 = new Message("印度洋海啸");

            Content content1 = new Content("911");
            session.save(content1);
            message1.getContents().add(content1);
            Content content2 = new Content("损失1000万美元");
            session.save(content2);
            message1.getContents().add(content2);
            Content content3 = new Content("叙利亚战争");
            session.save(content3);
            message1.getContents().add(content3);

            session.save(message1);
            session.save(message2);



            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally{
            HibernateUtil.close(session);
        }
    }



    //添加cascade : delete属性之后,会同时删除关联的记录
    @Test
    public void test02(){
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();

            //级联删除表中关联的记录
            Message msg = session.load(Message.class,2);
            session.delete(msg);

            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally{
            HibernateUtil.close(session);
        }
    }



    //添加cascade : save-update属性之后,会同时保存两张表的记录
    @Test
    public void test03(){
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();

            Message message1 = new Message("美国恐怖袭击");
            Message message2 = new Message("印度洋海啸");

            Content content1 = new Content("911");
            //session.save(content1);
            message1.getContents().add(content1);
            Content content2 = new Content("损失1000万美元");
            //session.save(content2);
            message1.getContents().add(content2);
            Content content3 = new Content("叙利亚战争");
            //session.save(content3);
            message1.getContents().add(content3);

            session.save(message1);
            session.save(message2);



            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally{
            HibernateUtil.close(session);
        }
    }


    @Test
    public void test04(){
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();

            Message message1 = new Message("美国恐怖袭击");
            Message message2 = new Message("印度洋海啸");

            Content content1 = new Content("911");
            session.save(content1);
            message1.getContents().add(content1);
            Content content2 = new Content("损失1000万美元");
            session.save(content2);
            message1.getContents().add(content2);
            Content content3 = new Content("叙利亚战争");
            session.save(content3);
            message1.getContents().add(content3);

            session.save(message1);
            session.save(message2);



            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally{
            HibernateUtil.close(session);
        }
    }
}
