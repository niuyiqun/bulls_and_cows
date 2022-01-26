package com.example.demo.service;

import com.example.demo.entity.Score;
import com.example.demo.entity.User;
import com.example.demo.mapper.ScoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author niu
 * @Description:
 * @date 2021/5/2421:24
 */


@Service
public class ScoreServiceImpl implements ScoreService{

    @Autowired
    ScoreMapper scoreMapper;

    @Override
    public List<Score> getAllData() {
        return scoreMapper.getAllData();
    }

    @Override
    public void initScore(User user) {
        scoreMapper.initScore(user);
    }



    @Override
    public List<Score> getFirstFiveUser() {
        return scoreMapper.getFirstFiveUser();
    }

    @Override
    public int saveScoreByUserId(String userId, int count) {
        int score;
        if (count<=5)
            score=100;
        else
            score=100-(count-5)*10;
        if (score<0)
            score=0;
        System.out.println("用户"+userId+"结束游戏，得分为"+score);
        scoreMapper.updateScoreByUserId(score,userId);
        return score;

    }
}
