package com.example.demo;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Queue;

@SpringBootApplication
@EnableCaching
public class ObjectOrientedApplication {

	public static void main(String[] args) {
		SpringApplication.run(ObjectOrientedApplication.class, args);
	}

	@Bean
	public ActiveMQQueue queue(){
		return new ActiveMQQueue("active.queue");
	}
}
