package com.hoyan.controller;

import com.hoyan.client.ProductClient;
import com.hoyan.entity.Product;
import com.hoyan.entity.order;
import com.hoyan.result.Result;
import com.hoyan.service.orderService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;


/**
 * Created by liujh on 2018/10/21 0021.
 */
@Controller
@RequestMapping("/order")
@RefreshScope
@Slf4j
public class OrderController {
    /*/order/create    创建订单 减库存  参数productId  数量*/
	
    @Value("${env}")
	private String env;

    @Autowired
    private orderService orderservice;

    @Autowired
    private ProductClient productClient;

    @Autowired
    private RestTemplate restTemplate;

    //private LoadBalancerClient loadBalancerClient;

    @RequestMapping("/create")
    @ResponseBody
    public Result<Boolean> createOrder(@RequestParam(value = "productId", required = true) String productId,
                                       @RequestParam(value = "num", required = true) Integer num) {
        /*根据参数调用product服务查询商品
        * 商品不存在返回提示
        * 计算总价
        * 返回提示消息*/
        order obj = new order();
        int i = (int) (Math.random() * 1000000 + 100000);
        RestTemplate restTemplate = new RestTemplate();
            /*1*/
        //ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
        //String url = String.format("http://%s:%s",serviceInstance.getHost(),serviceInstance.getPort())+"/product/get/"+productId;
        //String productStr = restTemplate.getForObject(url,String.class);
             /*2*/
        //String productStr = restTemplate.getForObject("http://localhost:8086/product/get/"+productId,String.class);
           /*3*/
       /* String productStr = restTemplate.getForObject("http://PRODUCT/product/get/" + productId , String.class);
        log.info(productStr + "-----------------------");*/
       /* orderservice.create(obj);*/
        return Result.success(true);
    }

    @RequestMapping("/productId/{id}")
    @ResponseBody
    public String test(@PathVariable int id) {
        String result = productClient.byId(id);
        return result;
    }

    @RequestMapping("/getProductList")
    @ResponseBody
    public List<Product> getProductList(){
        List<Integer> lists = Arrays.asList(2,3,4,5);
        List<Product> pos =  productClient.findQueryByIds(lists);
        return pos;
    }

    /*createOrder创建订单只能买家访问*/
    @RequestMapping("/createAuth")
    @ResponseBody
    public String createOrder(){
        return "买家访问的接口-------------";
    }

	/*finishOrder完结订单只能卖家访问*/
    @RequestMapping("/finishAuth")
    @ResponseBody
    public String finishOrder(){
        return "卖家访问的接口==============";
    }

	
	@RequestMapping("/print")
	@ResponseBody
	public String dev(){
		System.out.println("--------------------");
		return env;
	}


}
