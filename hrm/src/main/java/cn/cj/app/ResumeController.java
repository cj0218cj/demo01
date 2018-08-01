package cn.cj.app;

import cn.cj.model.RecruManage;
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
 * Created by cj on 2018/7/26.
 */
@Controller
public class ResumeController {
    @Resource
    private ResumeService resumeService;

    @RequestMapping("/lookResume.do")
    public String lookResume(int r_id,HttpSession session)throws Exception{
        User user= (User) session.getAttribute("user");
        Resumes resume1=resumeService.getResumeById(r_id);
        if (resume1!=null){
            session.setAttribute("resume",resume1);
            return "resume";
        }else{
            return "addResume";
        }
    }
    @RequestMapping("/updateResume.do")
    public String updateResume()throws Exception{
        return "updateResume";
    }
    @RequestMapping("/resumeUpdate.do")
    public String resumeUpdate(Resumes resume, HttpSession session)throws Exception{
        Resumes resumes= (Resumes) session.getAttribute("resume");
        resume.setR_id(resumes.getR_id());
        User user= (User) session.getAttribute("user");
        resume.setR_user(user);
        resumeService.updateResume(resume);
        session.setAttribute("aa","update Success");
        return "updateResume";
    }
    @RequestMapping("/addResume.do")
    public String addResume()throws Exception{
        return "newResume";
    }
    @RequestMapping("/resumeAdd.do")
//    public String resumeAdd(String r_name,Integer r_age,String r_sex,String r_school,String r_major,Integer r_phone,
//            String r_workingYears,String r_workExperience,String r_introduce,HttpSession session)throws Exception{
//        User user= (User) session.getAttribute("user");
//        System.out.println(user);
//        Resumes resume=new Resumes();
//        resume.setUser(user);
//        resume.setR_name(r_name);
////        resume.setR_age(r_age);
//        resume.setR_sex(r_sex);
//        resume.setR_school(r_school);
//        resume.setR_major(r_major);
////        resume.setR_phone(r_phone);
//        resume.setR_workingYears(r_workingYears);
//        resume.setR_workExperience(r_workExperience);
//        resume.setR_introduce(r_introduce);
//        resumeService.addResume(resume);
//        session.setAttribute("bb","创建成功");
//        return "newResume";
//    }
    public String resumeAdd(Resumes resumes,HttpSession session)throws Exception{
        User user= (User) session.getAttribute("user");
        resumes.setR_user(user);
        resumeService.addResume(resumes);
        session.setAttribute("bb","success");
        return "newResume";
    }
    @RequestMapping("/lookResumes.do")
    public String lookResumes(HttpSession session)throws Exception{
        User user= (User) session.getAttribute("user");
        List<Resumes> resumesList=resumeService.getResumeMapperByUser(user);
        if (resumesList.size()!=0){
            session.setAttribute("resumesList",resumesList);
            return "resumesList";
        }else {
            return "addResume";
        }
    }
    @RequestMapping("/deleteResume.do")
    public String deleteResume(HttpSession session)throws Exception{
        Resumes resumes= (Resumes) session.getAttribute("resume");
        resumeService.deleteResume(resumes);
        return lookResumes(session);
    }

}
