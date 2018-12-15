package com.hoyan.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by liujh on 2018/10/21 0021.
 */
@Data
@Entity(name = "t_order")
public class order {
    /*订单id*/
    @Id
    private Integer orderId;
    /*扣减数量*/
    private Integer number;
    /*商品id*/
    private String productId;
    /*订单总价*/
    private BigDecimal totalPrice;
    /*创建时间*/
    private Date createTime;
}
