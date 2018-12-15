package com.hoyan.mqMessage;

import lombok.extern.slf4j.Slf4j;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.esotericsoftware.minlog.Log;


//接收消息
@Component
@Slf4j
public class MqReceiver {
    
	//@RabbitListener(queues = "myQueue")
	//支持自动声明绑定，声明之后自动监听队列的队列，此时@RabbitListener注解的queue和bindings不能同时指定，否则报错
	@RabbitListener(bindings = @QueueBinding(
			value=@Queue("myfruitOrder"),
			key="fruit",
			exchange = @Exchange("MyExchange")
			))
	public void process(String message){
		Log.info("fruit这是接收的消息" + message);
	}
	
	@RabbitListener(bindings = @QueueBinding(
			value=@Queue("myComputerQueue"),
			key="computer",
			exchange = @Exchange("MyExchange")
			))
	public void computer(String message){
		Log.info("computer这是接收的消息" + message);
	}
	
}
