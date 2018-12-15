package com.hoyan.mqMessage;

import com.hoyan.entity.order;
import com.hoyan.result.IdWorker;
import lombok.extern.slf4j.Slf4j;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import com.esotericsoftware.minlog.Log;
import com.hoyan.stream.StreamClient;


@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {
	
    //接收方
/*	@StreamListener("myMessage")
	public void process(Object message){
		Log.info("StreamReceiver===" + message);
	}*/

	//接收方
	@StreamListener("myMessage")
	@SendTo("myMessage2")
	public String Objprocess(order message){
		Log.info("Objprocess===" + message);
		return "我收到消息-并发送了一条"+ IdWorker.getStringCode();
	}

	//接收方
	@StreamListener("myMessage2")
	public void Objprocess2(String message){
		Log.info("Objprocess2收到了一条消息===" + message);
	}
	
}
