package com.hoyan.controller;

import com.hoyan.entity.Product;
import com.hoyan.service.ProductService;

import com.hoyan.utils.IdWorker;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by liujh on 2018/10/21 0021.
 */
@Controller
public class productController {


    @Autowired
    ProductService productService;

    @Autowired
	private AmqpTemplate amqpTemplate;


    /*发送消息到Order服务*/
    @GetMapping("/SendMesOrder")
    @ResponseBody
    public String sendToOrder(){
        String code = IdWorker.getStringCode();
        amqpTemplate.convertAndSend("myProductQueue", "我是订单服务过来的消息 :"+code);
        return code;
    }


    @GetMapping("/Goodslist")
    @ResponseBody
    public List<Product> list() {
        List<Product> list = productService.findAll();
        if (list != null && list.size() > 0) {
            return list;
        }
        return null;
    }

    @PostMapping("/getId")
    @ResponseBody
    public Product byId(@RequestParam("id")int id) {
        Product obj = productService.findAllById(id);
        if (obj != null) {
            return obj;
        }
        return null;
    }

    @PostMapping("/queryProducts")
    @ResponseBody
    public List<Product> findQueryByIds(@RequestBody List<Integer> productIds){
        System.out.println("------------product----------");
        return productService.findbyProductIdIn(productIds);
    }

    @RequestMapping("/requestfun")
    @ResponseBody
    public String requestFun(){
        return "request Success";
    }



}
