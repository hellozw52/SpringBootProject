package com.imooc.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.core.env.Environment;

@SpringBootApplication
@MapperScan("com.imooc.demo.mapper")
public class DemoApplication extends SpringBootServletInitializer {

    private static final Logger LOG = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DemoApplication.class);
        Environment env = app.run(args).getEnvironment();
        System.out.println("用户登录: \thttp://127.0.0.1:" + env.getProperty("server.port") + env.getProperty("server.servlet.context-path") + "/login.html");
        System.out.println("用户查询: \thttp://127.0.0.1:" + env.getProperty("server.port") + env.getProperty("server.servlet.context-path") + "/user/listByListMap?page=1&limit=10&orderField=id&orderType=desc");
        System.out.println("交易查询: \thttp://127.0.0.1:" + env.getProperty("server.port") + env.getProperty("server.servlet.context-path") + "/aliTradingRecord/normalQuery?userId=2088332759128563&commodityName=云南");
        System.out.println("CAS登录: \thttp://127.0.0.1:8001/demo/casAuth/login");
        System.out.println("绕过CAS直接获取数据: \thttp://127.0.0.1:8001/demo/casAuth/getCasInterData?interfaceUrl=http://dsjpt.isct.cn:18087/common/notice/list?page=1%26rows=15");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(DemoApplication.class);
    }

}