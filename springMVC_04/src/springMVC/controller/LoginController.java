package springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springMVC.exception.LoginException;

import javax.servlet.http.HttpSession;

@Controller("login")
public class LoginController {

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){

        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(String username,String password,HttpSession session){
        if("admin".equals(username) && "123".equals(password)){
            //            保存用户
            session.setAttribute("curUser",username);
            return "redirect:/user/userList";
        }else{
            throw new LoginException("用户名或密码不正确!!!");
        }


    }

//    @ExceptionHandler(LoginException.class)
//    public String execptionHandler(LoginException lex, Model model){
//        model.addAttribute("msg",lex.getMessage());
//        return "error";
//    }
}
