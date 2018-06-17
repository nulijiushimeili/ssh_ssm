package struts2.ognl;

import ognl.Ognl;
import ognl.OgnlException;
import org.junit.Test;
import struts2.moduel.Group;
import struts2.moduel.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OgnlTest {
    @Test
    public void test01(){
        User user = new User(1,"admin","nulijiushimeili","123");
        try {

            System.out.println(Ognl.getValue("nickname",user));
        } catch (OgnlException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test02(){
        Group group = new Group(1,"java");
        User user = new User(1,"admin","nulijiushimeili","123");
        user.setGroup(group);
        try {

            System.out.println(Ognl.getValue("group.name",user));
        } catch (OgnlException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test03(){
        Group group = new Group(1,"java");
        User user = new User(1,"admin","nulijiushimeili","123");
        user.setGroup(group);
        try {
            Map context = new HashMap();
            context.put("u",user);
            context.put("g",group);


//            根是user
            System.out.println(Ognl.getValue("nickname",context,user));
//            根是context
            System.out.println(Ognl.getValue("u.nickname",context,context));
        } catch (OgnlException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test04() throws OgnlException {
        Group group1 = new Group(1,"java");
        Group group2 = new Group(2,"php");
        Group group3 = new Group(3,"python");

        List<Group> list = new ArrayList<Group>();
        list.add(group1);
        list.add(group2);
        list.add(group3);

        Group group = (Group) Ognl.getValue("#root[1]",list);
        System.out.println(group.getName());

        System.out.println(Ognl.getValue("#root.size()",list));

    }
}
