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
            model.addAttribute("error","用户名或密码不正确");
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
        int begin=(currentPage-1)*NUM+1;
        int end=currentPage*NUM;
        List<Recruitment> recruitments=recruitmentService.getCurrentPageRecruitmentByState(1,begin,end);
        System.out.println(recruitments.size());
        session.setAttribute("allRecuritment",recruitments);
        session.setAttribute("totalPages",totalPages);
        session.setAttribute("page",currentPage);
        return "success";
    }
    @RequestMapping("/personalmessage.do")
    public String personalmessage(HttpSession session)throws Exception{
        return "personermessage";
    }
    @RequestMapping("/returnback.do")
    public String returnback()throws Exception{
        return "success";
    }
    @RequestMapping("/updatePass.do")
    public String updatePass()throws Exception{
        return "updatePass";
    }
    @RequestMapping("/passUpdate.do")
    public String passUpdate(String old,String pass,HttpSession session,Model model)throws Exception{
        User user= (User) session.getAttribute("user");
        if (old.equals(user.getU_pass())){
            user.setU_pass(pass);
            userService.updateUser(user);
            return "../../index";
        }else{
            model.addAttribute("error","原密码不正确");
            return "updatePass";
        }
    }
}
