package com.imooc.demo.controller;

import com.imooc.demo.service.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;


/**
 * 基本controller 减少代码量
 * @author zhaowei
 */
public class BaseController {

    // 封装显示的数据
    protected Map<String, Object> map;
    protected List<Map<String,Object>> listMap;

    // 待注入的service对象
    @Resource
    protected UserService userService;

    //getter setter
    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public List<Map<String, Object>> getListMap() {
        return listMap;
    }

    public void setListMap(List<Map<String, Object>> listMap) {
        this.listMap = listMap;
    }
}
