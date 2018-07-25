package cn.cj.service;

import cn.cj.model.Recruitment;

import java.util.List;

/**
 * Created by cj on 2018/7/25.
 */
public interface RecruitmentService {
    List<Recruitment> getRecruitmentByState(int state);
    List<Recruitment> getCurrentPageRecruitmentByState(int state,int begin,int end);
    Recruitment getRecruitmentById(int rt_id);
}
