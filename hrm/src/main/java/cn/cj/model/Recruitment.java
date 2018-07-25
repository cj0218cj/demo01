package cn.cj.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by cj on 2018/7/25.
 * ÕĞÆ¸ĞÅÏ¢
 */
public class Recruitment implements Serializable{
    private int rt_id;
    private Job job;
    private int rt_number;
    private String rt_message;
    private String rt_workingAddress;
    private String rt_requirements;
    private Date rt_time;
    private int rt_state;

    public Recruitment() {
    }

    public Recruitment(Job job, int rt_number, String rt_message, String rt_workingAddress, String rt_requirements, int rt_state) {
        this.job = job;
        this.rt_number = rt_number;
        this.rt_message = rt_message;
        this.rt_workingAddress = rt_workingAddress;
        this.rt_requirements = rt_requirements;
        this.rt_state = rt_state;
    }

    public Recruitment(Job job, int rt_number, String rt_message, String rt_workingAddress, String rt_requirements, Date rt_time, int rt_state) {
        this.job = job;
        this.rt_number = rt_number;
        this.rt_message = rt_message;
        this.rt_workingAddress = rt_workingAddress;
        this.rt_requirements = rt_requirements;
        this.rt_time = rt_time;
        this.rt_state = rt_state;
    }

    public int getRt_id() {
        return rt_id;
    }

    public void setRt_id(int rt_id) {
        this.rt_id = rt_id;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public int getRt_number() {
        return rt_number;
    }

    public void setRt_number(int rt_number) {
        this.rt_number = rt_number;
    }

    public String getRt_message() {
        return rt_message;
    }

    public void setRt_message(String rt_message) {
        this.rt_message = rt_message;
    }

    public String getRt_workingAddress() {
        return rt_workingAddress;
    }

    public void setRt_workingAddress(String rt_workingAddress) {
        this.rt_workingAddress = rt_workingAddress;
    }

    public String getRt_requirements() {
        return rt_requirements;
    }

    public void setRt_requirements(String rt_requirements) {
        this.rt_requirements = rt_requirements;
    }

    public Date getRt_time() {
        return rt_time;
    }

    public void setRt_time(Date rt_time) {
        this.rt_time = rt_time;
    }

    public int getRt_state() {
        return rt_state;
    }

    public void setRt_state(int rt_state) {
        this.rt_state = rt_state;
    }

    @Override
    public String toString() {
        return "Recruitment{" +
                "rt_id=" + rt_id +
                ", job=" + job +
                ", rt_number=" + rt_number +
                ", rt_message='" + rt_message + '\'' +
                ", rt_workingAddress='" + rt_workingAddress + '\'' +
                ", rt_requirements='" + rt_requirements + '\'' +
                ", rt_time=" + rt_time +
                ", rt_state=" + rt_state +
                '}';
    }
}
