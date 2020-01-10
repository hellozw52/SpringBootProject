package com.imooc.demo.controller;

import com.imooc.demo.config.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController{

    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

    @RequestMapping("/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password) {

        LOG.info("登录开始, {}", username+"  "+password);

        //调用service方法
        Map<String,Object> user = userService.doLogin(username,password);

        if (user == null) {
            LOG.warn("用户或密码错");
            return "用户或密码错";
        } else {
            LOG.info("登录成功");
            return "登录成功";
        }
    }

    @RequestMapping("/list")
    public List<Map<String,Object>> list() {
        LOG.info("查询开始");
        listMap = userService.list();
        return listMap;
    }

}