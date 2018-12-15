package com.hoyan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

/**跨域配置  资源共享
 * Created by 20160709 on 2018/11/23.
 */
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter(){
        final UrlBasedCorsConfigurationSource source =new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config =new CorsConfiguration();
        config.setAllowCredentials(true);/*支持cookie跨域*/
        config.setAllowedOrigins(Arrays.asList("*"));//原始域  http:www.a.com
        config.setAllowedHeaders(Arrays.asList("*"));//头部信息
        config.setAllowedMethods(Arrays.asList("*"));//方法 GET  POST
        config.setMaxAge(300L);//这个时间段相同的方法不进行检测

        source.registerCorsConfiguration("/**",config);/*所有域名*/
        return  new CorsFilter(source);
    }

}
