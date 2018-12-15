package com.hoyan.mqMessage;

import com.esotericsoftware.minlog.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by liujh on 2018/11/20 0020.
 */
@Component
@Slf4j
public class ProductMqServerInfo {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RabbitListener(queues = "myProductQueue")
    public void process(String message){
        stringRedisTemplate.opsForValue().set(message,message);
        System.out.print("商品服务发来的消息已经放入redis中key: "+message);
    }

}
