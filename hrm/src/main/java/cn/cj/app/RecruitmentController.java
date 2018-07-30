package cn.cj.app;

import cn.cj.model.Recruitment;
import cn.cj.model.Resumes;
import cn.cj.model.User;
import cn.cj.service.RecruitmentService;
import cn.cj.service.ResumeService;
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
public class RecruitmentController {
    @Resource
    private RecruitmentService recruitmentService;
    @Resource
    private ResumeService resumeService;
    @RequestMapping("/getrealRecruitment.do")
    public String getrealRecruitment(int rt_id,HttpSession session)throws Exception{
        Recruitment recruitment=recruitmentService.getRecruitmentById(rt_id);
        session.setAttribute("ret",recruitment);
        return "details";
    }
    @RequestMapping("/applyJob.do")
    public String applyJob(HttpSession session)throws Exception{
        User user= (User) session.getAttribute("user");
    List<Resumes> resumesList=resumeService.getResumeMapperByUser(user);
    session.setAttribute("resumes",resumesList);
    return "chooseResume";
    }
}
