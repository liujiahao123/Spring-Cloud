package com.hoyan.client;

import com.hoyan.entity.Product;

import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by liujh on 2018/10/24 0024.
 */

//@FeignClientient(name = "product")
@FeignClient(name = "product" , fallback = ProductClientFallback.class)
public interface ProductClient {

    @PostMapping("/getId")
    String byId(@RequestParam("id") int id);

    @PostMapping("/queryProducts")
    List<Product> findQueryByIds(List<Integer> productIds);
}
