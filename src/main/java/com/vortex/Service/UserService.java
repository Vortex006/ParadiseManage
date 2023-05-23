package com.vortex.Service;

import com.vortex.Entity.User;

import java.util.List;

public interface UserService {
    //查询所有用户
    List<User> getUsers(int offset, int pagesize);

    //根据用户id查询用户
    User getUserForId(int userid);

    //根据用户姓名查询用户
    User getUserForUsername(String username);

    //注册用户
    boolean addUser(User user);

    //根据用户id删除用户
    boolean deleteUser(int userid);

    //根据用户id更新用户
    boolean updateUserForId(User user);

    //获取用户总数
    int getUserCount();

}
