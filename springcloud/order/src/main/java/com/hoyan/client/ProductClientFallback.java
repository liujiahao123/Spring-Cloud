package com.hoyan.client;

import com.hoyan.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by 20160709 on 2018/11/24.
 */
@Component
public class ProductClientFallback implements ProductClient {
    @Override
    public String byId(int id) {
        return null;
    }

    @Override
    public List<Product> findQueryByIds(List<Integer> productIds) {
        return null;
    }
}
