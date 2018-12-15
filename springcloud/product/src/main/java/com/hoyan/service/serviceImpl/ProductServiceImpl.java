package com.hoyan.service.serviceImpl;

import com.hoyan.dao.ProductDao;
import com.hoyan.entity.Product;
import com.hoyan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liujh on 2018/10/21 0021.
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public Product findAllById(Integer id) {
        return productDao.findAllById(id);
    }

    @Override
    public List<Product> findbyProductIdIn(List<Integer> ids) {
        return productDao.findByIdIn(ids);
    }
}
