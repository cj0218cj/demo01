package cn.cj.app;

import cn.cj.model.Dept;
import cn.cj.model.Employee;
import cn.cj.model.Job;
import cn.cj.service.DeptService;
import cn.cj.service.EmployeeService;
import cn.cj.service.JobService;
import cn.cj.util.DoPage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by cj on 2018/7/30.
 */
@Controller
public class JobController {
    @Resource
    private JobService jobService;
    @Resource
    private EmployeeService employeeService;
    @RequestMapping("/newRecruitment.do")
    public String newRecruitment(HttpSession session)throws Exception{
        List<Job> jobList=jobService.getAllJob();
        session.setAttribute("jobs",jobList);
        return "newRecruitment";
    }
    @RequestMapping("/getJob.do")
    public String getJob(int d_id, int currentPage, Model model)throws Exception{
        List<Job> list=jobService.getJobByDept(d_id);
        if (list.size()==0){
            model.addAttribute("error","该部门还没有职位，请先创建");
            return "error";
        }else{
            int totalRows=list.size();
            int totalPages= DoPage.getPages(totalRows);
            final int NUM=5;
            int begin=(currentPage-1)*NUM+1;
            int end=currentPage*NUM;
            List<Job> list1=jobService.getCurrentPageJobByDept(d_id,begin,end);
            model.addAttribute("dept",list1.get(0).getDept());
            model.addAttribute("deptJobs",list1);
            model.addAttribute("totalPages",totalPages);
            model.addAttribute("page",currentPage);
            return "getJobs";
        }
    }
    @RequestMapping("/updateJob.do")
    public String updateJob(int d_id,int j_id,Model model)throws Exception{
        Job job=jobService.getJobById(j_id);
        model.addAttribute("job",job);
        return "updateJob";
    }
    @RequestMapping("/jobUpdate.do")
    public String jobUpdate(int j_id,int d_id,String j_name,int money,Model model)throws Exception{
//        List<Job> list=jobService.getJobByDept(d_id);
//        if (list.size()!=0){
//            for (int i = 0; i <list.size() ; i++) {
//                if (j_name.equals(list.get(i).getJ_name())){
//                    model.addAttribute("error","该部门已经存在该职位");
//                    return "error";
//                }
//            }
//        }
//        else{
            Job job=jobService.getJobById(j_id);
            job.setJ_name(j_name);
            job.setJ_basePay(money);
            jobService.updateJob(job);
            return getJob(d_id,1,model);
//        }
//        return getJob(d_id,1,model);
    }
    @RequestMapping("/addJob.do")
    public String addJob(int d_id, HttpServletRequest request)throws Exception{
        request.setAttribute("d_id",d_id);
        return "addJob";
    }
    @RequestMapping("/jobAdd.do")
    public String jobAdd(Job job,int d_id,Model model)throws Exception{
        List<Job> list=jobService.getJobByDept(d_id);
        if (list.size()!=0){
            for (int i=0;i<list.size();i++){
                if (job.getJ_name().equals(list.get(i).getJ_name())){
                    model.addAttribute("qq","该部门已存在该职位");
                    return "addJob";
                }
            }
        }
        Dept dept=new Dept(d_id);
        job.setDept(dept);
        jobService.addJob(job);
        return getJob(d_id,1,model);
    }
    @RequestMapping("/deleteJob.do")
    public String deleteJob(int d_id,int j_id,Model model)throws Exception{
        List<Employee> list=employeeService.getEmployeeByJob(new Job(j_id));
        if (list.size()==0){
            jobService.deleteJob(new Job(j_id));
            return getJob(d_id,1,model);
        }else{
            model.addAttribute("error","该职位存在在职员工，无法删除");
            return "error";
        }
    }

}
