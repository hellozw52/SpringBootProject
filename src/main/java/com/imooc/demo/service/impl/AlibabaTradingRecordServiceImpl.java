package com.imooc.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imooc.demo.domain.AlibabaTradingRecord;
import com.imooc.demo.mapper.AlibabaTradingRecordMapper;
import com.imooc.demo.service.AlibabaTradingRecordService;
import com.imooc.demo.tool.FieldTool;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 支付宝交易记录表 服务实现类
 * </p>
 *
 * @author hellozw
 * @since 2020-05-18
 */
@Service
@Transactional
public class AlibabaTradingRecordServiceImpl extends ServiceImpl<AlibabaTradingRecordMapper, AlibabaTradingRecord> implements AlibabaTradingRecordService {

    @Resource
    private AlibabaTradingRecordMapper alibabaTradingRecordMapper;

    @Override
    public List<Map<String, Object>> getTradeRecordCondition(String userId, String commodityName, String sellerName, String tradeState, String payMode, String tradeTotalAmountStart, String tradeTotalAmountEnd, String startTime, String endTime, String weekNum, String startDuration, String endDuration, String sort, String order, int start, int size) throws ParseException {
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

        //参数全部准备完毕，放入map中，传参
        Map<String,Object> params = new HashMap<>();
        params.put("userId", userId);
        params.put("commodityName", commodityName);
        params.put("sellerName", sellerName);
        params.put("tradeState", tradeState);
        params.put("payMode", payMode);
        params.put("tradeTotalAmountStart", tradeTotalAmountStart);
        params.put("tradeTotalAmountEnd", tradeTotalAmountEnd);
        params.put("startTime", startTime);
        params.put("endTime", endTime);
        params.put("weekNum",weekNum);
        params.put("startDuration", startDuration);
        params.put("endDuration",endDuration);
        params.put("sort", sort);
        params.put("order",order);
        params.put("start", start);
        params.put("size", size);

        return FieldTool.formatHumpNameForList(alibabaTradingRecordMapper.getTradeRecordCondition(params));
    }

    @Override
    public int getTradeRecordConditionTotalNum(String userId, String commodityName, String sellerName, String tradeState, String payMode, String tradeTotalAmountStart, String tradeTotalAmountEnd, String startTime, String endTime, String weekNum, String startDuration, String endDuration,String sort,String order) throws ParseException {

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

        //参数全部准备完毕，放入map中，传参
        Map<String,Object> params = new HashMap<>();
        params.put("userId", userId);
        params.put("commodityName", commodityName);
        params.put("sellerName", sellerName);
        params.put("tradeState", tradeState);
        params.put("payMode", payMode);
        params.put("tradeTotalAmountStart", tradeTotalAmountStart);
        params.put("tradeTotalAmountEnd", tradeTotalAmountEnd);
        params.put("startTime", startTime);
        params.put("endTime", endTime);
        params.put("weekNum",weekNum);
        params.put("startDuration", startDuration);
        params.put("endDuration",endDuration);
        params.put("sort", sort);
        params.put("order",order);

        return alibabaTradingRecordMapper.getTradeRecordConditionTotalNum(params);
    }

    @Override
    public List<Map<String, Object>> normalQuery(String userId, String commodityName) {
        return FieldTool.formatHumpNameForList(alibabaTradingRecordMapper.normalQuery(userId,commodityName));
    }

}
