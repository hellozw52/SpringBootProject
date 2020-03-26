package com.imooc.demo.controller;

import com.imooc.demo.DemoApplication;
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

    private static final Logger LOG = LoggerFactory.getLogger(DemoApplication.class);

    /**
     * 查询所有用户 listMap方式  转为驼峰命名
     */
    @RequestMapping("/listByListMap")
    public List<Map<String,Object>> listByListMap() {
        LOG.info("查询开始");
        listMap = userService.listByListMap();
        return listMap;
    }


}