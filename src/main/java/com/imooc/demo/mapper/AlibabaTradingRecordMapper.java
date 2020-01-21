package com.imooc.demo.mapper;

import com.imooc.demo.domain.AlibabaTradingRecord;

import java.util.List;
import java.util.Map;

public interface AlibabaTradingRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AlibabaTradingRecord record);

    AlibabaTradingRecord selectByPrimaryKey(Integer id);

    List<AlibabaTradingRecord> selectAll();

    int updateByPrimaryKey(AlibabaTradingRecord record);


    List<Map<String, Object>> getTradRecordCondition(Map<String,Object> params);


    List<Map<String, Object>> getTradRecordConditionTotalNum(Map<String,Object> params);
}