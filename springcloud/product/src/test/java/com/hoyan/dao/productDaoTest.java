package com.hoyan.dao;

import com.google.common.collect.Lists;
import com.hoyan.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by liujh on 2018/10/21 0021.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class productDaoTest {

    @Autowired
    private  ProductDao productDao;

    @Test
    public void  findAll(){
        List<Product> productList = productDao.findAll();
        productList.forEach(li->{
            System.out.print(li.getProductName());
        });
    }
    @Test
    public void findbyProductIdIn(){
        List<Integer> ids = Lists.newArrayList();
        ids.add(1);
        ids.add(3);
        ids.add(5);
        List<Product> pos = productDao.findByIdIn(ids);
    }


}