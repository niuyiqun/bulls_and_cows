package com.example.demo.service;

import com.example.demo.entity.GameRecord;

import java.util.List;

/**
 * @author niu
 * @Description:
 * @date 2021/5/618:04
 */
public interface GameRecordService {

    //保存一次的记录
    public int saveGuessRecord(GameRecord gameRecord);
    public List<GameRecord> getRecordByplayCountAndUserId(String userId, int playCount);
    public int getCountInSingleGame(String userId,int playCount);

}
