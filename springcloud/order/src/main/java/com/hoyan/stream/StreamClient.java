package com.hoyan.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;



public interface StreamClient {
	
	@Input("myMessage")
	SubscribableChannel input();
	
	@Output("myMessage")
	MessageChannel output();

	@Input("myMessage2")
	SubscribableChannel input2();

	@Output("myMessage2")
	MessageChannel output2();

}
