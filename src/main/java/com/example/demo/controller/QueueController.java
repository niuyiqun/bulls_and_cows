package com.example.demo.controller;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Queue;

/**
 * @author niu
 * @Description:
 * @date 2021/10/912:54
 */


@RestController
public class QueueController {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private ActiveMQQueue queue;

    @RequestMapping("/send")
    public void send(){
        this.jmsMessagingTemplate.convertAndSend(this.queue
        ,"新发送的消息!");
    }
}
