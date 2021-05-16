package com.example.demo.mapper;

import com.example.demo.entity.Score;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author niu
 * @Description:
 * @date 2021/4/2920:12
 */

@Repository
@Mapper
public interface ScoreMapper {

    //获取排行榜的全部数据
    @Select("SELECT * FROM score ")
    List<Score> getAllData();

    //初始化用户排行榜
    @Insert("INSERT INTO score(userId,score) VALUES(#{userId},0")
    int initScore(String userId);


}
