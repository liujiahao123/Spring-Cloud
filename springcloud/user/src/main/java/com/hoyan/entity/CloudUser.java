package com.hoyan.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by 20160709 on 2018/11/22.
 */
@Data
@Entity(name = "cloud_user")
public class CloudUser {
    @Id
    private  Integer id;

    private String userName;

    private String passWord;

    private String openId;

    private Integer role;

    private Date updateTime;

    private Date createTime;


}
