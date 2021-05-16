package com.example.demo.service;

import com.example.demo.entity.DigitGroup;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author niu
 * @Description: 四个数字的操作方法
 * @date 2021/5/515:25
 */

public interface DigitGroupService {

    //产生四个互不相同的随机数
    void initDigitGroup();
}
