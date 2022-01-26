package com.example.demo.entity;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.Data;

import java.io.Serializable;

/**
 * @author niu
 * @Description: 用户类
 * @date 2021/4/2920:02
 */


@Data
public class User implements Serializable {

    private static final long serialVersionUID = -5636378004736592126L;

    private String userId;    //作为用户的唯一标识
    private String userName;
    private String password;
    private int playCount;  //标注用户进行了多少次游戏

    public String getToken() {
        String token="";
        token= JWT.create().withAudience(this.getUserId())
                .sign(Algorithm.HMAC256(this.getPassword()));
        return token;
    }
}
