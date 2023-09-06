package com.bevan.apidriver.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zbf
 * 2023/7/10 23:51
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    /**
     * 为了能让StringRedisTemplate成功注入在JwtInterceptor里面 而添加的；
     * 拦截器里面的Bean就会成功注入进去
     */
    @Bean
    public JwtInterceptor jwtInterceptor() {
        return new JwtInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor())
                // 拦截全部
                .addPathPatterns("/**")
                // 不拦截全部
                .excludePathPatterns("/verification-code")
                .excludePathPatterns("/verification-code-check")
                .excludePathPatterns("/noAuth")
        ;
    }
}
