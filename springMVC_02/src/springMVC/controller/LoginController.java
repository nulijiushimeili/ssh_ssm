package springMVC.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springMVC.moduel.User;

import java.util.Map;

@Controller("login")
public class LoginController {

//    推荐使用
    @RequestMapping(value = "/login")
    public String login(String username, Model model){
        System.out.println(username);
//        如果model中存储的是String类型,在页面上直接用${string}就可以取到,但是用${username}是取不到的
        //model.addAttribute(username);
//        推荐使用的方法,在页面上用${username}的方法获取存入的值
        User user = new User(1,"毛晓彤","tongtong","123456");
        model.addAttribute("user",user);
        return "login";
    }
}
