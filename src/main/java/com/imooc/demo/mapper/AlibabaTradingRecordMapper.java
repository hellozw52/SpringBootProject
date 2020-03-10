package com.imooc.demo.mapper;

import com.imooc.demo.domain.AlibabaTradingRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AlibabaTradingRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AlibabaTradingRecord record);

    AlibabaTradingRecord selectByPrimaryKey(Integer id);

    List<AlibabaTradingRecord> selectAll();

    int updateByPrimaryKey(AlibabaTradingRecord record);


    List<Map<String, Object>> getTradeRecordCondition(Map<String,Object> params);


    int getTradeRecordConditionTotalNum(Map<String,Object> params);

    List<Map<String, Object>> normalQuery(@Param("userId") String userId,@Param("commodityName") String commodityName);
}