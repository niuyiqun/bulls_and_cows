package com.example.demo.entity;

import lombok.Data;

import java.util.List;

/**
 * @author niu
 * @Description:  记录用户的猜测记录
 * @date 2021/5/610:06
 */


@Data
public class GameRecord {

    private String userId;
    private int playCount;    //用户进行了多少次猜数字游戏（大的次数，不是每次游戏中小的次数)
//    private List<Integer> digitGroup;   //用户当次猜测的四个数字
    private String digitGroup;    //格式: 1 2 3 4
    private int right;
    private int semiRight;
}
