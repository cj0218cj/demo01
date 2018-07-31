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
}
