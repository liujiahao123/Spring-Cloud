package com.hoyan.service.serviceImpl;

import com.hoyan.dao.orderDao;
import com.hoyan.entity.order;
import com.hoyan.service.orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liujh on 2018/10/21 0021.
 */
@Service
public class orderServiceImpl implements orderService {

    @Autowired
    private orderDao orderdao;


    @Override
    public order create(order o) {
        order obj = orderdao.save(o);
        return obj;
    }
}
