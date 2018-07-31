package cn.cj.dao;

import cn.cj.model.Recruitment;

import java.util.List;

/**
 * Created by cj on 2018/7/25.
 */
public interface RecruitmentMapper {
    List<Recruitment> getRecruitmentByState(int state);
    List<Recruitment> getCurrentPageRecruitmentByState(int state,int begin,int end);
    Recruitment getRecruitmentById(int rt_id);
    int updateRecruitment(Recruitment recruitment);
    int addRecruitment(Recruitment recruitment);
    int deleteRecruitment(Recruitment recruitment);
}
