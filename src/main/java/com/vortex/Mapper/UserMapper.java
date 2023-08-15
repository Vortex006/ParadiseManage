package com.vortex.Mapper;

import com.vortex.Entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    //查询所有用户
    List<User> getUsers();

    //分页查询所有用户
    List<User> getUsersLimit(@Param("offset") int offset, @Param("pageSize") int pageSize);

    //根据用户ID查询用户
    User getUserForUserId(int userId);

    //根据用户名查询用户
    User getUserForUserName(String userName);

    //添加用户
    int addUser(User user);

    //根据用户ID删除用户
    int deleteUserForUserId(int userId);

    //根据用户ID更新用户信息
    int updateUser(User user);

    //获取用户数量
    int getUserCount();

}
