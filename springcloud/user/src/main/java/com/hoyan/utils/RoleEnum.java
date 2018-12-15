package com.hoyan.utils;

import lombok.Getter;

/**
 * Created by 20160709 on 2018/11/23.
 */
@Getter
public enum RoleEnum {

    BUYER(1,"买家"),
    SELLER(2,"卖家"),
    ;
    private Integer code;
    private String message;

    RoleEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
