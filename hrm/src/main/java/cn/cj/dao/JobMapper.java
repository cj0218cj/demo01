package cn.cj.dao;

import cn.cj.model.Job;

import java.util.List;

/**
 * Created by cj on 2018/7/30.
 */
public interface JobMapper {
    List<Job> getAllJob();
    Job getJobById(int j_id);
}
