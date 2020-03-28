package com.imooc.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@SpringBootApplication
@ComponentScan("com")
public class DemoApplication extends SpringBootServletInitializer {

    private static final Logger LOG = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DemoApplication.class);
        Environment env = app.run(args).getEnvironment();
        System.out.println("用户查询: \thttp://127.0.0.1:" + env.getProperty("server.port") + env.getProperty("server.servlet.context-path") + "/user/listByListMap?page=1&limit=10");
        System.out.println("交易查询: \thttp://127.0.0.1:" + env.getProperty("server.port") + env.getProperty("server.servlet.context-path") + "/aliTradingRecord/normalQuery?userId=2088332759128563&commodityName=云南");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(DemoApplication.class);
    }

}