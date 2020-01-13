package com.imooc.demo.controller;

import com.imooc.demo.config.Application;
import com.imooc.demo.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 用户控制器
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

    /**
     * 新增
     */
    @RequestMapping("/add")
    public void add(
            @RequestParam("username") String username,
            @RequestParam("password") String password
    ) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRegisterTime(new Date());
        userService.insert(user);
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public void delete(
            @RequestParam("id") int id
    ) {
        userService.delete(id);
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public void update(
            @RequestParam("id") int id,
            @RequestParam("username") String username,
            @RequestParam("password") String password
    ) {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setRegisterTime(new Date());
        userService.update(user);
    }

    /**
     * 查询所有用户
     */
    @RequestMapping("/list")
    public List<User> list() {
        LOG.info("查询开始");
        List<User> allUser = userService.list();
        return allUser;
    }

    /**
     * 查询所有用户 listMap方式  转为驼峰命名
     */
    @RequestMapping("/listByListMap")
    public List<Map<String,Object>> listByListMap() {
        LOG.info("查询开始");
        listMap = userService.listByListMap();
        return listMap;
    }

    /**
     * 查询单个用户
     */
    @RequestMapping("/getOne")
    public User getOne(
        @RequestParam("id") int id
    ) {
        LOG.info("查询开始");
        User oneUser = userService.getOne(id);
        return oneUser;
    }

}