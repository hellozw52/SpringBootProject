package com.imooc.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author zw
 * @description 日志拦截器  用于搜集每个接口信息
 * @Param
 * @date 2020/7/20 20:23
 * @return
 * @throws
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    // 搜集日志  需要时放开代码
//    @Autowired
//    private LogInterceptor logInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(logInterceptor).addPathPatterns("/**");
//    }
}
