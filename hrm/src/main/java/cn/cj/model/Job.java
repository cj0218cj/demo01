package cn.cj.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by cj on 2018/7/25.
 * ְλ
 */
public class Job implements Serializable{
private int j_id;
private Dept dept;
private String j_name;
private int j_basePay;
private List<Recruitment> recruitments;

    public Job() {
    }

    public Job(Dept dept, String j_name, int j_basePay) {
        this.dept = dept;
        this.j_name = j_name;
        this.j_basePay = j_basePay;
    }

    public int getJ_id() {
        return j_id;
    }

    public void setJ_id(int j_id) {
        this.j_id = j_id;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public String getJ_name() {
        return j_name;
    }

    public void setJ_name(String j_name) {
        this.j_name = j_name;
    }

    public int getJ_basePay() {
        return j_basePay;
    }

    public void setJ_basePay(int j_basePay) {
        this.j_basePay = j_basePay;
    }

    public List<Recruitment> getRecruitments() {
        return recruitments;
    }

    public void setRecruitments(List<Recruitment> recruitments) {
        this.recruitments = recruitments;
    }

    @Override
    public String toString() {
        return "Job{" +
                "j_id=" + j_id +
                ", dept=" + dept +
                ", j_name='" + j_name + '\'' +
                ", j_basePay=" + j_basePay +
                '}';
    }
}
