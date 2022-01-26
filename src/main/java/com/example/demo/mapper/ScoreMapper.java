package com.example.demo.mapper;

import com.example.demo.entity.Score;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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
    @Insert("INSERT INTO score(userId,userName,score) VALUES(#{userId},#{userName},0)")
    void initScore(User user);

    //更新用户的分数
    @Update("UPDATE score SET score = score + #{score} WHERE userId = #{userId} ")
    int updateScoreByUserId(int score,String userId);

    //按照顺序拿到排行榜前五名
    @Select("SELECT userName,score,userId FROM `score`order by score DESC")
    List<Score> getFirstFiveUser();


}
