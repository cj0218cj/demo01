package cn.cj.service.impl;

import cn.cj.dao.ResumeMapper;
import cn.cj.model.Resumes;
import cn.cj.model.User;
import cn.cj.service.ResumeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cj on 2018/7/26.
 */
@Service
public class ResumeServiceImpl implements ResumeService {
    @Resource
    private ResumeMapper resumeMapper;
    public List<Resumes> getResumeMapperByUser(User user) {
        return resumeMapper.getResumeMapperByUser(user);
    }

    public int addResume(Resumes resume) {
        return resumeMapper.addResume(resume);
    }

    public int deleteResume(Resumes resume) {
        return resumeMapper.deleteResume(resume);
    }

    public int updateResume(Resumes resume) {
        return resumeMapper.updateResume(resume);
    }

    public Resumes getResumeById(int r_id) {
        return resumeMapper.getResumeById(r_id);
    }
}
