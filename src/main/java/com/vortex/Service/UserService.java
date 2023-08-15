package com.vortex.Service;

import com.vortex.Entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    //查询所有用户
    List<User> getUsers();

    //分页查询所有用户
    List<User> getUsersLimit(@Param("offset") int offset, @Param("pageSize") int pageSize);

    //根据用户ID查询用户
    User getUserForUserId(int userId);

    //根据用户名查询用户
    User getUserForUserName(String userName);

    //添加用户
    boolean addUser(User user);

    //根据用户ID删除用户
    boolean deleteUserForUserId(int userId);

    //根据用户ID更新用户信息
    boolean updateUser(User user);

    //获取用户数量
    int getUserCount();

}
