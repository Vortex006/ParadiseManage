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

    public List<User> SelectUserAll(int offset, int pagesize) {
        List<User> users = userMapper.SelectUserAll(offset, pagesize);
        return users;
    }

    public User SelectUserForId(int userid) {
        User user = userMapper.SelectUserForId(userid);
        return user;
    }

    public User SelectUserForUsername(String username) {
        User user = userMapper.SelectUserForUsername(username);
        return user;
    }

    public boolean AddUser(User user) {
        int i = userMapper.AddUser(user);
        return i > 0;
    }

    public boolean DeleteUser(int userid) {
        int i = userMapper.DeleteUser(userid);
        return i > 0;
    }

    public boolean UpdateUserForId(User user) {
        int i = userMapper.UpdateUserForId(user);
        return i > 0;
    }

    public int SelectUserCount() {
        int i = userMapper.SelectUserCount();
        return i;
    }
}
