package com.vortex.Service.impl;

import com.vortex.Entity.User;
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
    public List<User> getUsers(int offset, int pagesize) {
        List<User> users = userMapper.getUsers(offset, pagesize);
        return users;
    }

    @Override
    public User getUserForId(int userid) {
        User user = userMapper.getUserForId(userid);
        return user;
    }

    @Override
    public User getUserForUsername(String username) {
        User user = userMapper.getUserForUsername(username);
        return user;
    }

    @Override
    public boolean addUser(User user) {
        int i = userMapper.addUser(user);
        return i > 0;
    }

    @Override
    public boolean deleteUser(int userid) {
        int i = userMapper.deleteUser(userid);
        return i > 0;
    }

    @Override
    public boolean updateUserForId(User user) {
        int i = userMapper.updateUserForId(user);
        return i > 0;
    }

    @Override
    public int getUserCount() {
        int i = userMapper.getUserCount();
        return i;
    }
}
