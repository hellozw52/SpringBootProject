package com.imooc.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description 读取shiro白名单url列表
 * @Author zw
 * @Date 2020/9/11 16:59
 * @Param
 * @Return
**/
@Component
@ConfigurationProperties(prefix = "shiro-ignorl-url")
public class IgoreUrlList {

    private List<String> urls;

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }
}
