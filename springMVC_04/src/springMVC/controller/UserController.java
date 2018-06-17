package springMVC.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springMVC.moduel.User;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller("user")
@RequestMapping("/user")
public class UserController {

//    保存用户信息的map集合
    Map<String,Object> users = new HashMap<>();

    public UserController(){
        User user1 = new User(1,"xiaoming","小明","123");
        User user2 = new User(2,"xiaohong","小红","456");
        User user3 = new User(3,"xiaogang","小刚","8522");
        User user4 = new User(4,"xiaoqiang","小强","444");
        User user5 = new User(5,"xiaohua","小华","1112");

        users.put("xiaoming",user1);
        users.put("xiaohong",user2);
        users.put("xiaogang",user3);
        users.put("xiaoqiang",user4);
        users.put("xiaohua",user5);
    }

//    从这里进入用户列表界面
//    http://localhost:8080/user/userList
    @RequestMapping(value = "/userList")
    public String list(Model model){
        model.addAttribute("users",users);
        return "user/list";
    }


//    使用a标签跳转到这个控制器,请求方式为get
    @RequestMapping(value = "userAdd",method = RequestMethod.GET)
    public String add(){
        return "user/add";
    }

    //    单文件上传
////    添加数据完成后,使用post方式提交数据,跳转到这里处理
//    @RequestMapping(value = "userAdd",method = RequestMethod.POST)
//    public String add(User user,@RequestParam("photos") MultipartFile photos){
//        if(user != null){
//            System.out.println(photos.getContentType());
//            System.out.println(photos.getOriginalFilename());
//            System.out.println(photos.getSize());
////            存储文件
//            try {
//                File file = new File("D:\\tmp\\" + photos.getOriginalFilename());
//                FileOutputStream fos = new FileOutputStream(file);
//                FileCopyUtils.copy(photos.getInputStream(),fos);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            users.put(user.getUsername(),user);
//        }
//
//        return "redirect:/user/userList";
//    }

//    多文件上传
    //    添加数据完成后,使用post方式提交数据,跳转到这里处理
    @RequestMapping(value = "userAdd",method = RequestMethod.POST)
    public String add(User user,@RequestParam("photos") MultipartFile[] photos){
        if(user != null){
            for (int i = 0; i < photos.length ; i++) {
//                多文件上传的话注意判断非空
                if(photos[i].getSize() == 0) {
                    continue;
                }
                System.out.println(photos[i].getContentType());
                System.out.println(photos[i].getOriginalFilename());
                System.out.println(photos[i].getSize());
//            存储文件
                try {
                    File file = new File("D:\\tmp\\" + photos[i].getOriginalFilename());
                    FileOutputStream fos = new FileOutputStream(file);
                    FileCopyUtils.copy(photos[i].getInputStream(),fos);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            users.put(user.getUsername(),user);
        }

        return "redirect:/user/userList";
    }

    //    查看用户详情
    @RequestMapping(value = "/{username}",method = RequestMethod.GET)
    public String show(@PathVariable String username , Model model){
        User user = (User)users.get(username);
        model.addAttribute("user",user);
        return "user/show";
    }

//    查看用户详情
    @RequestMapping(value = "/{username}",method = RequestMethod.GET,params = "json")
    @ResponseBody
    public User show(@PathVariable String username){
        User user = (User)users.get(username);
        return user;
    }

//    修改用户信息(把要修改的值传递到修改页面去)
    @RequestMapping(value = "/{username}/update",method = RequestMethod.GET)
    public String update(@PathVariable String username,Model model){
        User user = (User)users.get(username);
        model.addAttribute("user",user);
        return "user/update";
    }

//    开始修改
    @RequestMapping(value = "{username}/update",method = RequestMethod.POST)
    public String update(User user){
        users.put(user.getUsername(),user);
        return "redirect:/user/userList";
    }

    @RequestMapping(value = "{username}/delete")
    public String delete(@PathVariable String username){
        users.remove(username);
        return "redirect:/user/userList";

    }
}
