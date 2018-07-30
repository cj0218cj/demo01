package cn.cj.service.impl;

import cn.cj.dao.ManagerMapper;
import cn.cj.model.Manager;
import cn.cj.service.ManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by cj on 2018/7/30.
 */
@Service
public class ManagerServiceImpl implements ManagerService{
    @Resource
    private ManagerMapper managerMapper;
    public Manager getManager(Manager manager) {
        return managerMapper.getManager(manager);
    }
}
