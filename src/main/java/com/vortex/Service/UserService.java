package com.vortex.Service;

import com.vortex.Entity.User;

import java.util.List;

public interface UserService {
    //查询所有用户
    List<User> SelectUserAll(int offset, int pagesize);

    //根据用户id查询用户
    User SelectUserForId(int userid);

    //根据用户姓名查询用户
    User SelectUserForUsername(String username);

    //注册用户
    boolean AddUser(User user);

    //根据用户id删除用户
    boolean DeleteUser(int userid);

    //根据用户id更新用户
    boolean UpdateUserForId(User user);

    //
    int SelectUserCount();

}
