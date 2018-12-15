package com.hoyan.controller;

import com.google.common.base.Strings;
import com.hoyan.entity.CloudUser;
import com.hoyan.service.CloudUserService;
import com.hoyan.utils.CookieUtils;
import com.hoyan.utils.ResultVo;
import com.hoyan.utils.RoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by 20160709 on 2018/11/22.
 */
@RestController
@RequestMapping("login/")
public class CloudUserController {

    @Autowired
    private CloudUserService cloudUserService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    /*买家登录*/
    @RequestMapping("buyer/{openId}")
    public ResultVo buyer(@PathVariable("openId") String openId, HttpServletRequest request, HttpServletResponse response){
        CloudUser cloudUser =  cloudUserService.findAllByOpenId(openId);
        /*数据是否匹配*/
        if(Objects.equals(cloudUser,null)){
            return ResultVo.error();
        }
        if(RoleEnum.BUYER.getCode()!=cloudUser.getRole()){
            return ResultVo.error("角色权限不正确!");
        }
        /*判断角色*/
        /*设置cookie 单位秒*/
        CookieUtils.setCookie(response,"openId",openId,7200);
        return ResultVo.success();
    }

    /*买家登录*/
    @RequestMapping("seller/{openId}")
    public ResultVo seller(String tokenValue,@PathVariable("openId") String openId, HttpServletRequest request, HttpServletResponse response){
        Cookie cookie = CookieUtils.getCookieByName(request,"token");
        if(cookie !=null && !StringUtils.isEmpty(redisTemplate.opsForValue().get(cookie.getValue().toString()))){
            return ResultVo.error("不能重复登录");
        }
        CloudUser cloudUser =  cloudUserService.findAllByOpenId(openId);
        if(Objects.equals(cloudUser,null)){
            return ResultVo.error();
        }
         /*判断角色*/
        if(RoleEnum.SELLER.getCode()!=cloudUser.getRole()){
            return ResultVo.error("角色权限不正确!");
        }

        /*往redis中写入*/
        Integer maxage= 7200;
        String token = UUID.randomUUID().toString()+ new Date().getTime();
        redisTemplate.opsForValue().set(token,openId,maxage, TimeUnit.SECONDS);

        /*设置cookie 单位秒*/
        CookieUtils.setCookie(response,"token",token,maxage);
        return ResultVo.success();
    }


}
