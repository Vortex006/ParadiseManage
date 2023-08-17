package com.vortex.Service;

import com.vortex.Entity.UserDo;

import java.util.List;

public interface UserService {

    //查询所有用户
    List<UserDo> listUsers();

    //分页查询所有用户
    List<UserDo> limitUsers(int offset, int pageSize);

    //根据用户ID查询用户
    UserDo getUserById(int userId);

    //根据用户名查询用户
    UserDo getUserByName(String userName);

    //添加用户
    boolean saveUser(UserDo userDo);

    //根据用户ID删除用户
    boolean deleteUserById(int userId);

    //根据用户ID更新用户信息
    boolean updateUser(UserDo userDo);

    //获取用户数量
    int countUser();

}
