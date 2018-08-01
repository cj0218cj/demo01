package cn.cj.dao;

import cn.cj.model.Dept;
import cn.cj.model.Employee;
import cn.cj.model.Job;

import java.util.List;

/**
 * Created by cj on 2018/7/31.
 */
public interface EmployeeMapper {
    int addEmployee(Employee employee);
    int updateEmployee(Employee employee);
    Employee getEmployeeById(int e_id);
    List<Employee> getEmployeeByJob(Job job);
    List<Employee> getEmployeeByDept(Dept dept);
    List<Employee> getCurrentPageEmployeeByJob(int j_id,int begin,int end);
    List<Employee> getCurrentPageEmployeeByDept(int d_id,int begin,int end);
}
