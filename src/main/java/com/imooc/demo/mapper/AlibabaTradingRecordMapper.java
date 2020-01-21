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

    List<Map<String, Object>> getTradRecordCondition(@Param("userId") String userId,@Param("commodityName") String commodityName,@Param("sellerName") String sellerName,@Param("tradeState") String tradeState,@Param("payMode")  String payMode,@Param("tradeTotalAmountStart") String tradeTotalAmountStart,@Param("tradeTotalAmountEnd") String tradeTotalAmountEnd,@Param("startTime") String startTime,@Param("endTime")  String endTime,@Param("weekNum") String weekNum,@Param("startDuration")  String startDuration,@Param("endDuration")  String endDuration,@Param("sort")  String sort,@Param("order")  String order,@Param("start") int start,@Param("size") int size);

    List<Map<String, Object>> getTradRecordConditionTotalNum(@Param("userId") String userId,@Param("commodityName") String commodityName,@Param("sellerName") String sellerName,@Param("tradeState") String tradeState,@Param("payMode")  String payMode,@Param("tradeTotalAmountStart") String tradeTotalAmountStart,@Param("tradeTotalAmountEnd") String tradeTotalAmountEnd,@Param("startTime") String startTime,@Param("endTime")  String endTime,@Param("weekNum") String weekNum,@Param("startDuration")  String startDuration,@Param("endDuration")  String endDuration,@Param("sort")  String sort,@Param("order")  String order);
}