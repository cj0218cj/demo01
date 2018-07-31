package cn.cj.service.impl;

import cn.cj.dao.RecruitmentMapper;
import cn.cj.model.Recruitment;
import cn.cj.service.RecruitmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cj on 2018/7/25.
 */
@Service
public class RecruitmentServiceImpl implements RecruitmentService {
    @Resource
    private RecruitmentMapper recruitmentMapper;
    public List<Recruitment> getRecruitmentByState(int state) {
        return recruitmentMapper.getRecruitmentByState(state);
    }

    public List<Recruitment> getCurrentPageRecruitmentByState(int state, int begin, int end) {
        return recruitmentMapper.getCurrentPageRecruitmentByState(state,begin,end);
    }

    public Recruitment getRecruitmentById(int rt_id) {
        return recruitmentMapper.getRecruitmentById(rt_id);
    }

    public int updateRecruitment(Recruitment recruitment) {
        return recruitmentMapper.updateRecruitment(recruitment);
    }

    public int addRecruitment(Recruitment recruitment) {
        return recruitmentMapper.addRecruitment(recruitment);
    }

    public int deleteRecruitment(Recruitment recruitment) {
        return recruitmentMapper.deleteRecruitment(recruitment);
    }
}
