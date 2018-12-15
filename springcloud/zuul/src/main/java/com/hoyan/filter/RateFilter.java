package com.hoyan.filter;


import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import org.springframework.stereotype.Component;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SERVLET_DETECTION_FILTER_ORDER;

/**
 * Created by 20160709 on 2018/11/22.
 */
@Component
public class RateFilter extends ZuulFilter {
    private static final RateLimiter RATE_LIMITER = RateLimiter.create(50);

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        /*限流要放在最前面 优先级最高*/
        return SERVLET_DETECTION_FILTER_ORDER -1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        if(!RATE_LIMITER.tryAcquire()){
            /*没有令牌就抛出异常*/
            throw new RateException();
        }
        return null;
    }
}
