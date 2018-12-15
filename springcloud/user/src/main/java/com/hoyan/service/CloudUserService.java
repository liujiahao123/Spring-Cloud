package com.hoyan.service;

import com.hoyan.entity.CloudUser;

/**
 * Created by 20160709 on 2018/11/22.
 */
public interface CloudUserService {
    CloudUser findAllByOpenId(String operId);
}
