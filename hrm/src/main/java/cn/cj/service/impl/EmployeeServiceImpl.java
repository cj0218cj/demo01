package cn.cj.service.impl;

import cn.cj.dao.EmployeeMapper;
import cn.cj.model.Dept;
import cn.cj.model.Employee;
import cn.cj.model.Job;
import cn.cj.service.EmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cj on 2018/7/31.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    private EmployeeMapper employeeMapper;
    public int addEmployee(Employee employee) {
        return employeeMapper.addEmployee(employee);
    }

    public int updateEmployee(Employee employee) {
        return employeeMapper.updateEmployee(employee);
    }

    public Employee getEmployeeById(int e_id) {
        return employeeMapper.getEmployeeById(e_id);
    }

    public List<Employee> getEmployeeByJob(Job job) {
        return employeeMapper.getEmployeeByJob(job);
    }

    public List<Employee> getEmployeeByDept(Dept dept) {
        return employeeMapper.getEmployeeByDept(dept);
    }

    public List<Employee> getCurrentPageEmployeeByJob(int j_id, int begin, int end) {
        return employeeMapper.getCurrentPageEmployeeByJob(j_id,begin,end);
    }

    public List<Employee> getCurrentPageEmployeeByDept(int d_id, int begin, int end) {
        return employeeMapper.getCurrentPageEmployeeByDept(d_id,begin,end);
    }
}
