package cn.cj.model;

import java.io.Serializable;

/**
 * Created by cj on 2018/7/31.
 */
public class Employee implements Serializable{
    private int e_id;
    private User user;
    private String e_name;
    private String e_pass;
    private int e_phone;
    private Dept dept;
    private Job job;
    private int e_state;
    private int e_salary;
//    state=0 新入职实习     state=1 正式员工    state=2 离职

    public Employee() {
    }

    public Employee(String e_name, String e_pass, int e_phone, int e_state, int e_salary) {
        this.e_name = e_name;
        this.e_pass = e_pass;
        this.e_phone = e_phone;
        this.e_state = e_state;
        this.e_salary = e_salary;
    }

    public Employee(User user, String e_name, String e_pass, int e_phone, Dept dept, Job job, int e_state, int e_salary) {
        this.user = user;
        this.e_name = e_name;
        this.e_pass = e_pass;
        this.e_phone = e_phone;
        this.dept = dept;
        this.job = job;
        this.e_state = e_state;
        this.e_salary = e_salary;
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public String getE_pass() {
        return e_pass;
    }

    public void setE_pass(String e_pass) {
        this.e_pass = e_pass;
    }

    public int getE_phone() {
        return e_phone;
    }

    public void setE_phone(int e_phone) {
        this.e_phone = e_phone;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public int getE_state() {
        return e_state;
    }

    public void setE_state(int e_state) {
        this.e_state = e_state;
    }

    public int getE_salary() {
        return e_salary;
    }

    public void setE_salary(int e_salary) {
        this.e_salary = e_salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "e_id=" + e_id +
                ", user=" + user +
                ", e_name='" + e_name + '\'' +
                ", e_pass='" + e_pass + '\'' +
                ", e_phone=" + e_phone +
                ", dept=" + dept +
                ", job=" + job +
                ", e_state=" + e_state +
                ", e_salary=" + e_salary +
                '}';
    }
}
