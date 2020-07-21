package com.imooc.demo.controller;

import com.imooc.demo.service.AlibabaTradingRecordService;
import com.imooc.demo.service.UserService;
import com.imooc.demo.service.ZdPersonService;
import com.imooc.demo.tool.Layui;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * @author zw
 * @description 基本controller 减少代码量
 * @Param
 * @date 2020/7/21 8:39
 * @return
 * @throws
 */
public abstract class BaseController {

    // 封装常用数据
    protected Map<String, Object> map; //一条记录
    protected List<Map<String, Object>> listMap; //多条记录
    protected int listNum;//记录个数
    protected Map<String, Object> result;//返回结果
    protected Layui layuiResult;//给layui返回的结果

    // 待注入的service对象
    @Resource
    protected UserService userService;
    @Resource
    protected AlibabaTradingRecordService alibabaTradingRecordService;
    @Resource
    protected ZdPersonService zdPersonService;

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

    public Map<String, Object> getResult() {
        return result;
    }

    public void setResult(Map<String, Object> result) {
        this.result = result;
    }
}
