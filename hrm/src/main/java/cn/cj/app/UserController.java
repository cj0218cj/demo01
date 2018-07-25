package cn.cj.app;

import cn.cj.model.User;
import cn.cj.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by cj on 2018/7/25.
 */
@Controller
public class UserController {
    @Resource
    private UserService userService;
    @RequestMapping("/login.do")
    public String login(User user, HttpSession session, Model model)throws Exception{
        User user1=userService.getUserByNameAndPass(user);
        if (user1!=null){
            session.setAttribute("user",user1);
            return "success";
        }else{
            model.addAttribute("error","�û������������");
            return "../../index";
        }
    }
    @RequestMapping("/toregister.do")
    public String toRegister()throws Exception{
        return "register";
    }
    @RequestMapping("/back.do")
    public String back()throws Exception{
        return "../../index";
    }
    @RequestMapping("/register.do")
    public String register(User user,Model model)throws Exception{
        if (userService.getUserByName(user)!=null){
            model.addAttribute("error","�û��Ѵ���");
            return "register";
        }else{
            userService.addUser(user);
            return "../../index";
        }
    }
}
