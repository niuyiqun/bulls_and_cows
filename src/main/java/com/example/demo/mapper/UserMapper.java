package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @author niu
 * @Description: 用户的curd
 * @date 2021/5/19:10
 */

@Repository
@Mapper
public interface UserMapper {

    @Insert("INSERT INTO user(userId,userName,password) VALUES(#{userId},#{userName},#{password})")
    int register(User user);

    @Select("SELECT * FROM user where userId=#{userId}")
    User testLogin(String userId);

    @Select("SELECT playCount FROM user where userId=#{userId}")
    int getPlayCount(String userId);

    @Update("UPDATE user set playCount=playCount+1 where userId=#{userId}")
    int gameBegin(String userId);

}
