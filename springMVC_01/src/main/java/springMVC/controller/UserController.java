package springMVC.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("user")
public class UserController {

    @RequestMapping(value = "/user_add")
    public String add(){
        System.out.println("添加了数据");
        return "add";
    }


    @RequestMapping(value = "/user_toAdd")
    public String toAdd(){
        System.out.println("进入了添加数据页面");
//        意味着:WEB-INF/page/add.jsp
        return "toAdd";
    }


}
