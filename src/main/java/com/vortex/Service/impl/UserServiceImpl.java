package com.vortex.Service.impl;

import com.vortex.Entity.User;
import com.vortex.Mapper.UserMapper;
import com.vortex.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    public List<User> getUsers() {
        List<User> users = userMapper.getUsers();
        return users;
    }

    @Override
    public List<User> getUsersLimit(int offset, int pageSize) {
        List<User> usersLimit = userMapper.getUsersLimit(offset, pageSize);
        return usersLimit;
    }

    @Override
    public User getUserForUserId(int userId) {
        User user = userMapper.getUserForUserId(userId);
        return user;
    }

    @Override
    public User getUserForUserName(String userName) {
        User user = userMapper.getUserForUserName(userName);
        return user;
    }

    @Override
    public boolean addUser(User user) {
        int x = userMapper.addUser(user);
        return x > 0;
    }

    @Override
    public boolean deleteUserForUserId(int userId) {
        int x = userMapper.deleteUserForUserId(userId);
        return x > 0;
    }

    @Override
    public boolean updateUser(User user) {
        int x = userMapper.updateUser(user);
        return x > 0;
    }

    @Override
    public int getUserCount() {
        int userCount = userMapper.getUserCount();
        return userCount;
    }
}
