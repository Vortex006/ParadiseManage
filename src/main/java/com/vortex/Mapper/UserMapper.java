package com.vortex.Mapper;

import com.vortex.Entity.UserDo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    //查询所有用户
    List<UserDo> listUsers();

    //分页查询所有用户
    List<UserDo> limitUsers(@Param("offset") int offset, @Param("pageSize") int pageSize);

    //根据用户ID查询用户
    UserDo getUserById(int userId);

    //根据用户名查询用户
    UserDo getUserByName(String userName);

    //添加用户
    int saveUser(UserDo userDo);

    //根据用户ID删除用户
    int deleteUserById(int userId);

    //根据用户ID更新用户信息
    int updateUser(UserDo userDo);

    //获取用户数量
    int countUser();

}
