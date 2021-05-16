package com.example.demo.controller;

import com.example.demo.entity.GameRecord;
import com.example.demo.result.Result;
import com.example.demo.service.GameRecordService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author niu
 * @Description:
 * @date 2021/5/89:00
 */


@RestController
@RequestMapping("/gameRecord")
public class GameRecordController {

    @Autowired
    GameRecordService gameRecordService;

    @Autowired
    UserService userService;

    @PostMapping("/getRecordByplayCountAndUserId")
    public Result getRecordByplayCountAndUserId(String userId){
        int playCount = userService.getPlayCount(userId);
        List<GameRecord> gameRecordList= gameRecordService.getRecordByplayCountAndUserId(userId,playCount);
        Map m = new HashMap<>();
        m.put("list",gameRecordList);
        return Result.success().data(m);
    }
}
