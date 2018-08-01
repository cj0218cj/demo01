package cn.cj.app;

import cn.cj.model.*;
import cn.cj.service.JobService;
import cn.cj.service.RecruManageService;
import cn.cj.service.ResumeService;
import cn.cj.util.DoPage;
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
    @Resource
    private JobService jobService;
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
    @RequestMapping("/getResume.do")
    public String getResume(int currentPage,HttpSession model)throws Exception{
        model.removeAttribute("resume0");
        List<RecruManage> list=recruManageService.getRecruManageByState(0);
        int totalRows=list.size();
        int totalPages= 1;
        if (totalRows!=0){
            totalPages= DoPage.getPages(totalRows);
        }

        final int NUM=5;
        int begin=(currentPage-1)*NUM+1;
        int end=currentPage*NUM;
        List<RecruManage> list1=recruManageService.getCurrentPageRecruManageByState(0,begin,end);
        if (list1.size()!=0){
            model.setAttribute("resume0",list1);
            model.setAttribute("totalPages",totalPages);
            model.setAttribute("page",currentPage);
            return "resumes0";
        }else {
            model.setAttribute("qq","暂未收到新的简历");
            return "resumes0";
        }
    }
    @RequestMapping("/getResumes.do")
    public String getResumes(int currentPage,HttpSession model)throws Exception {
        model.removeAttribute("resume4");
        List<RecruManage> list = recruManageService.getRecruManageByState(4);
        int totalRows = list.size();
        int totalPages = DoPage.getPages(totalRows);
        final int NUM = 5;
        int begin = (currentPage - 1) * NUM + 1;
        int end = currentPage * NUM;
        List<RecruManage> list1 = recruManageService.getCurrentPageRecruManageByState(4, begin, end);
        if (list1.size() != 0) {
            model.setAttribute("resume4", list1);
            model.setAttribute("totalPages", totalPages);
            model.setAttribute("page", currentPage);
            return "resumes4";
        } else {
            model.setAttribute("qq", "暂未收到新的简历");
            return "resumes4";
        }
    }
    @RequestMapping("/lookResumeDetail.do")
    public String lookResumeDetail(int rm_id, Model model,HttpSession session)throws Exception{
        RecruManage recruManage=recruManageService.getRecruManageById(rm_id);
        recruManage.setState(4);
        int r_id=recruManage.getResumes().getR_id();
        Resumes resumes=resumeService.getResumeById(r_id);
        model.addAttribute("resu",resumes);
        session.setAttribute("re",recruManage);
        recruManageService.updateRecruManage(recruManage);
        return "resumeDetail";
    }
    @RequestMapping("/meettingOrder.do")
    public String meettingOrder(HttpSession session)throws Exception{
        RecruManage recruManage= (RecruManage) session.getAttribute("re");
        recruManage.setState(1);
        recruManageService.updateRecruManage(recruManage);
        return "manage";
    }
    @RequestMapping("/getOffer.do")
    public String getOffer(int currentPage,HttpSession model)throws Exception{
        User user= (User) model.getAttribute("user");
        List<RecruManage> list = recruManageService.getRecruManageByUserState(user,3);
        int totalRows = list.size();
        int totalPages = DoPage.getPages(totalRows);
        final int NUM = 5;
        int begin = (currentPage - 1) * NUM + 1;
        int end = currentPage * NUM;
        List<RecruManage> list1 = recruManageService.getCurrentPageRecruManageByUserState(3, begin, end,user);
        if (list1.size() != 0) {
            model.setAttribute("resume2", list1);
            model.setAttribute("totalPages", totalPages);
            model.setAttribute("page", currentPage);
            return "resumes2";
        } else {
            model.setAttribute("qq", "暂未收到新的offer");
            return "resumes2";
        }
    }
    @RequestMapping("/meetingResult.do")
    public String meetingResult(int currentPage,HttpSession session)throws Exception{
        List<RecruManage> list = recruManageService.getRecruManageByState(2);
        int totalRows = list.size();
        int totalPages = DoPage.getPages(totalRows);
        final int NUM = 5;
        int begin = (currentPage - 1) * NUM + 1;
        int end = currentPage * NUM;
        List<RecruManage> list1 = recruManageService.getCurrentPageRecruManageByState(2, begin, end);
        if (list1.size() != 0) {
            session.setAttribute("resume3", list1);
            session.setAttribute("totalPages", totalPages);
            session.setAttribute("page", currentPage);
            return "resumes3";
        } else {
            session.setAttribute("qq", "暂未收到新的简历");
            return "resumes3";
        }
    }
    @RequestMapping("/getemployee.do")
    public String getemployee(int rm_id,Model model)throws Exception{
        RecruManage recruManage=recruManageService.getRecruManageById(rm_id);
        int r_id=recruManage.getResumes().getR_id();
        int j_id=recruManage.getRecruitment().getJob().getJ_id();
        Resumes resumes=resumeService.getResumeById(r_id);

        Job job=jobService.getJobById(j_id);
        model.addAttribute("resume",resumes);
        model.addAttribute("job",job);
        recruManage.setState(3);
        recruManageService.updateRecruManage(recruManage);
        return "getEmployee";
    }

}
