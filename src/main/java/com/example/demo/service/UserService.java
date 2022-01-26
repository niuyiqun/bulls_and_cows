package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

/**
 * @author niu
 * @Description:
 * @date 2021/5/19:34
 */

public interface UserService {

    public int register(User user);
    public boolean login(User user);
    public int getPlayCount(String userId);
    public int gameBegin(String userId);
    public String getUserNameByUserId(String userId);
    public List<User> getAllUser();
    public User findUserById(String userId);
    public void frush();

}
