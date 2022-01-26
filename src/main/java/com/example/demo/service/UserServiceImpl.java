package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.mapper.ScoreMapper;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author niu
 * @Description:
 * @date 2021/5/19:40
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    ScoreMapper scoreMapper;

    @Override
    public int register(User user) {
        scoreMapper.initScore(user);
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
        System.out.println("在UserServiceImpl中调用了方法gameBegin");
        return userMapper.gameBegin(userId);
    }

    @Override
    public String getUserNameByUserId(String userId) {
        return userMapper.getUserNameByUserId(userId);
    }

    @Override
    @Cacheable(value = "userCache",key = "'123'")
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public User findUserById(String userId) {
        return userMapper.findUserById(userId);
    }

    @CacheEvict(value = "userCache",key = "'user.getAllUser'")
    public void frush(){
        System.out.println("清除缓存");
    }
}
