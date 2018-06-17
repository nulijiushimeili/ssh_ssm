package struts2.action;

import com.opensymphony.xwork2.ActionContext;
import struts2.moduel.User;

public class LoginAction {



    private User user;

    public String login(){
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        if("admin".equals(user.getUsername()) && "123".equals(user.getPassword())){
            ActionContext.getContext().getSession().put("user",user);
            return "success";
        }else{
            return "failed";
        }
    }

    public User getUser(){
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
