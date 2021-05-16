package com.example.demo.controller;

import com.example.demo.entity.DigitGroup;
import com.example.demo.service.DigitGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author niu
 * @Description:
 * @date 2021/5/519:15
 */


@RestController
@RequestMapping("/test")
public class test {

    @Autowired
    DigitGroupService digitGroupService;

    @Autowired
    DigitGroup digitGroup;


    @RequestMapping("/Initbean")
    public String Initbean(){
        digitGroupService.initDigitGroup();
//        System.out.println(digitGroup.getList());
        return "suc";
    }

    @RequestMapping("/bean")
    public String bean(){
//        digitGroupService.initDigitGroup();
        System.out.println(digitGroup.getList());
        return "suc";
    }
}
