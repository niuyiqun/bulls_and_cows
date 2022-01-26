package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Score;
import com.example.demo.result.Result;
import com.example.demo.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author niu
 * @Description:
 * @date 2021/5/2719:07
 */


@RestController
@RequestMapping("/score")
public class ScoreController {

    @Autowired
    ScoreService scoreService;

    @PostMapping("/getRank")
    @CrossOrigin(value = "http://localhost:5000",maxAge = 1800,allowedHeaders = "*")
    public Result getFirstFiveUser(){
        List<Score> list = scoreService.getFirstFiveUser();
        System.out.println(list);

        Map m = new HashMap<>();
        m.put("rank",list);

        return Result.success().data(m);
    }

    @PostMapping("success")
    @CrossOrigin(value = "http://localhost:5000",maxAge = 1800,allowedHeaders = "*")
    public Result success(@RequestBody JSONObject js){  //userId，count
        String userId = (String) js.get("userId");
        int count =(int)js.get("count");
        int score = scoreService.saveScoreByUserId(userId,count);
        Map m = new HashMap();
        m.put("score",score);
        return Result.success().message("游戏结算成功").data(m);
    }


}
