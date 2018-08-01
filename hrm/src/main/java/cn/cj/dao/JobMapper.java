package cn.cj.dao;

import cn.cj.model.Job;

import java.util.List;

/**
 * Created by cj on 2018/7/30.
 */
public interface JobMapper {
    List<Job> getAllJob();
    Job getJobById(int j_id);
    List<Job> getJobByDept(int d_id);
    List<Job> getCurrentPageJobByDept(int d_id,int begin,int end);
    int addJob(Job job);
    int deleteJob(Job job);
    int updateJob(Job job);
    int deleteJobByDept(int d_id);
}
