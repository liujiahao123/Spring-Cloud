package com.hoyan.dao;

import com.hoyan.entity.order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by liujh on 2018/10/21 0021.
 */

public interface orderDao extends JpaRepository<order,Integer> {


}
