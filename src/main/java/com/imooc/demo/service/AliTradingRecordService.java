package com.imooc.demo.service;

import com.imooc.demo.mapper.AlibabaTradingRecordMapper;
import com.imooc.demo.tool.FieldTool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

@Service
public class AliTradingRecordService {

    @Resource
    private AlibabaTradingRecordMapper alibabaTradingRecordMapper;

    public List<Map<String, Object>> getTradRecordCondition(String userId, String commodityName, String sellerName, String tradeState, String payMode, String tradeTotalAmountStart, String tradeTotalAmountEnd, String startTime, String endTime, String weekNum, String startDuration, String endDuration,String sort,String order, int start, int size) throws ParseException {
        //将驼峰命名转为下划线命名,与数据库一致
        sort = FieldTool.humpToUnderline(sort);
        //设置每页起始位置
        start = start*size;

        //交易总金额为空 设置默认值
        if(tradeTotalAmountStart.equals("")||tradeTotalAmountStart==null){
            tradeTotalAmountStart = "0";
        }
        //交易总金额为空 设置默认值
        if(tradeTotalAmountEnd.equals("")||tradeTotalAmountEnd==null){
            tradeTotalAmountEnd = "999999999";
        }
        //开始时间为空 设置默认值
        if(startTime.equals("")||startTime==null){
            startTime = "1860-01-01 00:00:00";
        }
        //结束时间为空 设置默认值
        if(endTime.equals("")||endTime==null){
            endTime = "2100-01-01 00:00:00";
        }
        //开始时段 设置默认值
        if(startDuration.equals("")||startDuration==null){
            startDuration = "00:00:00";
        }
        //结束时段 设置默认值
        if(endDuration.equals("")||endDuration==null){
            endDuration = "23:59:59";
        }

        return FieldTool.formatHumpNameForList(alibabaTradingRecordMapper.getTradRecordCondition(userId,commodityName,sellerName,tradeState,payMode,tradeTotalAmountStart,tradeTotalAmountEnd,startTime,endTime,weekNum,startDuration,endDuration,sort,order,start,size));
    }

    public int getTradRecordConditionTotalNum(String userId, String commodityName, String sellerName, String tradeState, String payMode, String tradeTotalAmountStart, String tradeTotalAmountEnd, String startTime, String endTime, String weekNum, String startDuration, String endDuration,String sort,String order) throws ParseException {

        //将驼峰命名转为下划线命名,与数据库一致
        sort = FieldTool.humpToUnderline(sort);

        //交易总金额为空 设置默认值
        if(tradeTotalAmountStart.equals("")||tradeTotalAmountStart==null){
            tradeTotalAmountStart = "0";
        }
        //交易总金额为空 设置默认值
        if(tradeTotalAmountEnd.equals("")||tradeTotalAmountEnd==null){
            tradeTotalAmountEnd = "999999999";
        }
        //开始时间为空 设置默认值
        if(startTime.equals("")||startTime==null){
            startTime = "1860-01-01 00:00:00";
        }
        //结束时间为空 设置默认值
        if(endTime.equals("")||endTime==null){
            endTime = "2100-01-01 00:00:00";
        }
        //开始时段 设置默认值
        if(startDuration.equals("")||startDuration==null){
            startDuration = "00:00:00";
        }
        //结束时段 设置默认值
        if(endDuration.equals("")||endDuration==null){
            endDuration = "23:59:59";
        }

        return alibabaTradingRecordMapper.getTradRecordConditionTotalNum(userId,commodityName,sellerName,tradeState,payMode,tradeTotalAmountStart,tradeTotalAmountEnd,startTime,endTime,weekNum,startDuration,endDuration,sort,order).size();
    }
}
