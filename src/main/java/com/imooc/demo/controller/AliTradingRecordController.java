package com.imooc.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户控制器
 */
@RestController
@RequestMapping("/aliTradingRecord")
public class AliTradingRecordController extends BaseController {

    /**
     * 交易记录条件查询   参数较多时，使用map传参
     */
    @RequestMapping("/queryResult")
    public Map<String,Object> queryResult(
            @RequestParam("userId") String userId,
            @RequestParam(value = "commodityName",required = false) String commodityName,
            @RequestParam(value = "sellerName",required = false) String sellerName,
            @RequestParam(value = "tradeState",required = false) String tradeState,
            @RequestParam(value = "payMode",required = false) String payMode,
            @RequestParam(value = "tradeTotalAmountStart",required = false) String tradeTotalAmountStart,
            @RequestParam(value = "tradeTotalAmountEnd",required = false) String tradeTotalAmountEnd,
            @RequestParam(value = "startTime",required = false) String startTime,
            @RequestParam(value = "endTime",required = false) String endTime,
            @RequestParam("weekNum") String weekNum,
            @RequestParam("startDuration") String startDuration,//开始时段
            @RequestParam("endDuration") String endDuration,//结束时段
            @RequestParam("sort") String sort,
            @RequestParam("order") String order,
            @RequestParam("page") String page,
            @RequestParam("rows") String rows
    ) throws ParseException {

        int start = Integer.parseInt((page == null || page == "0") ? "1" : page) - 1;// 开始位置
        int size = Integer.parseInt((rows == null || rows == "0") ? "15" : rows);// 每页个数

        // 将参数全部传递至service层进行整理、入map
        if ((commodityName != "") || (sellerName != "") || (tradeState != "") || (tradeState != "") || (payMode != "") || (tradeTotalAmountStart != "")
            || (tradeTotalAmountEnd != "") || (startTime != "") || (endTime != "") || (weekNum != "")|| (startDuration != "") || (endDuration != "")) {
            listMap = aliTradingRecordService.getTradRecordCondition(userId,commodityName,sellerName,tradeState,payMode,tradeTotalAmountStart,tradeTotalAmountEnd,startTime,endTime,weekNum,startDuration,endDuration,sort,order,start,size);
            listNum = aliTradingRecordService.getTradRecordConditionTotalNum(userId,commodityName,sellerName,tradeState,payMode,tradeTotalAmountStart,tradeTotalAmountEnd,startTime,endTime,weekNum,startDuration,endDuration,sort,order);
        }
        // 实例化data 存放数据
        map = new HashMap<String, Object>();
        map.put("rows", listMap);
        map.put("total", listNum);

        // 返回json数据
        return map;
    }

    /**
     * 交易记录条件查询   参数较少，直接传参
     */
    @RequestMapping("/normalQuery")
    public List<Map<String,Object>> normalQuery(
            @RequestParam("userId") String userId,
            @RequestParam(value = "commodityName",required = false) String commodityName
    ) {
        listMap = aliTradingRecordService.normalQuery(userId,commodityName);
        return listMap;
    }


}