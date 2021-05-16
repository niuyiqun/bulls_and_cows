package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author niu
 * @Description:
 * @date 2021/5/19:40
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public int register(User user) {
        return userMapper.register(user);
    }

    @Override
    public boolean login(User user) {
        User u = userMapper.testLogin(user.getUserId());
        if (u==null)
            return false;
        return user.getPassword().equals(u.getPassword());
    }

    @Override
    public int getPlayCount(String userId) {
        return userMapper.getPlayCount(userId);
    }

    @Override
    public int gameBegin(String userId) {
        return userMapper.gameBegin(userId);
    }
}
