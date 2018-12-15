package com.hoyan.serviceImpl;

import com.hoyan.dao.CloudUserDao;
import com.hoyan.entity.CloudUser;
import com.hoyan.service.CloudUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 20160709 on 2018/11/22.
 */
@Service
public class CloudUserServiceImpl implements CloudUserService {

    @Autowired
    private CloudUserDao cloudUserDao;

    @Override
    public CloudUser findAllByOpenId(String operId) {
        return cloudUserDao.findAllByOpenId(operId);
    }
}
