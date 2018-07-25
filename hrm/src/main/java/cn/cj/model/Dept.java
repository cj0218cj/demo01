package cn.cj.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by cj on 2018/7/25.
 * ≤ø√≈
 */
public class Dept implements Serializable{
    private int d_id;
    private String d_name;
    private Date d_date;
    private List<Job> jobs;

    public Dept() {
    }

    public Dept(String d_name) {
        this.d_name = d_name;
    }

    public Dept(String d_name, Date d_date, List<Job> jobs) {
        this.d_name = d_name;
        this.d_date = d_date;
        this.jobs = jobs;
    }

    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    public Date getD_date() {
        return d_date;
    }

    public void setD_date(Date d_date) {
        this.d_date = d_date;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "d_id=" + d_id +
                ", d_name='" + d_name + '\'' +
                ", d_date=" + d_date +
                '}';
    }
}
