package com.imooc.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Description 配置日志拦截器 对接统一日志平台
 * @Author zw
 * @Date 2020/8/6 13:57
 * @Param
 * @Return
**/
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    /**
     * @Description 项目默认访问路径
     * @Author zw
     * @Date 2020/8/12 17:06
     * @Param [reg]
     * @Return void
    **/
    @Override
    public void addViewControllers(ViewControllerRegistry reg) {
        //默认访问页面
        reg.addViewController("/").setViewName("redirect:/frame.html");
        reg.setOrder(Ordered.HIGHEST_PRECEDENCE);//最先执行过滤
        super.addViewControllers(reg);
    }

}
