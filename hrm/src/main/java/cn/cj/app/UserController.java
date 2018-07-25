package cn.cj.app;

import cn.cj.model.Recruitment;
import cn.cj.model.User;
import cn.cj.service.RecruitmentService;
import cn.cj.service.UserService;
import cn.cj.util.DoPage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by cj on 2018/7/25.
 */
@Controller
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private RecruitmentService recruitmentService;
    @RequestMapping("/login.do")
    public String login(User user, HttpSession session, Model model)throws Exception{
        User user1=userService.getUserByNameAndPass(user);
        if (user1!=null){
            session.setAttribute("user",user1);
            int currentpage=1;
            return success(currentpage,session);
        }else{
            model.addAttribute("error","用户名或密码错误");
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
            model.addAttribute("error","用户已存在");
            return "register";
        }else{
            userService.addUser(user);
            return "../../index";
        }
    }
    @RequestMapping("/success.do")
    public String success(int currentPage,HttpSession session)throws Exception{
        List<Recruitment> list=recruitmentService.getRecruitmentByState(1);
        int totalRows=list.size();
        int totalPages= DoPage.getPages(totalRows);
        final int NUM=5;
        List<Recruitment> recruitments=recruitmentService.getCurrentPageRecruitmentByState(1,currentPage,NUM);
        System.out.println(recruitments.size());
        session.setAttribute("allRecuritment",recruitments);
        session.setAttribute("totalPages",totalPages);
        session.setAttribute("page",currentPage);
        return "success";
    }
}
