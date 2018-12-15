package com.hoyan.service;

import com.hoyan.entity.Product;

import java.util.List;

/**
 * Created by liujh on 2018/10/21 0021.
 */
public interface ProductService {
    List<Product> findAll();

    Product findAllById(Integer id);

    public  List<Product> findbyProductIdIn(List<Integer> ids);

}
