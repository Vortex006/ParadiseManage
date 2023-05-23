package com.vortex.Mapper;

import com.vortex.Entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    //查询所有用户
    List<User> getUsers(@Param("offset") int offset, @Param("pagesize") int pagesize);

    //根据用户id查询用户
    User getUserForId(int userid);

    //根据用户姓名查询用户
    User getUserForUsername(String username);

    //注册用户
    int addUser(User user);

    //根据用户id删除用户
    int deleteUser(int userid);

    //根据用户id更新用户
    int updateUserForId(User user);

    //获取用户总数
    int getUserCount();
}
