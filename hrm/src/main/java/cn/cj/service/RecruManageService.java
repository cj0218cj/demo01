package cn.cj.service;

import cn.cj.model.RecruManage;
import cn.cj.model.User;

import java.util.List;

/**
 * Created by cj on 2018/7/29.
 */
public interface RecruManageService {
    int addRecruManage(RecruManage recruManage);
    int updateRecruManage(RecruManage recruManage);
    int deleteRecruManage(int rm_id);
    List<RecruManage> getRecruManageByRid(int r_id);
    List<RecruManage> getRecruManageByUser(RecruManage recruManage);
    RecruManage getRecruManageById(int rm_id);
    List<RecruManage> getRecruManageByState(int state);
    List<RecruManage> getCurrentPageRecruManageByState(int state,int begin,int end);
    List<RecruManage> getRecruManageByUserState(User user,int state);
    List<RecruManage> getCurrentPageRecruManageByUserState(int state,int begin,int end,User user);
}
