package com.imooc.demo.controller;

import com.imooc.demo.tool.Layui;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户控制器
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 查询所有用户
     */
    @ResponseBody
    @RequestMapping("/listByListMap")
    public Layui listByListMap(
            @RequestParam("page") int page,
            @RequestParam("limit") int limit,
            @RequestParam("orderField") String orderField,
            @RequestParam("orderType") String orderType
    ) {

        logger.info("查询开始");

        layuiResult = new Layui();//返回layui结果

        listMap = userService.currentPageList(page,limit,orderField,orderType);
        listNum = userService.getUserTotalNum();

        return layuiResult.data(listNum,listMap);

    }

    @ResponseBody
    @RequestMapping("login")
    public Map<String,Object> login(@RequestParam("username") String username,@RequestParam("password") String password){
        logger.info("进行登陆");
        //返回结果
        result = new HashMap<>();
        //获取一条结果
        map = userService.login(username,password);

        if(map!=null){
            result.put("result","success");
            result.put("msg","登录成功，欢迎您： "+username);
            result.put("url","./index.html");
        }else {
            result.put("result","false");
            result.put("msg","登录失败");
        }

        return result;
    }

    @ResponseBody
    @RequestMapping("add")
    public Map<String,Object> add(@RequestParam("username") String username,@RequestParam("password") String password){
        logger.info("添加用户");
        //返回结果
        map = userService.add(username,password);
        return map;
    }

    /**
     * 查询
     */
    @ResponseBody
    @RequestMapping("/search")
    public Layui search(
            @RequestParam("username") String username,
            @RequestParam("startime") String startime,
            @RequestParam("endtime") String endtime,
            @RequestParam("page") String page,
            @RequestParam("limit") String limit,
            @RequestParam("orderField") String orderField,
            @RequestParam("orderType") String orderType
    ) {

        logger.info("查询开始");

        int pagecc = Integer.parseInt((page == null || page == "0") ? "1" : page);// 开始位置
        int limitcc = Integer.parseInt((limit == null || limit == "0") ? "10" : limit);// 每页个数

        if (startime.equals("") || startime == null){
            startime = "1860-01-01";
        }
        if (endtime.equals("") || endtime == null){
            endtime = "2300-01-01";
        }

        layuiResult = new Layui();//返回layui结果

        listMap = userService.search(username,startime,endtime,orderField,orderType,pagecc,limitcc);
        listNum = userService.searchTotalNum(username,startime,endtime);

        return layuiResult.data(listNum,listMap);

    }


}