package com.imooc.demo.controller;

import com.imooc.demo.service.UserService;
import com.imooc.demo.service.ZdPersonService;
import com.imooc.demo.tool.Layui;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * @Description 控制层父类
 * @Author zw
 * @Date 2020/7/22 20:11
 * @Param
 * @Return
**/
public abstract class BaseController {

    // 封装常用数据
    protected Map<String, Object> map;
    protected List<Map<String, Object>> listMap;
    protected int listNum;
    protected Map<String, Object> result;
    protected Layui layuiResult;//给layui返回的结果

    // 各子系统的url地址
    @Value("${systemUrl.casUrl}")
    protected String casUrl;
    @Value("${systemUrl.demoUrl}")
    protected String demoUrl;


    // 待注入的service对象
    @Resource
    protected UserService userService;
    @Resource
    protected ZdPersonService zdPersonService;

}
