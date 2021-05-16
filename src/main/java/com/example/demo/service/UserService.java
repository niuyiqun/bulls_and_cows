package com.example.demo.service;

import com.example.demo.entity.User;

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

}
