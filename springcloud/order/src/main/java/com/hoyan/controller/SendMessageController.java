package com.hoyan.controller;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hoyan.entity.order;
import com.hoyan.stream.StreamClient;


@RestController
public class SendMessageController {
	
	@Autowired
	private StreamClient streamClient;
	
	@GetMapping("/send/{mes}")
	public void sendMes(@PathVariable("mes")String mes){
		streamClient.output().send(MessageBuilder.withPayload(mes).build());
	}
	
	@GetMapping("/sendObj")
	public void sendObj(){
		order or=new order();
		or.setOrderId(133434434);
		or.setProductId("12344556");
		streamClient.output().send(MessageBuilder.withPayload(or).build());
	}


	/*@Autowired
	private AmqpTemplate amqpTemplate;

	@Test
	public void sendMes() {
		//发送消息测试
		amqpTemplate.convertAndSend("myQueue",IdWorker.getLongCode());
	}

	@Test
	public void sendMesOrder() {
		//发送消息测试
		amqpTemplate.convertAndSend("MyExchange","computer",IdWorker.getLongCode()+"123");
		amqpTemplate.convertAndSend("MyExchange","fruit",IdWorker.getLongCode()+"abc");
	}*/

}
