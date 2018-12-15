package com.hoyan.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by liujh on 2018/10/21 0021.
 */

@Data
@Entity(name = "t_product")
public class Product {
   /*商品id*/
    @Id
    private Integer id;

    private String productName;

    private Integer stock;

    private BigDecimal price;

    private String introduce;
}
