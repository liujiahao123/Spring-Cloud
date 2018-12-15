package com.hoyan.filter;

import com.hoyan.utils.CookieUtils;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;


/**
 * Created by 20160709 on 2018/11/22. 权限拦截区分买卖家
 */
@Component
public class AuthFilter extends ZuulFilter {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public String filterType() {
        return PRE_TYPE;//放在前置过滤器的位置生效
    }

    @Override
    public int filterOrder() {
        //PRE_DECORATION_FILTER_ORDER这个过滤器的前面
        return PRE_DECORATION_FILTER_ORDER - 2;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        //这里从url参数获取  也可以在cookie header中获取
        //order/create 创建订单只能买家访问  order/finsh 完结订单 卖家访问  order/list 商品列表都能访问
        if("/order/order/createAuth".equals(request.getRequestURI())){
           Cookie cookie =  CookieUtils.getCookieByName(request,"openId");
           if(cookie==null || StringUtils.isEmpty(cookie.getValue())){
               requestContext.setSendZuulResponse(false);
               requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
           }
        }
        if("/order/order/finishAuth".equals(request.getRequestURI())){
            Cookie cookie =  CookieUtils.getCookieByName(request,"token");
            if(cookie==null
                    || StringUtils.isEmpty(cookie.getValue())
                    || StringUtils.isEmpty(redisTemplate.opsForValue().get(cookie.getValue()))){
                requestContext.setSendZuulResponse(false);
                requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            }
        }

        return null;
    }
}
