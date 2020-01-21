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

    // 封装常用数据
    protected Map<String, Object> map; //一条记录
    protected List<Map<String,Object>> listMap; //多条记录
    protected int listNum;//记录个数

    // 待注入的service对象
    @Resource
    protected UserService userService;
    @Resource
    protected AliTradingRecordService aliTradingRecordService;

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

    public int getListNum() {
        return listNum;
    }

    public void setListNum(int listNum) {
        this.listNum = listNum;
    }
}
