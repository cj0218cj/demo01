package cn.cj.service.impl;

import cn.cj.dao.JobMapper;
import cn.cj.model.Job;
import cn.cj.service.JobService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cj on 2018/7/30.
 */
@Service
public class JobServiceImpl implements JobService{
    @Resource
    private JobMapper jobMapper;
    public List<Job> getAllJob() {
        return jobMapper.getAllJob();
    }

    public Job getJobById(int j_id) {
        return jobMapper.getJobById(j_id);
    }

    public List<Job> getJobByDept(int d_id) {
        return jobMapper.getJobByDept(d_id);
    }

    public List<Job> getCurrentPageJobByDept(int d_id, int begin, int end) {
        return jobMapper.getCurrentPageJobByDept(d_id,begin,end);
    }

    public int addJob(Job job) {
        return jobMapper.addJob(job);
    }

    public int deleteJob(Job job) {
        return jobMapper.deleteJob(job);
    }

    public int updateJob(Job job) {
        return jobMapper.updateJob(job);
    }

    public int deleteJobByDept(int d_id) {
        return jobMapper.deleteJobByDept(d_id);
    }
}
