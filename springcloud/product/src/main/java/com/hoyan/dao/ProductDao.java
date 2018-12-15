package com.hoyan.dao;

import com.hoyan.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by liujh on 2018/10/21 0021.
 */
public interface ProductDao extends JpaRepository<Product,Integer> {

    /*查询所有商品*/

    List<Product> findAll();

    /*查询所有商品*/

    Product findAllById(Integer id);

    /*根据id查询*/
    List<Product> findByIdIn(List<Integer> ids);



}
