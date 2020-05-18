package com.imooc.demo.service;

import com.imooc.demo.domain.AlibabaTradingRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.imooc.demo.tool.FieldTool;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 支付宝交易记录表 服务类
 * </p>
 *
 * @author hellozw
 * @since 2020-05-18
 */
public interface AlibabaTradingRecordService extends IService<AlibabaTradingRecord> {

    public List<Map<String, Object>> getTradeRecordCondition(String userId, String commodityName, String sellerName, String tradeState, String payMode, String tradeTotalAmountStart, String tradeTotalAmountEnd, String startTime, String endTime, String weekNum, String startDuration, String endDuration, String sort, String order, int start, int size) throws ParseException;

    public int getTradeRecordConditionTotalNum(String userId, String commodityName, String sellerName, String tradeState, String payMode, String tradeTotalAmountStart, String tradeTotalAmountEnd, String startTime, String endTime, String weekNum, String startDuration, String endDuration,String sort,String order) throws ParseException;

    public List<Map<String, Object>> normalQuery(String userId, String commodityName);
}