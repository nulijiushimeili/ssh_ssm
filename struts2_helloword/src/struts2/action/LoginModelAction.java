package struts2.action;

import com.opensymphony.xwork2.ModelDriven;
import struts2.moduel.User;

public class LoginModelAction implements ModelDriven<User> {

    private User user;

    public String login(){
        if("root".equals(user.getUsername()) && "123".equals(user.getPassword())){
            return "success";
        }else{
            return "failed";
        }
    }

    @Override
    public User getModel() {
        if(user == null){
            user = new User();
        }
        return user;
    }
}
