package com.imooc.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface AlibabaTradingRecordMapper {

    List<Map<String, Object>> getTradeRecordCondition(Map<String,Object> params);

    int getTradeRecordConditionTotalNum(Map<String,Object> params);

    List<Map<String, Object>> normalQuery(@Param("userId") String userId,@Param("commodityName") String commodityName);
}