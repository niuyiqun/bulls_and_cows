package com.example.demo.mapper;

import com.example.demo.entity.GameRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author niu
 * @Description:
 * @date 2021/5/618:00
 */

@Repository
@Mapper
public interface GameRecordMapper {

    //将用户的猜测记录保存到数据表

    @Insert("INSERT INTO gameRecord VALUES(#{userId},#{playCount},#{digitGroup},#{right},#{semiRight})")
    int saveGuessRecord(GameRecord gameRecord);

    //根据用户和次数获取猜测记录
    @Select("SELECT * FROM gameRecord WHERE userId=#{userId} and playCount=#{playCount}")
    List <GameRecord> getRecordByplayCountAndUserId(String userId, int playCount);

    //获取单次游戏中的猜测次数，以便计算该用户本次游戏的总分
    @Select("SELECT count(*) FROM gameRecord WHERE userId=#{userId} and playCount=#{playCount}")
    int getCountInSingleGame(String userId,int playCount);


}
