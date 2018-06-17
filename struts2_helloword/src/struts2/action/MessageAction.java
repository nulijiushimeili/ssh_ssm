package struts2.action;

import static com.opensymphony.xwork2.Action.SUCCESS;

public class MessageAction {
    public String add(){
        System.out.println("执行了新增操作");
        return SUCCESS;
    }
    public String del(){
        System.out.println("执行了删除操作");
        return SUCCESS;
    }
}
