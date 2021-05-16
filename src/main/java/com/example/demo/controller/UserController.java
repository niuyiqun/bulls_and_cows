package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.result.Result;
import com.example.demo.result.ResultCodeEnum;
import com.example.demo.service.UserService;
import com.example.demo.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author niu
 * @Description:
 * @date 2021/5/514:15
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/register")
    @CrossOrigin(value = "http://localhost:5000",maxAge = 1800,allowedHeaders = "*")
    public Result register(@RequestBody User user){

        System.out.println(user);

        assert user != null;
        user.setPlayCount(0);

        try {
            if (userService.register(user)>0)
                return Result.success(ResultCodeEnum.SUCCESS_REGISTER);
            else
                return Result.error(ResultCodeEnum.UNKNOW_REASON);
        }catch (Exception e){
            return Result.error(ResultCodeEnum.UNKNOW_REASON).message(e.getMessage());
        }
    }

    @PostMapping("/login")
    @CrossOrigin(value = "http://localhost:5000",maxAge = 1800,allowedHeaders = "*")
    public Result login(@RequestBody User user){
        if (userService.login(user)){
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("userId", user.getUserId());
            dataMap.put("userName", user.getUserName());
            //生成token并存入数据返回
            String token = jwtUtils.createJwt(user.getUserId(), user.getUserName(), dataMap);
            return Result.success(ResultCodeEnum.SUCCESS_LOGIN).message(token);
        }else{
            return Result.error(ResultCodeEnum.ERROR_LOGIN);
        }
    }



}
