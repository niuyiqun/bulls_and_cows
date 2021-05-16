package com.example.demo.service;

import com.example.demo.entity.GameRecord;
import com.example.demo.mapper.GameRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author niu
 * @Description:
 * @date 2021/5/618:05
 */

@Service
public class GameRecordServiceImpl implements GameRecordService{

    @Autowired
    GameRecordMapper gameRecordMapper;

    @Override
    public int saveGuessRecord(GameRecord gameRecord) {    //保存一次的用户猜测记录，接收的参数为gameRecord对象
        return gameRecordMapper.saveGuessRecord(gameRecord);
    }

    @Override
    public List<GameRecord> getRecordByplayCountAndUserId(String userId, int playCount) {
        return gameRecordMapper.getRecordByplayCountAndUserId(userId, playCount);
    }

    @Override
    public int getCountInSingleGame(String userId, int playCount) {
        return gameRecordMapper.getCountInSingleGame(userId, playCount);
    }
}
