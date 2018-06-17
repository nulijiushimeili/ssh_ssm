package struts2.action;

import com.opensymphony.xwork2.Action;

public class StrutsAction implements Action {
    @Override
    public String execute() throws Exception {
        System.out.println(" hello struts2 . . . . ");
        return "success";
    }

//    public String execute(){
//        System.out.println(" hello struts2");
//        return "success";
//    }
}
