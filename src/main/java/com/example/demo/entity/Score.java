package com.example.demo.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author niu
 * @Description: 用于记录用户的历史得分情况
 * @date 2021/4/2920:04
 */


@Data
public class Score {

    private String userId;
    private String userName;
    private int score;       //制定一套得分标准    ---根据完全猜中的次数来，设置为最多猜20次吧
    //一共100分，多猜一个扣五分
//    private Timestamp lastOnlineTime;   //最后一次上线时间


}
