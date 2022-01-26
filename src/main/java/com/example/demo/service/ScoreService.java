package com.example.demo.service;

import com.example.demo.entity.Score;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author niu
 * @Description:
 * @date 2021/5/2421:23
 */
public interface ScoreService {

    //获取排行榜的全部数据
    List<Score> getAllData();
    //初始化用户排行榜
    void initScore(User user);
    List<Score> getFirstFiveUser();
    int saveScoreByUserId(String userId,int count);

}
