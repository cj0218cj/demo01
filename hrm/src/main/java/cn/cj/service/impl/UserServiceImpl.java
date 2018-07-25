package cn.cj.service.impl;

import cn.cj.dao.UserMapper;
import cn.cj.model.User;
import cn.cj.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by cj on 2018/7/25.
 */
@Service
public class UserServiceImpl implements UserService{
    @Resource
    private UserMapper userMapper;
    public User getUserByNameAndPass(User user) {
        return userMapper.getUserByNameAndPass(user);
    }

    public User getUserByName(User user) {
        return userMapper.getUserByName(user);
    }

    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }
}
