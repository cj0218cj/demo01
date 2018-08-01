package cn.cj.service;

import cn.cj.model.User;

/**
 * Created by cj on 2018/7/25.
 */
public interface UserService {
    User getUserByNameAndPass(User user);
    User getUserByName(User user);
    int addUser(User user);
    int updateUser(User user);
    User getUserById(int u_id);
}
