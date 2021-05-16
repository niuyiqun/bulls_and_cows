package com.example.demo.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author niu
 * @Description: 四个数字为一组作为一个类，每次一轮游戏进行是，初始化一个该类的bean
 * @date 2021/4/2919:21
 */



@Data
public class DigitGroup {

    private List<Integer> list;      //数量限定为4

}
