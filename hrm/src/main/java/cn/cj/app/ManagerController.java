package cn.cj.app;

import cn.cj.model.Manager;
import cn.cj.service.ManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by cj on 2018/7/30.
 */
@Controller
public class ManagerController {
    @Resource
    private ManagerService managerService;
    @RequestMapping("/managerLogin.do")
    public String managerLogin()throws Exception{
        return "managerLogin";
    }
    @RequestMapping("/managerLoginin.do")
    public String managerLoginin(Manager manager, Model model)throws Exception{
        Manager manager1=managerService.getManager(manager);
        if (manager1!=null){
            return "manage";
        }else{
            model.addAttribute("error","用户名或密码不正确");
            return "managerLogin";
        }
    }
}
