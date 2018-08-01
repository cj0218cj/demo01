package cn.cj.app;

import cn.cj.model.Dept;
import cn.cj.model.Employee;
import cn.cj.model.Job;
import cn.cj.model.User;
import cn.cj.service.DeptService;
import cn.cj.service.EmployeeService;
import cn.cj.service.JobService;
import cn.cj.service.UserService;
import cn.cj.util.DoPage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cj on 2018/7/31.
 */
@Controller
public class EmployeeController {
    @Resource
    private EmployeeService employeeService;
    @Resource
    private UserService userService;
    @Resource
    private JobService jobService;
    @Resource
    private DeptService deptService;
    @RequestMapping("/addEmployee.do")
    public String addEmployee(Employee employee,String u_id,String d_id,String j_id)throws Exception{

        User user=userService.getUserById(Integer.parseInt(u_id));
        Job job=jobService.getJobById(Integer.parseInt(j_id));
        Dept dept=deptService.getDeptById(Integer.parseInt(d_id));
        employee.setUser(user);
        employee.setJob(job);
        employee.setDept(dept);
        employeeService.addEmployee(employee);
        return "manage";
    }
    @RequestMapping("/getEmployeeByDept.do")
    public String getEmployeeByDept(int d_id, int currentPage, Model model)throws Exception{

        List<Employee> list=employeeService.getEmployeeByDept(new Dept(d_id));
if (list.size()==0){
    model.addAttribute("error","该部门还没有员工，请先去添加");
    return "error";
}
        int totalRows=list.size();
        int totalPages= DoPage.getPages(totalRows);
        final int NUM=5;
        int begin=(currentPage-1)*NUM+1;
        int end=currentPage*NUM;
        List<Employee> list1=employeeService.getCurrentPageEmployeeByDept(d_id,begin,end);

        model.addAttribute("deptId",list.get(0).getDept().getD_id());
        model.addAttribute("employees",list1);
        model.addAttribute("totalPages",totalPages);
        model.addAttribute("page",currentPage);
        return "employees";
    }
    @RequestMapping("/getEmployeeByJob.do")
    public String getEmployeeByJob(int currentPage,int j_id,Model model)throws Exception {
        List<Employee> list = employeeService.getEmployeeByJob(new Job(j_id));
        if (list.size() != 0) {
            int totalRows = list.size();
            int totalPages = DoPage.getPages(totalRows);
            final int NUM = 5;
            int begin = (currentPage - 1) * NUM + 1;
            int end = currentPage * NUM;
            List<Employee> list1 = employeeService.getCurrentPageEmployeeByJob(j_id, begin, end);
            System.out.println(list1.get(0));
            model.addAttribute("jobId", list.get(0).getJob().getJ_id());
            model.addAttribute("employees", list1);
            model.addAttribute("totalPages", totalPages);
            model.addAttribute("page", currentPage);
            return "employees1";
        }
        model.addAttribute("error","该职位还没员工任职，请先去分配员工");
        return "error";
    }
}
