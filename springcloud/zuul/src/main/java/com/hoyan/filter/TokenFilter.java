package com.hoyan.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.bouncycastle.util.Strings;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;


/**
 * Created by 20160709 on 2018/11/22.
 */
@Component
public class TokenFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return PRE_TYPE;//放在前置过滤器的位置生效
    }

    @Override
    public int filterOrder() {
        //PRE_DECORATION_FILTER_ORDER这个过滤器的前面
        return PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        /*RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        //这里从url参数获取  也可以在cookie header中获取
        String token = request.getParameter("token");
        *//*只能访问买卖家接口的过滤器分析*//*
        *//*买家*//*
        if(StringUtils.isEmpty(token)){
            *//*表示没有权限*//*
            requestContext.setSendZuulResponse(false);
            //401错误
            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }*/
        return null;
    }
}
