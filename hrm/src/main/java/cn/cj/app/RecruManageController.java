package cn.cj.app;

import cn.cj.model.RecruManage;
import cn.cj.model.Recruitment;
import cn.cj.model.Resumes;
import cn.cj.model.User;
import cn.cj.service.RecruManageService;
import cn.cj.service.ResumeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by cj on 2018/7/29.
 */
@Controller
public class RecruManageController {
    @Resource
    private RecruManageService recruManageService;
    @Resource
    private ResumeService resumeService;
    @RequestMapping("/confirm.do")
    public String confirm(int r_id, HttpSession session)throws Exception{
        Resumes resume=resumeService.getResumeById(r_id);
        Recruitment recruitment= (Recruitment) session.getAttribute("ret");
        User user= (User) session.getAttribute("user");
        RecruManage recruManage=new RecruManage(recruitment,resume,user);
        recruManageService.addRecruManage(recruManage);
        return "success";
    }
    @RequestMapping("/getinvite.do")
    public String getInvite(HttpSession session)throws Exception{
        User user= (User) session.getAttribute("user");
        RecruManage recruManage=new RecruManage(1,user);
        List<RecruManage> recruManageList=recruManageService.getRecruManageByUser(recruManage);
        session.setAttribute("getRecru",recruManageList);
        System.out.println(recruManageList);
        return "getInvite";
    }
    @RequestMapping("/inviteDetails.do")
    public String inviteDetails(int rm_id, HttpSession session)throws Exception{
        RecruManage recruManage=recruManageService.getRecruManageById(rm_id);
        session.setAttribute("recruManage",recruManage);
        return "inviteDetails";
    }
    @RequestMapping("/inviteResult.do")
    public String inviteResult(int state,HttpSession session)throws Exception{
        RecruManage recruManage= (RecruManage) session.getAttribute("recruManage");
        recruManage.setState(state);
        recruManageService.updateRecruManage(recruManage);
        return "success";
    }
}
