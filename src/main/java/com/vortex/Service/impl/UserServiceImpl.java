package com.vortex.Service.impl;

import com.vortex.Entity.UserDo;
import com.vortex.Mapper.UserMapper;
import com.vortex.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public List<UserDo> listUsers() {
        List<UserDo> userList = userMapper.listUsers();
        return userList;
    }

    @Override
    public List<UserDo> limitUsers(int offset, int pageSize) {
        List<UserDo> userLimitList = userMapper.limitUsers(offset, pageSize);
        return userLimitList;
    }

    @Override
    public UserDo getUserById(int userId) {
        UserDo user = userMapper.getUserById(userId);
        return user;
    }

    @Override
    public UserDo getUserByName(String userName) {
        UserDo user = userMapper.getUserByName(userName);
        return user;
    }

    @Override
    public boolean saveUser(UserDo userDo) {
        int i = userMapper.saveUser(userDo);
        return i > 0;
    }

    @Override
    public boolean deleteUserById(int userId) {
        int i = userMapper.deleteUserById(userId);
        return i > 0;
    }

    @Override
    public boolean updateUser(UserDo userDo) {
        int i = userMapper.updateUser(userDo);
        return i > 0;
    }

    @Override
    public int countUser() {
        int userCount = userMapper.countUser();
        return userCount;
    }
}
