package com.hoyan.dao;

import com.hoyan.entity.CloudUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 20160709 on 2018/11/22.
 */
public interface CloudUserDao extends JpaRepository<CloudUser,String> {
    CloudUser findAllByOpenId(String operId);
}
