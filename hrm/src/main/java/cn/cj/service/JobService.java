package cn.cj.service;

import cn.cj.model.Job;

import java.util.List;

/**
 * Created by cj on 2018/7/30.
 */
public interface JobService {
    List<Job> getAllJob();
    Job getJobById(int j_id);
}
