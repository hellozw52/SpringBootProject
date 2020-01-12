package com.imooc.demo.controller;

import com.imooc.demo.config.Application;
import com.imooc.demo.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 用户控制器
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController{

    private static final Logger LOG = LoggerFactory.getLogger(Application.class);


/**
 * 查询所有用户
 * @return
 */
@RequestMapping("/list")
public List<User> list() {
    LOG.info("查询开始");
    List<User> allUser = userService.list();
    return allUser;
}

    /**
     * 新增
     * @return
     */
    @RequestMapping("/add")
    public void add(
            @RequestParam("username") String username,
            @RequestParam("password") String password
    ) {
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        userService.insertUser(user);
    }

/**
 * 修改
 * @return
 */
@RequestMapping("/update")
public void update(
        @RequestParam("username") String username,
        @RequestParam("password") String password
) {
    User user=new User();
    user.setUsername(username);
    user.setPassword(password);
    userService.insertUser(user);
}

}