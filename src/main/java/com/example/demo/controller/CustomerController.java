package com.example.demo.controller;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author niu
 * @Description:
 * @date 2021/10/912:58
 */




@RestController
public class CustomerController {
    @JmsListener(destination = "active.queue")
    public void readActive(String message){
        System.out.println("接收到" + message);
    }

}
