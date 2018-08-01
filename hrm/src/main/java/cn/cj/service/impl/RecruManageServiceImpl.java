package cn.cj.service.impl;

import cn.cj.dao.RecruManageMapper;
import cn.cj.model.RecruManage;
import cn.cj.model.User;
import cn.cj.service.RecruManageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cj on 2018/7/29.
 */
@Service
public class RecruManageServiceImpl implements RecruManageService {
    @Resource
    private RecruManageMapper recruManageMapper;
    public int addRecruManage(RecruManage recruManage) {
        return recruManageMapper.addRecruManage(recruManage);
    }

    public int updateRecruManage(RecruManage recruManage) {
        return recruManageMapper.updateRecruManage(recruManage);
    }

    public int deleteRecruManage(int rm_id) {
        return recruManageMapper.deleteRecruManage(rm_id);
    }

    public List<RecruManage> getRecruManageByRid(int r_id) {
        return recruManageMapper.getRecruManageByRid(r_id);
    }

    public List<RecruManage> getRecruManageByUser(RecruManage recruManage) {
        return recruManageMapper.getRecruManageByUser(recruManage);
    }

    public RecruManage getRecruManageById(int rm_id) {
        return recruManageMapper.getRecruManageById(rm_id);
    }

    public List<RecruManage> getRecruManageByState(int state) {
        return recruManageMapper.getRecruManageByState(state);
    }

    public List<RecruManage> getCurrentPageRecruManageByState(int state, int begin, int end) {
        return recruManageMapper.getCurrentPageRecruManageByState(state,begin,end);
    }

    public List<RecruManage> getRecruManageByUserState(User user, int state) {
        return recruManageMapper.getRecruManageByUserState(user.getU_id(),state);
    }

    public List<RecruManage> getCurrentPageRecruManageByUserState(int state, int begin, int end, User user) {
        return recruManageMapper.getCurrentPageRecruManageByUserState(state,begin,end,user.getU_id());
    }
}
