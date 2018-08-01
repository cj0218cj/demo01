package cn.cj.app;

import cn.cj.model.Dept;
import cn.cj.model.Employee;
import cn.cj.service.DeptService;
import cn.cj.service.EmployeeService;
import cn.cj.service.JobService;
import cn.cj.util.DoPage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by cj on 2018/7/31.
 */
@Controller
public class DeptController {
    @Resource
    private DeptService deptService;
    @Resource
    private EmployeeService employeeService;
    @Resource
    private JobService jobService;
    @RequestMapping("/addDept.do")
    public String addDept()throws Exception{
        return "addDept";
    }
    @RequestMapping("/deptManage.do")
    public String deptManage(int currentPage, Model model)throws Exception{
        List<Dept> list=deptService.getAllDept();
        int totalRows=list.size();
        int totalPages= DoPage.getPages(totalRows);
        final int NUM=5;
        int begin=(currentPage-1)*NUM+1;
        int end=currentPage*NUM;
        List<Dept> list1=deptService.getCurrentPageDepts(begin,end);
        model.addAttribute("depts",list1);
        model.addAttribute("totalPages",totalPages);
        model.addAttribute("page",currentPage);
        return "deptManage";
    }
    @RequestMapping("/deptAdd.do")
    public String deptAdd(String d_name,Model model)throws Exception{
        Dept dept=deptService.getDeptByName(d_name);
        if (dept==null){
            deptService.addDept(new Dept(d_name));
            return deptManage(1,model);
        }else{
            model.addAttribute("error","该部门已存在");
            return "addDept";
        }
    }
    @RequestMapping("/updateDept.do")
    public String updateDept(int d_id, HttpSession session)throws Exception{
        Dept dept=deptService.getDeptById(d_id);
        session.setAttribute("dept",dept);
        return "updateDept";
    }
    @RequestMapping("/deptUpdate.do")
    public String deptUpdate(String d_name,HttpSession session,Model model)throws Exception{
        Dept dept= (Dept) session.getAttribute("dept");
        Dept dept1=deptService.getDeptByName(d_name);
        if (dept1==null){
            dept.setD_name(d_name);
            deptService.updateDept(dept);
            return deptManage(1,model);
        }else {
            model.addAttribute("error","该部门已存在");
            return "updateDept";
        }
    }
    @RequestMapping("/deleteDept.do")
    public String deleteDept(int d_id,Model model)throws Exception{
        Dept dept=deptService.getDeptById(d_id);
        List<Employee> list=employeeService.getEmployeeByDept(dept);

        if (list.size()==0){
            deptService.deleteDept(dept);
            jobService.deleteJobByDept(d_id);
            return deptManage(1,model);
        }else{
            model.addAttribute("error","该部门存在在职员工，无法删除");
            return "error";
        }
    }
    @RequestMapping("/employeeManage.do")
    public String employeeManage(Model model)throws Exception{
        List<Dept> list=deptService.getAllDept();
        model.addAttribute("depts",list);
        return "employeeManage";
    }
}
