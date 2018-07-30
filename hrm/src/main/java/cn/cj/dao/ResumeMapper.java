package cn.cj.dao;

import cn.cj.model.Resumes;
import cn.cj.model.User;

import java.util.List;

/**
 * Created by cj on 2018/7/26.
 */
public interface ResumeMapper {
    List<Resumes> getResumeMapperByUser(User user);
    int addResume(Resumes resume);
    int deleteResume(Resumes resume);
    int updateResume(Resumes resume);
    Resumes getResumeById(int r_id);

}
