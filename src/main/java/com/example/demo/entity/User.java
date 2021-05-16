package com.example.demo.entity;

import lombok.Data;

/**
 * @author niu
 * @Description: 用户类
 * @date 2021/4/2920:02
 */


@Data
public class User {

    private String userId;    //作为用户的唯一标识
    private String userName;
    private String password;
    private int playCount;  //标注用户进行了多少次游戏

}
