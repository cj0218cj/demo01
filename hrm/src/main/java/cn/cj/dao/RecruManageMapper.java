package cn.cj.dao;

import cn.cj.model.RecruManage;
import cn.cj.model.User;

import java.util.List;

/**
 * Created by cj on 2018/7/29.
 */
public interface RecruManageMapper {
    int addRecruManage(RecruManage recruManage);
    int updateRecruManage(RecruManage recruManage);
    int deleteRecruManage(int rm_id);
    List<RecruManage> getRecruManageByRid(int state);
    List<RecruManage> getRecruManageByUser(RecruManage recruManage);
    RecruManage getRecruManageById(int rm_id);
}
