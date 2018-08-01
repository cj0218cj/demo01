package cn.cj.app;

import cn.cj.model.Job;
import cn.cj.model.Recruitment;
import cn.cj.model.Resumes;
import cn.cj.model.User;
import cn.cj.service.JobService;
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
    @Resource
    private JobService jobService;
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
    @RequestMapping("/inviteManage.do")
    public String inviteManage(int currentPage,HttpSession session)throws Exception{
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
        return "inviteManage";
    }
    @RequestMapping("/getrealRecruitmentmessage.do")
    public String getrealRecruitmentmessage(int rt_id,HttpSession session)throws Exception{
        Recruitment recruitment=recruitmentService.getRecruitmentById(rt_id);
        session.setAttribute("ret",recruitment);
        return "inviteMessageManager";
    }
    @RequestMapping("/updateRecruitment.do")
    public String updateRecruitment(int rt_id,HttpSession session)throws Exception{
        Recruitment recruitment=recruitmentService.getRecruitmentById(rt_id);
        recruitment.setRt_state(0);
        recruitmentService.updateRecruitment(recruitment);
        return inviteManage(1,session);
    }
    @RequestMapping("/addRecruitment.do")
    public String addRecruitment(int j_id,Recruitment recruitment,HttpSession session)throws Exception{
        Job job=jobService.getJobById(j_id);
        recruitment.setJob(job);
        recruitmentService.addRecruitment(recruitment);
        session.setAttribute("recrui",recruitment);
        System.out.println(recruitment);
        return "yesOrNo";
    }
    @RequestMapping("/updateRecruitmentState.do")
    public String updateRecruitmentState(int state,HttpSession session)throws Exception{
        Recruitment recruitment= (Recruitment) session.getAttribute("recrui");
        recruitment.setRt_state(state);
        recruitmentService.updateRecruitment(recruitment);
        return inviteManage(1,session);
    }
    @RequestMapping("/deleteRecruitment.do")
    public String deleteRecruitment(int currentPage,HttpSession session)throws Exception{
        List<Recruitment> list=recruitmentService.getRecruitmentByState(0);
        int totalRows=list.size();
        int totalPages= DoPage.getPages(totalRows);
        final int NUM=5;
        int begin=(currentPage-1)*NUM+1;
        int end=currentPage*NUM;
        List<Recruitment> recruitments=recruitmentService.getCurrentPageRecruitmentByState(0,begin,end);
        System.out.println(recruitments.size());
        session.setAttribute("allRecuritmentde",recruitments);
        session.setAttribute("totalPages",totalPages);
        session.setAttribute("page",currentPage);
        return "deleteRecruitment";
    }
    @RequestMapping("/recruitmentDelete.do")
    public String recruitmentDelete(int rt_id,HttpSession session)throws Exception{
        recruitmentService.deleteRecruitment(new Recruitment(rt_id));
        return deleteRecruitment(1,session);
    }
    @RequestMapping("/updateState.do")
    public String updateState(int rt_id)throws Exception{
        Recruitment recruitment=recruitmentService.getRecruitmentById(rt_id);

        recruitment.setRt_state(1);
        recruitmentService.updateRecruitment(recruitment);
        return "manage";
    }
    @RequestMapping("/returnManage.do")
    public String returnManage()throws Exception{
        return "manage";
    }
    @RequestMapping("/updateInviteMessage.do")
    public String updateInviteMessage(int rt_id,Model model)throws Exception{
        Recruitment recruitment=recruitmentService.getRecruitmentById(rt_id);
        model.addAttribute("rtm",recruitment);
        return "updateInviteMessage";
    }
    @RequestMapping("/messageUpdate.do")
    public String messageUpdate(Recruitment recruitment,int j_id)throws Exception{
        Job job=jobService.getJobById(j_id);
        recruitment.setJob(job);
        recruitment.setRt_state(0);
        recruitmentService.updateRecruitment(recruitment);
        return "manage";
    }
}
