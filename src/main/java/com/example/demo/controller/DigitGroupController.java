package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.DigitGroup;
import com.example.demo.entity.GameRecord;
import com.example.demo.entity.User;
import com.example.demo.result.Result;
import com.example.demo.result.ResultCodeEnum;
import com.example.demo.service.DigitGroupService;
import com.example.demo.service.GameRecordService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author niu
 * @Description:
 * @date 2021/5/515:19
 */


@RestController
@RequestMapping("/digitGroup")
public class DigitGroupController {

    @Autowired
    DigitGroupService digitGroupService;
    @Autowired
    DigitGroup digitGroup;   //configuration注册的bean
    @Autowired
    GameRecordService gameRecordService;
    @Autowired
    GameRecord gameRecord;  //configuration注册的bean
    @Autowired
    UserService userService;

    @RequestMapping("/Initbean")
    @CrossOrigin(value = "http://localhost:5000",maxAge = 1800,allowedHeaders = "*")
    public Result Initbean(@RequestBody String userId){
        System.out.println("用户" + userId + "开始了游戏" );
        digitGroupService.initDigitGroup();
        userService.gameBegin(userId);
//        System.out.println(digitGroup.getList());
        Map m = new HashMap<>();
        m.put("list",digitGroup.getList());
        System.out.println(digitGroup.getList());
        return Result.success().data(m);
    }

    @RequestMapping("/testGuess")
//    @ResponseBody
    @CrossOrigin(value = "http://localhost:5000",maxAge = 1800,allowedHeaders = "*")
//    public Result testGuess(@RequestParam(value = "list" ,required=false) List list,String userId){
    public Result testGuess(@RequestBody JSONObject js){
        List list = (List)js.get("list");
        String userId = (String) js.get("userId");
        System.out.println("参数为"+list);
//        JSON re =
        if (userId==null)
            System.out.println("没接收到参数");
        System.out.println("userId = "+ userId);
//        ReceiveLog receiveLog = JSON.parseObject(list,ReceiveLog.class);
        int right=0;
        int semiRight=0;
//        System.out.println(list);
        for (int i = 0;i<4;i++){
            if (list.get(i).equals(digitGroup.getList().get(i)))
                right++;
            for (int j=0;j<digitGroup.getList().size();j++){
                if (j==i)
                    continue;
                if (list.get(i).equals(digitGroup.getList().get(j)))
                    semiRight++;
            }
        }

        gameRecord.setRight(right);
        gameRecord.setSemiRight(semiRight);
        gameRecord.setUserId(userId);
        String dg="";
        for (Object integer : list) {
            dg = dg + integer + " ";
        }
        gameRecord.setDigitGroup(dg);
        gameRecord.setPlayCount(userService.getPlayCount(userId));
        gameRecordService.saveGuessRecord(gameRecord);   //将该次的猜测记录存储到数据库中
        Map map = new HashMap<>();
        map.put("right",right);
        map.put("semiRight",semiRight);
        System.out.println(Result.success().data(map));
        return Result.success().data(map);
    }

}
