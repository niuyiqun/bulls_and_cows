package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author niu
 * @Description: 用户的curd
 * @date 2021/5/19:10
 */

@Repository
@Mapper
public interface UserMapper {

    @Insert("INSERT INTO user(userId,userName,password,playCount) VALUES(#{userId},#{userName},#{password},1)")
    int register(User user);

    @Select("SELECT * FROM user where userId=#{userId}")
    User testLogin(String userId);

    @Select("SELECT playCount FROM user where userId=#{userId}")
    int getPlayCount(String userId);

    @Update("UPDATE user set playCount=playCount+1 where userId=#{userId}")   //让playCount数加一
    int gameBegin(String userId);


    @Select("SELECT userName FROM user WHERE userId = #{userId}")
    String getUserNameByUserId(String userId);

    @Select("SELECT * FROM user")
    List<User> getAllUser();

    @Select("SELECT * FROM user WHERE userId = #{userId}")
    User findUserById(String userId);

}
