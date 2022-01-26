package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.anno.UserLoginToken;
import com.example.demo.entity.User;
import com.example.demo.result.Result;
import com.example.demo.result.ResultCodeEnum;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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

    @PostMapping("/getMessage")
    @UserLoginToken
    public Result getMessage(){
        try {
            return Result.success().message("通过验证");
        }catch (Exception e){
            return Result.error().message(e.getMessage());
        }

    }

    @PostMapping("/login")
    @CrossOrigin(value = "http://localhost:5000",maxAge = 1800,allowedHeaders = "*")
    public Result login( User user){
        if (userService.login(user)){
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("userId", user.getUserId());
            dataMap.put("userName", user.getUserName());
            //生成token并存入数据返回
            String token  = user.getToken();
//            String token = jwtUtils.createJwt(user.getUserId(), user.getUserName(), dataMap);
            return Result.success(ResultCodeEnum.SUCCESS_LOGIN).message(token);
        }else{
            return Result.error(ResultCodeEnum.ERROR_LOGIN);
        }
    }

    @PostMapping("/getUserName")
    @CrossOrigin(value = "http://localhost:5000",maxAge = 1800,allowedHeaders = "*")
    public Result getUserName(@RequestBody JSONObject js){

        String userId = (String) js.get("userId");
        System.out.println(userId);

        String userName = userService.getUserNameByUserId(userId);
        System.out.println(userName);
        return Result.success().message(userName);
    }


    @PostMapping("/getAllUser")
    public Result getAllUser(){

        try {
            List<User> users = userService.getAllUser();
            Map m = new HashMap();
            m.put("list",users);
            return Result.success().data(m);
        }catch (Exception e){
            e.printStackTrace();
            return Result.error().message(e.getMessage());
        }

    }

    @PostMapping("/frush")
    public Result frush(){

        try {
            userService.frush();
            return Result.success().message("清除缓存");
        }catch (Exception e){
            e.printStackTrace();
            return Result.error().message(e.getMessage());
        }

    }



}
