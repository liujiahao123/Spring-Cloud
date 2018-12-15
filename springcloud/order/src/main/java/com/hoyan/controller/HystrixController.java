package com.hoyan.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * Created by 20160709 on 2018/11/24.
 */
@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {

    //@HystrixCommand(fallbackMethod = "fallback")
    /*@HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })*/
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),/*设置熔断*/
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),/**/
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),/*10将尝试熔断*/
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),/*出错概率60% 一定时间的出错为60%*/
    })
    @GetMapping("/getProductInfoList/{number}")
    public String getProductInfoList(@PathVariable Integer number) {
        if (number % 2 == 0) {
            return "success";
        } else {
            throw new RuntimeException("我是一个为所欲为的异常!");
        }
       /* RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject("http://127.0.0.1:8086/queryProducts", Arrays.asList(1, 5, 8), String.class);*/

    }

    private String fallback() {
        return "网络好像断了！请稍后再试。。。";
    }

    private String defaultFallback() {
        return "默认太拥挤了！请稍后再试。。。";
    }

}
