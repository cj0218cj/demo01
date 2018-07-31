package cn.cj.app;

import cn.cj.model.Job;
import cn.cj.service.JobService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by cj on 2018/7/30.
 */
@Controller
public class JobController {
    @Resource
    private JobService jobService;
    @RequestMapping("/newRecruitment.do")
    public String newRecruitment(HttpSession session)throws Exception{
        List<Job> jobList=jobService.getAllJob();
        session.setAttribute("jobs",jobList);
        return "newRecruitment";
    }
}
